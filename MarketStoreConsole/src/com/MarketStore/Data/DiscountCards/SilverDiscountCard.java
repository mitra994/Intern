package com.MarketStore.Data.DiscountCards;

import com.MarketStore.Data.Customer;

public class SilverDiscountCard extends DiscountCard{

    private final String TYPE = "SILVER";

    public SilverDiscountCard(Customer cardOwner, double lastMonthTurnover){
        super(cardOwner,lastMonthTurnover);

         if (lastMonthTurnover > 300){
            setDiscountRate(3.5);
        }else{
            setDiscountRate(2);
        }

    }


    @Override
    public String getCardType() {
        return TYPE;
    }
}
