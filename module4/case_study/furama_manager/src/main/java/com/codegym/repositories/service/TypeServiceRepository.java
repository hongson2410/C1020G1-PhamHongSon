package com.codegym.repositories.service;

import com.codegym.models.service.TypeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface TypeServiceRepository extends JpaRepository<TypeService, Integer> {
}
