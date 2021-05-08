package com.yu_pharm.dao;

import java.util.List;

public interface BasicDao<T> {
    List<T> getAll();

    T getById(int id);

    T deleteById(int id);

    T updateById(T model);

    T create(T model);
    // TODO: 09.05.2021 Сдеалать поиск по имени

}
