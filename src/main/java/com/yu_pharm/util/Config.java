package com.yu_pharm.util;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class Config {

	private static final Config config = new Config();

	private final Map<String, String> configs;
	private Properties properties = null;


	public Config() {
		this(new LinkedHashMap<>());
		configs.put("default", Objects.toString(Config.class.getClassLoader().getResource("config.properties"), null));
		configs.put("env", System.getenv("config"));
		configs.put("jvm", System.getProperty("config"));
	}

	public Config(Map<String, String> configs) {
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
			for (Map.Entry<String, String> e : configs.entrySet()) {
				try {
					Properties props = new Properties(result);
					URI uri = URI.create(e.getValue());
					try (Reader reader = new InputStreamReader(uri.toURL().openStream())) {
						props.load(reader);
					}
					result = props;
				} catch (Exception ex) {
					System.err.println("Failed to load '" + e.getKey() + "' config");
				}
			}
			this.properties = result;
		}
		return this.properties;
	}
}
