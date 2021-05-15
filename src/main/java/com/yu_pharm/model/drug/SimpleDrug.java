package com.yu_pharm.model.drug;

import java.util.Map;

public class SimpleDrug implements Drug {

	private final int id;
	private final Map<String, Object> data;


	public SimpleDrug(int id, Map<String, Object> data) {
		this.id = id;
		this.data = data;
	}


	@Override
	public int id() {
		return id;
	}

	@Override
	public void delete() {
		data.clear();
	}

	@Override
	public <T> T get(String key, Class<T> type) {
		return type.cast(data.get(key));
	}

	@Override
	public <T> void set(String key, T value) {
		data.put(key, value);
	}
}
