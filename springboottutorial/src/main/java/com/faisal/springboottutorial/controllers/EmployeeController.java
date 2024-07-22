package com.faisal.springboottutorial.controllers;

import com.faisal.springboottutorial.dto.EmployeeDTO;
import com.faisal.springboottutorial.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long id){
        Optional<EmployeeDTO> employeeDTO= employeeService.getEmployeeById(id);
        return employeeDTO.map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1)).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity< List<EmployeeDTO>> getAllEmployee(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }
    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO employeeDTO1=employeeService.creatNewEmployee(employeeDTO);
        return new ResponseEntity<>(employeeDTO1, HttpStatus.CREATED);
    }
    @PutMapping(path="/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployeeId(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO employeeDTO1= employeeService.updateEmployeeid(id,employeeDTO);
        if(employeeDTO1==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO1);

    }
    @DeleteMapping(path="/{id}")
    public String deleteEmployeeById(@PathVariable  Long id){
       return  employeeService.deleteEmployeeById(id);
    }
    @PatchMapping(path="/{id}")
    public ResponseEntity<EmployeeDTO> patchEmployeeById(@RequestBody Map<String, Object> values,
                                         @PathVariable Long id){
        EmployeeDTO employeeDTO=employeeService.patchEmployeeById(values,id);
        if(employeeDTO==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }
}
