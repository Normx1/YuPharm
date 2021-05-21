package com.yu_pharm.controller.buy;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CartBean {
	private Set<Integer> ids = new HashSet<Integer>();

	public synchronized void addItem(int id) {
		ids.add(id);
	}

	public synchronized Set<Integer> getIds() {
		return new HashSet<Integer>(ids);
	}

	public synchronized void removeItem(int id) {
		ids.remove(id);
	}
//
//	public synchronized int getId(int id) {
//		return ids.get(id);
//	}

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
