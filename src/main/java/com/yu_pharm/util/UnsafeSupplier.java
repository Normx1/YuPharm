package com.yu_pharm.util;

import java.util.function.Supplier;

@FunctionalInterface
public interface UnsafeSupplier<T> extends Supplier<T> {

	@Override
	default T get() {
		try {
			return getUnsafe();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	T getUnsafe() throws Exception;
}
