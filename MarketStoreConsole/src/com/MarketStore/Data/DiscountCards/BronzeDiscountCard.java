package com.MarketStore.Data.DiscountCards;

import com.MarketStore.Data.Customer;

public class BronzeDiscountCard extends DiscountCard{

    private final String TYPE = "BRONZE";

    public BronzeDiscountCard(Customer cardOwner){
        super(cardOwner);
        super.setLastMonthTurnover(0);


    }

    @Override
    public String getCardType() {
        return TYPE;
    }


    @Override
    protected void calculateDiscountRate(){

        if(getLastMonthTurnover() >= 100 && getLastMonthTurnover() <=300){
            setDiscountRate(1);
        }else if (getLastMonthTurnover()> 300){
           setDiscountRate(2.5);
        }else{
            setDiscountRate(0);
        }
    }
    @Override
    public void setTurnover(double turnover){
        super.setLastMonthTurnover(turnover);
        calculateDiscountRate();

    }
}
