package com.example.crudwithsb;

import com.example.crudwithsb.model.Employee;
import com.example.crudwithsb.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudWithSbApplication implements CommandLineRunner {
    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(CrudWithSbApplication.class, args);
    }

    @Autowired
    private EmployeeRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Employee em1 = new Employee();
        em1.setFirstName("Joy");
        em1.setLastName("Ltl");
        em1.setEmail("j.@gmail.com");
        repository.save(em1);
    }
}
