package com.customer.service;

import com.customer.model.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();

    Province findById(int id);

    void save(Province province);

    void remove(int id);
}
