package com.yu_pharm.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
	private int id;
	private Map<Integer, Integer> drugs = new LinkedHashMap<>();
	private String user;
	private String mail;
	private String phone;
	private String address;
	private double cost;
	private Payment payment;

	public Order() {
 	}

	public Order(int id) {
		this.id = id;
	}

	public Order(int id, Map<Integer, Integer> drugs, String user, String mail, String phone, String address, double cost, Payment payment) {
		this.id = id;
		this.drugs = drugs;
		this.user = user;
		this.mail = mail;
		this.phone = phone;
		this.address = address;
		this.cost = cost;
		this.payment = payment;
	}

	public Order(Map<Integer, Integer> drugs, String user, String mail, String phone, String address, double cost, Payment payment) {
		this.drugs = drugs;
		this.user = user;
		this.mail = mail;
		this.phone = phone;
		this.address = address;
		this.cost = cost;
		this.payment = payment;
	}

	public void addDrug(int id, int count) {
		drugs.put(id, drugs.getOrDefault(id, 0) + count);
	}

	public void removeDrug(int id, int count) {
		drugs.put(id, drugs.getOrDefault(id, 0) - count);
		drugs.entrySet().removeIf(e -> e.getValue() < 0);
	}

	public int getId() {
		return id;
	}

	public String getUser() {
		return user;
	}

	public Map<Integer, Integer> getDrugs() {
		return drugs;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getCost() {
		return cost;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}
