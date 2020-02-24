package com.web.MarketStoreWebApplication.Model.DiscountCards;

import com.web.MarketStoreWebApplication.Model.Customers;
import com.web.MarketStoreWebApplication.Model.DiscountCard;

import javax.persistence.Entity;

@Entity
public class GoldDiscountCard extends DiscountCard {

    public GoldDiscountCard(Customers cardOwner){
        super(cardOwner);
        setCardType("gold");
    }

    public GoldDiscountCard(){
        setCardType("gold");
    }


    @Override
    public void setTurnover(double turnoverLastMonth){
        super.setTurnoverLastMonth(turnoverLastMonth);
        setDiscountRate();

    }
    private void setDiscountRate(){
        if(getTurnoverLastMonth() < 100){
            super.setDiscountRate(2);
        } else{
            super.setDiscountRate(getTurnoverLastMonth()/100+2);
            if(getDiscountRate() > 10){
                super.setDiscountRate(10);
            }
        }
    }



}
