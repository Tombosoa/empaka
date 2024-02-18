package com.javaadr.renderapi.Service;

import com.javaadr.renderapi.Entity.Salary;
import com.javaadr.renderapi.Repository.SalaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {
    private final SalaryRepository salaryRepository;
    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    public List<Salary> getSalaries(){
        return salaryRepository.findAll();
    }
}
