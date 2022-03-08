package com.codegym.repository;

import java.util.List;

public interface BlogRepository<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T t);

    void remove(Long id);
}
