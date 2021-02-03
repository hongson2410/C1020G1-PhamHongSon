package model.repo;

import model.bean.Customer;
import model.bean.Employee;
import model.bean.Villa;

import java.util.List;

public interface FuramaRepository<T>{
    List<T> findAll();

    T selectById(String id);


    void update(T t);

    void delete(String id);


    List<T> searchName(String name);

    void add(T t);
}
