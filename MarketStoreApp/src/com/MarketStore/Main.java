package com.MarketStore;

import com.MarketStore.DiscountCards.BronzeDiscountCard;
import com.MarketStore.DiscountCards.DiscountCard;
import com.MarketStore.DiscountCards.GoldDiscountCard;
import com.MarketStore.DiscountCards.SilverDiscountCard;
import com.MarketStore.PayDesk.Customer;
import com.MarketStore.PayDesk.PayDesk;

public class Main {

    public static void main(String[] args) {

        /// Customer John with Bronze Discount Card
        Customer bronzeCustomer = new Customer(1,"John");
        DiscountCard bronzeCard = new BronzeDiscountCard(bronzeCustomer,0);
        bronzeCustomer.setDiscountCard(bronzeCard);

        //Customer Bob with Silver Discount Card
        Customer silverCustomer = new Customer(2,"Bob");
        DiscountCard silverCard = new SilverDiscountCard(silverCustomer,600);
        silverCustomer.setDiscountCard(silverCard);

        //Customer Mike with GoldDiscountCard
        Customer goldCustomer = new Customer(3,"Mike");
        DiscountCard goldCard = new GoldDiscountCard(goldCustomer,1500);
        goldCustomer.setDiscountCard(goldCard);


        PayDesk.commitPurchase(150,bronzeCustomer);
        PayDesk.commitPurchase(850,silverCustomer);
        PayDesk.commitPurchase(1300,goldCustomer);


    }
}
