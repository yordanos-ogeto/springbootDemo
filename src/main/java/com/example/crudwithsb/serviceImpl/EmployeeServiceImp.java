package com.example.crudwithsb.serviceImpl;


import com.example.crudwithsb.dto.EmployeeDto;
import com.example.crudwithsb.exception.ResourceNotFound;
import com.example.crudwithsb.model.Employee;
import com.example.crudwithsb.repository.EmployeeRepository;
import com.example.crudwithsb.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> emplo = repository.findAll();
        List<EmployeeDto> dtoEmpl = new ArrayList<>();
        emplo.forEach((employee) -> {
            dtoEmpl.add(mapper.map(employee, EmployeeDto.class));
        });
        return dtoEmpl;
    }

    @Override
    public EmployeeDto getByIdEmp(Long id) {
        Employee em = repository.findById(id).orElseThrow(() -> new ResourceNotFound("Employee not found with this id : " + id));
        EmployeeDto dtoEmp = mapper.map(em, EmployeeDto.class);
        return dtoEmp;
    }

    @Override
    public EmployeeDto updateEmp(Long id, EmployeeDto employeeDto) {
        Employee em = repository.findById(id).orElseThrow(() -> new ResourceNotFound("Employee not found with this id" + id));
        em.setEmail(employeeDto.getEmail());
        em.setLastName(employeeDto.getLastName());
        em.setFirstName(employeeDto.getFirstName());
        Employee save = repository.save(em);
        EmployeeDto empDto = mapper.map(save, EmployeeDto.class);
        return empDto;
    }

    @Override
    public EmployeeDto creatEmployee( EmployeeDto employeeDto) {
        Employee emp = new Employee();
        emp.setFirstName(employeeDto.getFirstName());
        emp.setLastName(employeeDto.getLastName());
        emp.setEmail(employeeDto.getEmail());
        Employee saveEmployee = repository.save(emp);
        EmployeeDto dto = mapper.map(saveEmployee,EmployeeDto.class);
        return dto;
    }

    @Override
    public void delete(Long id) {
        Employee em = repository.findById(id).orElseThrow(()->new ResourceNotFound("Employee with this id Not found "+id));
         repository.delete(em);

    }
}
