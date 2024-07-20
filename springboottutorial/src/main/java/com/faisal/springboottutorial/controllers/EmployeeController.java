package com.faisal.springboottutorial.controllers;

import com.faisal.springboottutorial.dto.EmployeeDTO;
import com.faisal.springboottutorial.entities.EmployeeEntity;
import com.faisal.springboottutorial.repositories.EmployeeRespository;
import com.faisal.springboottutorial.services.EmployeeService;
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

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id){
        return employeeService.getEmployeeById(id);
    }
    @GetMapping
    public List<EmployeeDTO> getAllEmployee(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){
        return employeeService.getAllEmployee();
    }
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.creatNewEmployee(employeeDTO);
    }
    @PutMapping(path="/{id}")
    public String updateEmployeeId(@PathVariable Long id){
        return "The employee whose data has to be replace is"+id;

    }
}
