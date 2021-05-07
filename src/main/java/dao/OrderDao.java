package dao;

import java.util.List;

public interface OrderDao<T> {
    List<T> getAll();

    T getById(int id);

    T deleteById(int id);

    T updateById(T model);

    T create(T model);
}
