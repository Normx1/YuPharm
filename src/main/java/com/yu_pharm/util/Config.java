package com.yu_pharm.util;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;
import java.util.function.Supplier;

public class Config {

	private static final Config config = new Config();

	private final List<Supplier<URI>> configs;
	private Properties properties = null;


	public Config() {
		this(List.of(
				new NamedSupplier<>("default", () -> Config.class.getClassLoader().getResource("config.properties").toURI()),
				new NamedSupplier<>("env", () -> Path.of(System.getenv("config")).toUri()),
				new NamedSupplier<>("jvm", () -> Path.of(System.getProperty("config")).toUri())
		));
	}

	public Config(List<Supplier<URI>> configs) {
		this.configs = configs;
	}


	public static String get(String key) {
		return config.getValue(key);
	}


	public String getValue(String key) {
		return load().getProperty(key);
	}

	private synchronized Properties load() {
		if (properties == null) {
			Properties result = new Properties();
			for (Supplier<URI> provider : configs) {
				try {
					Properties props = new Properties(result);
					URI uri = provider.get();
					try (Reader reader = new InputStreamReader(uri.toURL().openStream())) {
						props.load(reader);
					}
					result = props;
				} catch (Exception ex) {
					System.err.println("Failed to load config '" + provider + "'");
					ex.printStackTrace(System.err);
				}
			}
			this.properties = result;
		}
		return this.properties;
	}
}
