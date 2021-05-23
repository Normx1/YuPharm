package com.yu_pharm.util;

import java.util.function.Supplier;

public class NamedSupplier<T> implements Supplier<T> {

	private final Supplier<String> name;
	private final Supplier<T> supplier;


	public NamedSupplier(String name, UnsafeSupplier<T> supplier) {
		this(() -> name, supplier);
	}

	public NamedSupplier(Supplier<String> name, UnsafeSupplier<T> supplier) {
		this.name = name;
		this.supplier = supplier;
	}


	@Override
	public T get() {
		return supplier.get();
	}

	@Override
	public String toString() {
		return "NamedSupplier{" +
				"name=" + name.get() +
				", supplier=" + supplier +
				'}';
	}
}
