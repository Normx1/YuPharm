package com.yu_pharm.dao;

public enum Role {
	//	Viewer,
//	Customer,
//	Pharmacist,
//	Doctor,
//	Admin,
//	SuperAdmin

	user("user"),
	pharmacist("pharmacist"),
	admin("admin"),
	superAdmin("superAdmin");

	private final String key;

	Role(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}


