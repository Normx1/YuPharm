package com.yu_pharm.controller.buy;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class CartBean {
	private List<Integer> ids = new ArrayList<Integer>();

	public synchronized void addItem(int id) {
		ids.add(id);
	}

	public synchronized List<Integer> getIds() {
		return new ArrayList<Integer>(ids);
	}

	public synchronized void removeItem(int id) {
		ids.remove(id);
	}

	public synchronized int getId(int id) {
		return ids.get(id);
	}

	public synchronized int length() {
		return ids.size();
	}

	public static CartBean get(HttpSession session) {
		CartBean cart = (CartBean) session.getAttribute("cart");
		if (cart == null) {
			cart = new CartBean();
			session.setAttribute("cart", cart);
		}
		return cart;
	}
}
