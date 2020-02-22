package com.MarketStore.PayDesk;

import com.MarketStore.DiscountCards.DiscountCard;
import com.MarketStore.DiscountCards.Guest;

public class PayDesk {

    private Purchase purchase;

    private void calculatePurchase(double purchaseValue, DiscountCard discountCard){

        DeskCalculator calculator = new DeskCalculator(discountCard);

        purchase = new Purchase();
        purchase.setPurchaseValue(purchaseValue);
        purchase.setDiscount(calculator.calculateDiscount(purchaseValue));
        purchase.setTotal(calculator.calculateTotal(purchaseValue));

    }

    private void printRecepint(double purchaseValue,Customer customer){

        if(customer.getDiscountCard() == null){
            customer.setDiscountCard(new Guest());
        }

        calculatePurchase(purchaseValue,customer.getDiscountCard());

        System.out.println("------------RECEIPT--------------");
        System.out.println("Welcome " + customer.getCustomerName());
        System.out.println("Membership type: " + customer.getDiscountCard().getCardType());
        System.out.println("Your purchase value: " + purchase.getPurchaseValue() + "$");
        System.out.println("Discount Rate: " + customer.getDiscountCard().getDiscountRate() + "%");
        System.out.println("Your discount is: " + purchase.getDiscount()+"$");
        System.out.println("Your final receipt is: " + purchase.getTotal() + "$");
        System.out.println("---------------------------------");

    }
    public static void commitPurchase(double purchaseValue, Customer customer){
        PayDesk desk = new PayDesk();
        if(purchaseValue<0){
            System.out.println("Purchase value can't be less than 0");
        }else{
            desk.printRecepint(purchaseValue,customer);
        }

    }

}
