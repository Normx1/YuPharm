package com.yu_pharm.model.drug;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleDrugs implements Drugs<Drug> {

	private final AtomicInteger counter = new AtomicInteger();
	private final Map<Integer, Drug> drugs = new LinkedHashMap<>();


	public SimpleDrugs() {
		this(List.of());
	}

	public SimpleDrugs(List<Map<String, Object>> drugs) {
		for (Map<String, Object> data : drugs) {
			int id = counter.getAndIncrement();
			this.drugs.put(id, new SimpleDrug(id, data));
		}
	}


	@Override
	public Drug create() {
		int id = counter.getAndIncrement();
		Drug value = new SimpleDrug(id, new LinkedHashMap<>());
		drugs.put(id, value);
		return value;
	}

	@Override
	public List<Drug> all() {
		return new ArrayList<>(drugs.values());
	}
}
