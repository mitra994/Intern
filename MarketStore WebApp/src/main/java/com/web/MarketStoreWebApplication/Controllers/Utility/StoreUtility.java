package com.web.MarketStoreWebApplication.Controllers.Utility;

import com.web.MarketStoreWebApplication.Model.DiscountCard;
import com.web.MarketStoreWebApplication.Model.DiscountCards.BronzeDiscountCard;
import com.web.MarketStoreWebApplication.Model.DiscountCards.GoldDiscountCard;
import com.web.MarketStoreWebApplication.Model.DiscountCards.SilverDiscountCard;
import org.springframework.stereotype.Service;

@Service
public class StoreUtility {

    public double calculateTotal(double purchaseValue, DiscountCard discountCard){

        return purchaseValue - calculateDiscount(purchaseValue,discountCard);

    }

    public double calculateDiscount(double purchaseValue,DiscountCard discountCard){
        return purchaseValue * discountCard.getDiscountRate() /100;
    }

    public DiscountCard getCardByType(String type){

        DiscountCard card;
        switch(type){
            case "bronze":
                card = new BronzeDiscountCard();
                return card;
            case "silver":
                card = new SilverDiscountCard();
                return card;
            case "gold":
                card = new GoldDiscountCard();
                return card;
        }

       return null;

    }
}
