package model.service;

import model.bean.Customer;
import model.bean.Employee;
import model.bean.Villa;

import java.util.List;

public interface FuramaService<T> {
    List<T> findAll();

    T selectById(String id);

    void update(T t);

    void delete(String id,String access);

    List<T> searchByName(String name);

    String add(T t);
}
