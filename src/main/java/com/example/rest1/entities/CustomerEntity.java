package com.example.rest1.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "person")
public class CustomerEntity implements Comparable<CustomerEntity>{

    @Id
    @GeneratedValue
    private Long customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address_1")
    private String address1;

    @Column(name = "suburb")
    private String suburb;

    @Column(name = "state")
    private String state;

    @Column(name = "post_code")
    private String postCode;


    @Override
    public int compareTo(CustomerEntity o) {

        int last = this.firstName.compareTo(o.firstName);

        return last == 0 ? this.firstName.compareTo(o.firstName) : last;
    }
}
