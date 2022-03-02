package com.codegym.service.impl;

import com.codegym.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public double calculator(String display, double number1, double number2) {
        double result = 0;
        switch (display) {
            case "Addition (+)":
                result = number1 + number2;
                break;
            case "Subtraction (-)":
                result = number1 - number2;
                break;
            case "Multiplication (*)":
                result = number1 * number2;
                break;
            case "Division (/)":
                if (number2 != 0)
                    result = number1 / number2;
                else throw new RuntimeException("division not zero");
                break;
            default:
                break;
        }
        return result;
    }
}
