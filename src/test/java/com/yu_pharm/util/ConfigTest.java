package com.yu_pharm.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigTest {

	@Test
	void get() {
		assertEquals("13", new Config().getValue("hi"));
	}
}
