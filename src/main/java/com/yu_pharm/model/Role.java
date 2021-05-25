package com.yu_pharm.model;

import java.util.EnumSet;
import java.util.Set;

public enum Role {

	Viewer("viewer", 1),
	User("user", 1 << 1),
	Pharmacist("pharmacist", 1 << 2),
	//Doctor("doctor", 1 << 3),
	Admin("admin", 1 << 4),
	SuperAdmin("superAdmin", 1 << 5);

	private final String key;
	private final long flag;


	Role(String key, long flag) {
		this.key = key;
		this.flag = flag;
	}


	public String getKey() {
		return key;
	}


	public static EnumSet<Role> getRoles(long value) {
		EnumSet<Role> roles = EnumSet.noneOf(Role.class);
		for (Role role : Role.values()) {
			if ((role.flag & value) == role.flag) {
				roles.add(role);
			}
		}
		return roles;
	}

	public static long getRolesValue(Set<Role> roles) {
		long value = 0;
		for (Role role : roles) {
			value |= role.flag;
		}
		return value;
	}
}


