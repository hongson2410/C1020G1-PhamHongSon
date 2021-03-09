package com.phone.service;

import com.phone.models.SmartPhone;

import java.util.List;

public interface SmartPhoneService {
    List<SmartPhone> findAll();

    SmartPhone findById(Integer id);

    SmartPhone save(SmartPhone phone);

    SmartPhone remove(Integer id);
}
