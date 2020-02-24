package com.MarketStore;

import com.MarketStore.Data.DiscountCards.BronzeDiscountCard;
import com.MarketStore.Data.DiscountCards.DiscountCard;
import com.MarketStore.Data.DiscountCards.GoldDiscountCard;
import com.MarketStore.Data.DiscountCards.SilverDiscountCard;
import com.MarketStore.Data.Customer;
import com.MarketStore.StorePayDesk.PayDesk;

public class Main {

    public static void main(String[] args) {

        /// Customer John with Bronze Discount Card
        Customer bronzeCustomer = new Customer(1,"John");
        DiscountCard bronzeCard = new BronzeDiscountCard(bronzeCustomer);
        bronzeCard.setTurnover(0);
        bronzeCustomer.setDiscountCard(bronzeCard);

        //Customer Bob with Silver Discount Card
        Customer silverCustomer = new Customer(2,"Bob");
        DiscountCard silverCard = new SilverDiscountCard(silverCustomer);
        silverCard.setTurnover(600);
        silverCustomer.setDiscountCard(silverCard);

        //Customer Mike with GoldDiscountCard
        Customer goldCustomer = new Customer(3,"Mike");
        DiscountCard goldCard = new GoldDiscountCard(goldCustomer);
        goldCard.setTurnover(1500);
        goldCustomer.setDiscountCard(goldCard);


        PayDesk.checkout(150,bronzeCustomer);
        PayDesk.checkout(850,silverCustomer);
        PayDesk.checkout(1300,goldCustomer);


    }
}
