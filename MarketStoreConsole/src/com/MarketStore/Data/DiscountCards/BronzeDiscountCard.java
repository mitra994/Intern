package com.MarketStore.Data.DiscountCards;

import com.MarketStore.Data.Customer;

public class BronzeDiscountCard extends DiscountCard{

    private final String TYPE = "BRONZE";

    public BronzeDiscountCard(Customer cardOwner, double lastMonthTurnover){
        super(cardOwner,lastMonthTurnover);

        if(lastMonthTurnover >= 100 && lastMonthTurnover <=300){
            setDiscountRate(1);
        }else if (lastMonthTurnover > 300){
            setDiscountRate(2.5);
        }else{
            setDiscountRate(0);
        }

    }

    @Override
    public String getCardType() {
        return TYPE;
    }
}
