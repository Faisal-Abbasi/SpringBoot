package com.faisal.springboottutorial.services;

import com.faisal.springboottutorial.dto.EmployeeDTO;
import com.faisal.springboottutorial.entities.EmployeeEntity;
import com.faisal.springboottutorial.repositories.EmployeeRespository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRespository employeeRespository;

    private final ModelMapper modelmapper;


    public EmployeeService(EmployeeRespository employeeRespository, ModelMapper modelmapper) {
        this.employeeRespository = employeeRespository;
        this.modelmapper = modelmapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity= employeeRespository.findById(id).orElse(null);
        return modelmapper.map(employeeEntity, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployee() {
        List<EmployeeEntity> employeeEntities= employeeRespository.findAll();
      return  employeeEntities.stream()
                .map(employeeEntity -> modelmapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO creatNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity= employeeRespository.save(modelmapper.map(employeeDTO,EmployeeEntity.class));
        return modelmapper.map(employeeEntity,EmployeeDTO.class);
    }
}
