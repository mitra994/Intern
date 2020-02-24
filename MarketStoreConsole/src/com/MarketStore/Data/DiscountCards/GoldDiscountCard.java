package com.MarketStore.Data.DiscountCards;

import com.MarketStore.Data.Customer;

public class GoldDiscountCard extends DiscountCard{

    private final String TYPE = "GOLD";

    public GoldDiscountCard(Customer cardOwner){
        super(cardOwner);
        super.setLastMonthTurnover(0);


    }

    @Override
    public String getCardType() {
        return TYPE;
    }


    @Override
    protected void calculateDiscountRate(){

        if (getLastMonthTurnover() < 100){
            super.setDiscountRate(2);
        }else{
            super.setDiscountRate(getLastMonthTurnover()/100 + 2);
            if(getDiscountRate() > 10){
                super.setDiscountRate(10);
            }
        }
    }
    @Override
    public void setTurnover(double turnover){
        super.setLastMonthTurnover(turnover);
        calculateDiscountRate();

    }
}
