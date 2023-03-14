package com.example.rest1;

import com.example.rest1.entities.CustomerEntity;
import com.example.rest1.respositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Rest1ApplicationTests {


    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void findAllCustomers(){
//        Iterable<CustomerEntity> customers = customerRepository.findAll();
//        System.out.println();
    }

}
