package com.faisal.springboottutorial.controllers;

import com.faisal.springboottutorial.dto.EmployeeDTO;
import com.faisal.springboottutorial.entities.EmployeeEntity;
import com.faisal.springboottutorial.repositories.EmployeeRespository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {
//    @GetMapping(path="/getSecretMessage")
//    public String getMySuperSecretMessage()
//    {
//        return "Secret Message: Work hard until you succeed";
//    }

    private final EmployeeRespository employeeRespository;

    public EmployeeController(EmployeeRespository employeeRespository) {
        this.employeeRespository = employeeRespository;
    }

    @GetMapping(path="/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id){
        return employeeRespository.findById(id).orElse(null);
    }
    @GetMapping
    public List<EmployeeEntity> getAllEmployee(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){
        return employeeRespository.findAll();
    }
    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employeeDTO){
        return employeeRespository.save(employeeDTO);
    }
    @PutMapping(path="/{id}")
    public String updateEmployeeId(@PathVariable Long id){
        return "The employee whose data has to be replace is"+id;

    }
}
