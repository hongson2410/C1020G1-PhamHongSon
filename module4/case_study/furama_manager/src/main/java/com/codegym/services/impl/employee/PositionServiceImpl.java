package com.codegym.services.impl.employee;

import com.codegym.models.employee.Position;
import com.codegym.repositories.employee.PositionRepository;
import com.codegym.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;

    @Override
    public List<Position> findAllPosition() {
        return positionRepository.findAll();
    }
}
