package com.example.crudwithsb;

import com.example.crudwithsb.controller.EmployeeController;
import com.example.crudwithsb.dto.EmployeeDto;
import com.example.crudwithsb.serviceImpl.EmployeeServiceImp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestController {
    @InjectMocks
    private EmployeeController employeeController;
    @Mock
    private EmployeeServiceImp employeeServiceImp;

    @Test
    public void testGetEmployeeByMapping() {
        EmployeeDto sd = EmployeeDto.builder().id(1l).firstName("Joy").lastName("Ltl").email("j.gmail").build();
        when(employeeServiceImp.getByIdEmp(1l)).thenReturn(sd);
        EmployeeDto dto = employeeController.getEmployeeById(1l).getBody();

        Assert.assertEquals("Joy", dto.getFirstName());
        Assert.assertEquals("Ltl", dto.getLastName());
        Assert.assertEquals("j.gmail", dto.getEmail());
    }

    @Test
    public void testGetAllEmployee() {
        EmployeeDto mdt1 = new EmployeeDto(1l, "Happy", "Ltl", "h.gmail");
        EmployeeDto mdt2 = new EmployeeDto(2l, "Faith", "Ltl", "h.gmail");
        List<EmployeeDto> mdto = new ArrayList<>();
        mdto.add(mdt1);
        mdto.add(mdt2);

        when(employeeServiceImp.getAllEmployee()).thenReturn(mdto);

        List<EmployeeDto> dto = employeeController.getAllEmployee().getBody();
        for (int i = 0; i < dto.size(); i++) {
            Assert.assertEquals(mdto.get(i), dto.get(i));
        }
    }

    @Test
    public void testCreatEmployee(){
        EmployeeDto mdto = EmployeeDto.builder().firstName("love").lastName("ltl").email("l.gmail").build();
        when(employeeServiceImp.creatEmployee(mdto)).thenReturn(mdto);

        EmployeeDto dto = employeeController.creatEmployee(mdto).getBody();
        Assert.assertEquals("ltl",dto.getLastName());
        Assert.assertEquals("love",dto.getFirstName());
        Assert.assertEquals("l.gmail",dto.getEmail());

    }

    @Test
    public void testUpdate(){
        EmployeeDto mdto = EmployeeDto.builder().id(1l).firstName("docho").lastName("tekle").email("d.gmail").build();

        when(employeeServiceImp.updateEmp(1l,mdto)).thenReturn(mdto);

        EmployeeDto dto = employeeController.updateEmployee(1l,mdto).getBody();
        Assert.assertEquals("docho",dto.getFirstName());
        Assert.assertEquals("tekle",dto.getLastName());
        Assert.assertEquals("d.gmail",dto.getEmail());
    }

   //    @Test
    //    public void testDeleteEmployee(){
   //      Mockito.when(employeeServiceImp.delete(1l)).thenReturn(ResponseEntity.status(HttpStatus.NO_CONTENT));
   //       employeeController.deleteEmployee(1l);
    //
    //    }

}