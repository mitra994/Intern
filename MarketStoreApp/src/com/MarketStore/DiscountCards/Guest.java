package com.MarketStore.DiscountCards;

public class Guest extends  DiscountCard {

    private final String TYPE = "GUEST";

    public Guest(){
        setDiscountRate(0);
        setLastMonthTurnover(0);

    }

    @Override
    public String getCardType() {
        return this.TYPE;
    }


}
