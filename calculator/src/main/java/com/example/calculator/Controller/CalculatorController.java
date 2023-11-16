package com.example.calculator.Controller;

import com.example.calculator.Model.Calculation;
import com.example.calculator.Model.Result;
import com.example.calculator.Service.CalculatorService;
import com.example.calculator.Service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    private final CalculatorService calculatorService;
    private final ResultService resultService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService, ResultService resultService) {
        this.calculatorService = calculatorService;
        this.resultService = resultService;
    }

    @PostMapping("/calculate")
    public double calculate(@RequestBody Calculation calculation) {
        return calculatorService.calculate(calculation);
    }

    /*
    Bir farklı yöntem (http uzantısında yapilacak
     islemin tek tek belirtilmesi):
    */

   /* @PostMapping("/add")
    public double addNumbers(@RequestBody Calculation calculation) {
        return calculatorService.calculate(calculation);
    }
    @PostMapping("/subtract")
    public double subtractNumbers(@RequestBody Calculation calculation) {
        return calculatorService.calculate(calculation);
    }
    @PostMapping("/multiply")
    public double multiplyNumbers(@RequestBody Calculation calculation) {
        return calculatorService.calculate(calculation);
    }
     @PostMapping("/division")
    public double multiplyNumbers(@RequestBody Calculation calculation) {
        return calculatorService.calculate(calculation);
    }*/

    @PostMapping("/save-result")
    public Result saveResult(@RequestParam Long userId, @RequestParam double result) {
        return resultService.saveResult(userId, result);
    }

    @GetMapping("/get-result/{userId}")
    public List<Result> getResult(@PathVariable Long userId) {
        return resultService.getResultByUserId(userId);
    }
}