package com.MarketStore.Data;

import com.MarketStore.Data.DiscountCards.DiscountCard;

public class Customer {

    private int customerId;
    private String customerName;
    private DiscountCard discountCard;

    public Customer(int customerId,String customerName){
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public Customer(){

    }

    public String getCustomerName() {
        return customerName;
    }

    public void setDiscountCard(DiscountCard discountCard){
        this.discountCard = discountCard;
    }

    public DiscountCard getDiscountCard(){
        return this.discountCard;
    }
}
