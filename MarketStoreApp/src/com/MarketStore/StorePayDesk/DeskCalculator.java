package com.MarketStore.StorePayDesk;

import com.MarketStore.Data.DiscountCards.DiscountCard;

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
