package com.example.crudwithsb.controller;


import com.example.crudwithsb.dto.EmployeeDto;
import com.example.crudwithsb.serviceImpl.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@RequestMapping("/api/v1/emplo")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class EmployeeController {
    @Autowired
    private EmployeeServiceImp serviceImp;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
        List<EmployeeDto> dto = serviceImp.getAllEmployee();
        if (dto.isEmpty()) {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        EmployeeDto dto = serviceImp.getByIdEmp(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable long id, @RequestBody EmployeeDto employeeDto) {
        EmployeeDto dto = serviceImp.updateEmp(id, employeeDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<EmployeeDto> creatEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto dtoEmp = serviceImp.creatEmployee(employeeDto);
        return new ResponseEntity<>(dtoEmp, HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){
         serviceImp.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
