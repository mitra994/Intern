package com.MarketStore.Data.DiscountCards;


import com.MarketStore.Data.Customer;

public abstract class DiscountCard {

    private Customer cardOwner;
    private double discountRate;
    private double lastMonthTurnover;

    protected DiscountCard(Customer cardOwner,double lastMonthTurnover){
        this.cardOwner = cardOwner;
        this.lastMonthTurnover = lastMonthTurnover;
    }

    protected DiscountCard(){

    }

    public abstract String getCardType();

    public Customer getCardOwner() {
        return cardOwner;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    protected void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getLastMonthTurnover() {
        return lastMonthTurnover;
    }

    public void setLastMonthTurnover(double lastMonthTurnover) {
        this.lastMonthTurnover = lastMonthTurnover;
    }
}
