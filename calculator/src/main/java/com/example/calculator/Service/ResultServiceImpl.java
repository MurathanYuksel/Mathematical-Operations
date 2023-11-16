package com.example.calculator.Service;

//ResultServiceImpl.java

import com.example.calculator.Model.Result;
import com.example.calculator.Repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    private final ResultRepository resultRepository;

    @Autowired
    public ResultServiceImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public Result saveResult(Long userId, double result) {
        Result newResult = new Result();
        newResult.setUserId(userId);
        newResult.setResult(result);
        return resultRepository.save(newResult);
    }

    @Override
    public List<Result> getResultByUserId(Long userId) {
        return resultRepository.findByUserId(userId);
    }
}