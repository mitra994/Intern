package com.MarketStore.Data.DiscountCards;

import com.MarketStore.Data.Customer;

public class SilverDiscountCard extends DiscountCard{

    private final String TYPE = "SILVER";

    public SilverDiscountCard(Customer cardOwner){
        super(cardOwner);
        super.setLastMonthTurnover(0);


    }

    @Override
    public String getCardType() {
        return TYPE;
    }


    @Override
    protected void calculateDiscountRate(){

        if (getLastMonthTurnover() > 300){
            setDiscountRate(3.5);
        }else{
            setDiscountRate(2);
        }
    }
    @Override
    public void setTurnover(double turnover){
        super.setLastMonthTurnover(turnover);
        calculateDiscountRate();

    }
}
