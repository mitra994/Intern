package com.MarketStore.Data.DiscountCards;

import com.MarketStore.Data.Customer;

public class GoldDiscountCard extends DiscountCard{

    private final String TYPE = "GOLD";

    public GoldDiscountCard(Customer cardOwner, double lastMonthTurnover){
        super(cardOwner,lastMonthTurnover);

         if (lastMonthTurnover < 100){
            setDiscountRate(2);
        }else{
            setDiscountRate(lastMonthTurnover/100 + 2);
            if(getDiscountRate() > 10){
                setDiscountRate(10);
            }
        }

    }


    @Override
    public String getCardType() {
        return TYPE;
    }
}
