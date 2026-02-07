package com.jimmygerman.creditcardcharger.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

//This tells spring to map to a DB table
@Entity
@Table(name = "transactions")
public class Transaction
{

    //This Generates a random ID for us
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardHolder;

    private Double amount;
    private String merchant;
    private String category;
    private LocalDateTime date;

    public Transaction()
    {}
    public Transaction(String cardHolder, Double amount, String merchant, String category){
        this.cardHolder = cardHolder;
        this.amount = amount;
        this.merchant = merchant;
        this.category = category;
        this.date = java.time.LocalDateTime.now();
    }
    public Long getID(){
        return id;
    }
    public Double getAmount(){
        return amount;
    }
    public String getCardHolder(){
        return cardHolder;
    }
    public String getMerchant(){
        return merchant;
    }
    public String getCategory(){
        return category;
    }
    public LocalDateTime getDate(){
        return date;
    }

}
