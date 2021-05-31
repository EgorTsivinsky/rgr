package com.rgr.orderManagement.service;

import java.util.List;

public interface GenericService <T>{
    void save(T t);

    List<T> findAll();

    T findById(Long id);

    void delete(Long id);
}
