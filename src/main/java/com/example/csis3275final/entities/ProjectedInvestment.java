package com.example.csis3275final.entities;

public class ProjectedInvestment {

    private int year;
    private double startingAmount;
    private double interest;
    private double endingBalance;
    private boolean savingsType;

    void calculateInterest(){
       if(savingsType = true){
           endingBalance=startingAmount*.15;
    } else {
           endingBalance=startingAmount*.10;
       }


    }
}
