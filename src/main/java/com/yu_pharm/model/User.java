package com.yu_pharm.model;


public class User<T> {
	private int id;
	private String name;
	private String password;
	private String mail;
	private T role;


	public User() {
	}

	public User(int id, String name, String password, String mail, T role) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.mail = mail;
		this.role = role;
	}


	public User(int id, String name, String password, String mail) {
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

	public User(int id, String name, String mail, T role) {
		this.id = id;
		this.name = name;
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

	public T getRole() {
		return role;
	}

	public void setRole(T role) {
		this.role = role;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public User(String name, String password, String mail, T role) {
		this.name = name;
		this.password = password;
		this.mail = mail;
		this.role = role;
	}
}
