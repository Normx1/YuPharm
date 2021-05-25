package com.yu_pharm.model;


import java.util.Set;

public class User{
	private int id;
	private String name;
	private String password;
	private String mail;
	private Set<Role> role;


	public User() {
	}

	public User(int id, String name, String mail, String password, Set<Role> role) {
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

	public User(int id, String name, String mail, Set<Role> role) {
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.role = role;
	}

	public User(String name, String mail, String password, Set<Role> role) {
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

	public Set<Role> getRoles() {
		return  role;
	}

	public void setRoles(Set<Role> role) {
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
