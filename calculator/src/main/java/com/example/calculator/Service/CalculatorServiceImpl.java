package com.example.calculator.Service;

import com.example.calculator.Model.Calculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.calculator.Service.ResultService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private  final ResultService resultService;
    @Autowired
    public CalculatorServiceImpl(ResultService resultService) {
        this.resultService = resultService;
    }
    @Override
    public double calculate(Calculation calculation) {
        double number1 = calculation.getNumber1();
        double number2 = calculation.getNumber2();
        String operation = calculation.getOperation();
        double result;
        Long userId= (long) 0;

        switch (calculation.getOperation()) {
            case "add":
                result = calculation.getNumber1() + calculation.getNumber2();
                break;
            case "subtract":
                result = calculation.getNumber1() - calculation.getNumber2();
                break;
            case "multiply":
                result = calculation.getNumber1() * calculation.getNumber2();
                break;
            case "divide":
                if (calculation.getNumber2() != 0) {
                    result = calculation.getNumber1() / calculation.getNumber2();
                } else {
                    throw new ArithmeticException("Sıfıra bölünemez.");
                }
                break;
            default:
                throw new IllegalArgumentException("Geçersiz İşlem: " + calculation.getOperation());
        }
        resultService.saveResult(calculation.getUserId(), result);
        return result;
    }
}
