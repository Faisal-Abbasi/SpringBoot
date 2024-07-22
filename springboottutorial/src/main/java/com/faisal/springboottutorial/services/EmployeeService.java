package com.faisal.springboottutorial.services;

import com.faisal.springboottutorial.dto.EmployeeDTO;
import com.faisal.springboottutorial.entities.EmployeeEntity;
import com.faisal.springboottutorial.repositories.EmployeeRespository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;


import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRespository employeeRespository;

    private final ModelMapper modelmapper;


    public EmployeeService(EmployeeRespository employeeRespository, ModelMapper modelmapper) {
        this.employeeRespository = employeeRespository;
        this.modelmapper = modelmapper;
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
       return employeeRespository.findById(id).map(employeeEntity ->
           modelmapper.map(employeeEntity, EmployeeDTO.class)
       );
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

    public EmployeeDTO updateEmployeeid(Long id, EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity= modelmapper.map(employeeDTO,EmployeeEntity.class);
        employeeEntity.setId(id);
        EmployeeEntity saveEmployeeEntity=employeeRespository.save(employeeEntity);

        return modelmapper.map(saveEmployeeEntity,EmployeeDTO.class);
    }

    public String deleteEmployeeById(Long id) {
        boolean exists=employeeRespository.existsById(id);
        if(exists){
            employeeRespository.deleteById(id);
            return "employee deleted successfully";
        }
        return "employee does not exists in our db";

    }

    public EmployeeDTO patchEmployeeById(Map<String, Object> updates, Long id) {
        System.out.println(updates);
        boolean exists=employeeRespository.existsById(id);
        if(!exists) return null;
        EmployeeEntity employeeEntity= employeeRespository.findById(id).get();
        updates.forEach((field,value)->{
           Field fieldToBeUpdated= ReflectionUtils.findRequiredField(EmployeeEntity.class,field);
           fieldToBeUpdated.setAccessible(true);
           ReflectionUtils.setField(fieldToBeUpdated,employeeEntity,value);
        });
        System.out.println(employeeEntity);
        return modelmapper.map(employeeRespository.save(employeeEntity), EmployeeDTO.class);
    }
}
