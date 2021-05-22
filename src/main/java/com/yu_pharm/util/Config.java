package com.yu_pharm.util;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Config {

	private static final Config config;

	private final Map<String, String> configs;
	private Properties properties = null;


	static {
		Map<String, String> configs = new LinkedHashMap<>();
		configs.put("default", Objects.toString(Config.class.getResource("config"), null));
		configs.put("env", System.getenv("config"));
		configs.put("jvm", System.getProperty("config"));
		config = new Config(configs);
	}


	public Config(Map<String, String> configs) {
		this.configs = configs;
	}


	public static String get(String key) {
		return config.load().getProperty(key);
	}

	private synchronized Properties load() {
		if (properties == null) {
			Properties result = new Properties();
			for (Map.Entry<String, String> e : configs.entrySet()) {
				try {
					Properties props = new Properties(result);
					Path path = Path.of(e.getValue());
					try (Reader reader = Files.newBufferedReader(path)) {
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
