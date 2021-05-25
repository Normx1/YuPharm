package com.yu_pharm.dao;

import com.yu_pharm.model.Role;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

	@Test
	public void test1() {
		Set<Role> roles = EnumSet.of(Role.Admin, Role.Viewer, Role.User);
		long converted = Role.getRolesValue(roles);
		Set<Role> parsed = Role.getRoles(converted);
		assertEquals(roles, parsed);
	}
}
