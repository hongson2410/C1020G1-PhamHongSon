package com.service.impl;

import com.service.CalculatorService;
import org.springframework.stereotype.Repository;

@Repository
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public Double calculator(double input_1, double input_2, String operator) {
        Double result;
        switch (operator) {
            case "Addition(+)":
                result = input_1 + input_2;
                break;
            case "Subtraction(-)":
                result = input_1 - input_2;
                break;
            case "Multiplication(X)":
                result = input_1 * input_2;
                break;
            default:
                result = input_1 / input_2;
        }
        return result;
    }
}
