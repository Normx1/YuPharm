package com.yu_pharm.dao;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderDao_ImpTest {

	@Test
	public void drugsFormat() {
		Map<Integer, Integer> map = Map.of(1, 2, 3, 4);
		String result = OrderDao_Imp.formatDrugs(map);
		assertEquals("{1=2,3=4}", result);
	}
}
