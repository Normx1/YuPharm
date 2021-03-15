package org.example;

import java.util.List;

public interface Repository<T> {
    List<T> list();
}
