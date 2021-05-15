package com.yu_pharm.model;

public class Order<T, T1> {
	private int id_Order;
	private T drug;
	private T1 user;
	private String mail;
	private String phone;
	private String address;
	private int cost;
	private int payment;

	public int getId_Order() {
		return id_Order;
	}

	public void setId_Order(int id_Order) {
		this.id_Order = id_Order;
	}

	public T getDrug() {
		return drug;
	}

	public void setDrug(T drug) {
		this.drug = drug;
	}

	public T1 getUser() {
		return user;
	}

	public void setUser(T1 user) {
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}


	public Order(int id_Order, T drug, T1 user, String mail, String phone, String address, int cost, int payment) {
		this.id_Order = id_Order;
		this.drug = drug;
		this.user = user;
		this.mail = mail;
		this.phone = phone;
		this.address = address;
		this.cost = cost;
		this.payment = payment;
	}

	public Order() {
	}



	public Order(int id_Order, T drug, T1 user, int cost) {
		this.id_Order = id_Order;
		this.drug = drug;
		this.user = user;
		this.cost = cost;
 	}

	public Order(T drug, T1 user, String mail, String phone, String address, int payment , int cost) {
		this.drug = drug;
		this.user = user;
		this.mail = mail;
		this.phone = phone;
		this.address = address;
		this.cost = cost;
		this.payment = payment;
 	}
}
