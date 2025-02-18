package com.BankingSys.bankingSystem;

import jakarta.persistence.Entity; // creating table in a relational database
import jakarta.persistence.GeneratedValue; // this for create automatic column in database
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter // this is lombok feature
@Setter // ``
@Entity // creating table in a relational database
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this for create automatic column in database
    private Long id;
    private String accountHolderName;
    private double balance;

}
