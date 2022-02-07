package com.example.crudwithsb.service;


import com.example.crudwithsb.dto.EmployeeDto;
import com.example.crudwithsb.model.Employee;
import java.util.List;

public interface EmployeeService {
 List<EmployeeDto> getAllEmployee();
 EmployeeDto getByIdEmp(Long id);
 EmployeeDto updateEmp(Long id,EmployeeDto employeeDto) ;
 EmployeeDto creatEmployee(EmployeeDto employeeDto);
 void delete(Long id);
}
