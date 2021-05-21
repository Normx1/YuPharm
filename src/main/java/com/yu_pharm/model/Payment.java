package com.yu_pharm.model;

public enum Payment {
	ByCardOnline("orderDetail.Payment.Card.Now"),
	ByCardOnDelivery("orderDetail.Payment.Card.Leter"),
	Cash("orderDetail.Payment.Pay.Money");

	private final String key;

	Payment(String key) {
		this.key =key;
	}

	public String getKey() {
		return key;
	}
}
