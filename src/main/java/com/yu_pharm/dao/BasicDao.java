package com.yu_pharm.dao;

import java.util.List;

public interface BasicDao<T> {
	List<T> getAll();

	T getById(int id);

	T deleteById(int id);

	T updateById(T model);

	T create(T model);

	T getByName(String name);

	List<T> getAllPagination(int i, int recordsPerPage);
}
