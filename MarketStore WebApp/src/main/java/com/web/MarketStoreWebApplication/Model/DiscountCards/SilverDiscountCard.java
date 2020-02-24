package com.web.MarketStoreWebApplication.Model.DiscountCards;

import com.web.MarketStoreWebApplication.Model.Customers;
import com.web.MarketStoreWebApplication.Model.DiscountCard;

import javax.persistence.Entity;

@Entity
public class SilverDiscountCard extends DiscountCard {


    public SilverDiscountCard(Customers cardOwner){

        super(cardOwner);
        setCardType("silver");
    }


    public SilverDiscountCard(){
        setCardType("silver");
    }


    @Override
    public void setTurnover(double turnoverLastMonth){
        super.setTurnoverLastMonth(turnoverLastMonth);
        setDiscountRate();

    }

    private void setDiscountRate(){
        if(getTurnoverLastMonth() >300){
            super.setDiscountRate(3.5);
        } else{
            super.setDiscountRate(2);
        }
    }



}
