package com.yu_pharm.dao;

import com.yu_pharm.model.Order;

import java.util.List;

public interface OrderDao<T> {
    List<T> getAll();

    T getByOrderId(int orderId);

    T getByUserId(int userId);

    T getByUserName(String userName);

	T deleteById(int id);


    Object updateById(Order order);

    Object create(Order order);

}
