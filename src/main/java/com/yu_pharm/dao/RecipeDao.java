package com.yu_pharm.dao;

import com.yu_pharm.model.Order;
import com.yu_pharm.model.Recipe;

import java.util.List;

public interface RecipeDao<T> {
	List<T> getAll();

	T getById(int id);

	T deleteById(int id);

	T updateById(Recipe model);

	Recipe create(Recipe recipe);

	T getByUserName(String name);

	T getByDrugName(String name);

}



