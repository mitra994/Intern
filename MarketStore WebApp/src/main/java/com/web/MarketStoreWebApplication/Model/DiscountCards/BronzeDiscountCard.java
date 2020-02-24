package com.web.MarketStoreWebApplication.Model.DiscountCards;

import com.web.MarketStoreWebApplication.Model.Customers;
import com.web.MarketStoreWebApplication.Model.DiscountCard;

import javax.persistence.Entity;

@Entity
public class BronzeDiscountCard extends DiscountCard {


    public BronzeDiscountCard(Customers cardOwner){
        super(cardOwner);
        setCardType("bronze");
    }

    public BronzeDiscountCard(){
        setCardType("bronze");
    }


    @Override
    public void setTurnover(double turnoverLastMonth){
        super.setTurnoverLastMonth(turnoverLastMonth);
        setDiscountRate();

    }

    private void setDiscountRate(){
        if(getTurnoverLastMonth() >= 100 &&getTurnoverLastMonth() <=300){
            super.setDiscountRate(1);
        }else if (getTurnoverLastMonth() > 300){
            super.setDiscountRate(2.5);
        }else{
            super.setDiscountRate(0);
        }
    }



}
