package com.codegym.services;

import com.codegym.models.employee.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAllPosition();
}
