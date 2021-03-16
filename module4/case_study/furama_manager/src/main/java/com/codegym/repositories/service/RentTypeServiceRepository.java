package com.codegym.repositories.service;

import com.codegym.models.service.RentTypeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface RentTypeServiceRepository extends JpaRepository<RentTypeService, Integer> {
}
