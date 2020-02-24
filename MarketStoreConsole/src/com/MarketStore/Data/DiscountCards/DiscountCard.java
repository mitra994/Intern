package com.MarketStore.Data.DiscountCards;


import com.MarketStore.Data.Customer;

public abstract class DiscountCard {

    private Customer cardOwner;
    private double discountRate;
    private double lastMonthTurnover;

    protected DiscountCard(Customer cardOwner){
        this.cardOwner = cardOwner;
    }

    protected DiscountCard(){

    }

    public abstract String getCardType();

    protected abstract void calculateDiscountRate();

    public abstract void setTurnover(double turnover);

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

    protected void setLastMonthTurnover(double lastMonthTurnover) {
        this.lastMonthTurnover = lastMonthTurnover;
    }
}
