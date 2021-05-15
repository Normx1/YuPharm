package com.yu_pharm.model;

public interface Data {

	<T> T get(String key, Class<T> type);

	<T> void set(String key, T value);
}
