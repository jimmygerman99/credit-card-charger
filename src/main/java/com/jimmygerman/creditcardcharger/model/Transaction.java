package com.jimmygerman.creditcardcharger.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

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

    @NotBlank(message = "Card holder is required")
    private String cardHolder;

    @NotNull(message = "Amount is required")
    @Min(value = 1, message = "Amount must be at least 1")
    private Double amount;

    @NotBlank(message = "Merchant is required")
    private String merchant;

    @NotBlank(message = "Category is required")
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
