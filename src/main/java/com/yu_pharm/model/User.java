package com.yu_pharm.model;


import com.yu_pharm.dao.Role;

public class User{
	private int id;
	private String name;
	private String password;
	private String mail;
	private Role role;


	public User() {
	}

	public User(int id, String name, String mail, String password, Role role) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.mail = mail;
		this.role = role;
	}


	public User(int id, String name, String mail, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.mail = mail;
	}

	public User(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public User(int id, String name, String mail, Role role) {
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.role = role;
	}

	public User(String name, String mail, String password, Role role) {
		this.name = name;
		this.password = password;
		this.mail = mail;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public Role getRole() {
		return  role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}


}
