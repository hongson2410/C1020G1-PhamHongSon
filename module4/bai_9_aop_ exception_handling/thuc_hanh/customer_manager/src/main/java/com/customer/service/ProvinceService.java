package com.customer.service;

import com.customer.model.Province;

public interface ProvinceService {
    Iterable<Province> findAll();

    Province findById(int id);

    void save(Province province);

    void remove(int id);
}
