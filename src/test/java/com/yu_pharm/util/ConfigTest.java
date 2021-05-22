package com.yu_pharm.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigTest {

	@Test
	void get() {
		String key = "hi";
		String noValue = "12";
		String value = "test";
		System.setProperty(key, noValue);
		assertEquals(noValue, new Config().getValue(key));
		System.setProperty(key, value);
		assertEquals(value, new Config().getValue(key));
	}
}
