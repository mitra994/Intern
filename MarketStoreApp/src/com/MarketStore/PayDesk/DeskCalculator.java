package com.MarketStore.PayDesk;

import com.MarketStore.DiscountCards.DiscountCard;

public class DeskCalculator {


    private DiscountCard discountCard;

    public DeskCalculator(DiscountCard discountCard){
        this.discountCard = discountCard;
    }


    public double calculateTotal(double purchaseValue){

        return purchaseValue - calculateDiscount(purchaseValue);

    }

    public double calculateDiscount(double purchaseValue){
        return purchaseValue * discountCard.getDiscountRate() /100;
    }




}
