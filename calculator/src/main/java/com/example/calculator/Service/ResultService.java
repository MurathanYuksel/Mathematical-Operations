package com.example.calculator.Service;



import com.example.calculator.Model.Result;

import java.util.List;

public interface ResultService {
    Result saveResult(Long userId, double result);
    List<Result> getResultByUserId(Long userId);

}