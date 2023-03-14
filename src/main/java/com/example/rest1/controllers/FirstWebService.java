package com.example.rest1.controllers;

import com.example.rest1.entities.CustomerEntity;
import com.example.rest1.respositories.CustomerRepository;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@RestController
public class FirstWebService {

    private Logger logger = LoggerFactory.getLogger(FirstWebService.class);

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    public String index(){
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/findAllCustomers")
    public String findCustomers(){
        logger.debug("about to call find all customers");
        return new Gson().toJson(findAllCustomers());
    }

    private List<CustomerEntity> findAllCustomers(){

        List<CustomerEntity> customers = new ArrayList<>();
        logger.debug("inside find all customers");
        Iterable<CustomerEntity> personList = customerRepository.findAll();

        personList.forEach(person -> customers.add(person));

//        while(personList.iterator().hasNext()){
//            CustomerEntity customerEntity = persons.next();
//            System.out.println("firstname ="+customerEntity.getFirstName() +" lastName = "+customerEntity.getLastName()+" postcde = "+customerEntity.getPostCode());
//            customers.add(customerEntity);
//        }

        Collections.sort(customers, Collections.reverseOrder());

        for(CustomerEntity customer : customers){
            System.out.println("firstname ="+customer.getFirstName() +" lastName = "+customer.getLastName()+" postcde = "+customer.getPostCode());
        }


        return customers;
    }

}
