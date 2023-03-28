package org.expample;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class User {
    private double balance;
    private String userId;

    private LocalDate registrationDate;
    private double digit = 0;

    private int successfulTransaction;
    private String paymentComment;


    public User() {
        this.paymentComment = "";
        this.userId = UUID.randomUUID().toString();
        this.balance = 5000;
        registrationDate = LocalDate.now();
        this.successfulTransaction = 0;

    }

    public int getDaysSinceRegistration() {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(registrationDate, currentDate);
        return period.getDays();
    }

    public double getBalance(){
        return this.balance;
    }
    public void addBalance(double amount){
        this.balance += amount;
    }
    public String getUserId(){
        return this.userId;
    }
    public void setComment(String s){
        this.paymentComment = s;
    }
    public String getPaymentComment(){
        return paymentComment;
    }
    public void setDigit(double digit){
        this.digit = digit;
    }
    public double getDigit(){
        return this.digit;
    }


    public int getSuccessfulTransaction(){
        return this.successfulTransaction;
    }



}
