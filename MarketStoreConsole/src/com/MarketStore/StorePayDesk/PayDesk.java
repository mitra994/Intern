package com.MarketStore.StorePayDesk;

import com.MarketStore.Data.Customer;
import com.MarketStore.Data.Purchase;
import com.MarketStore.Data.DiscountCards.DiscountCard;


public class PayDesk {

    private Purchase purchase;

    private void calculatePurchase(double purchaseValue, DiscountCard discountCard){

        DeskCalculator calculator = new DeskCalculator(discountCard);

        purchase = new Purchase();
        purchase.setPurchaseValue(purchaseValue);
        purchase.setDiscount(calculator.calculateDiscount(purchaseValue));
        purchase.setTotal(calculator.calculateTotal(purchaseValue));

    }

    private void printReceipt(double purchaseValue, Customer customer){


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


    private void printReceipt(double purchaseValue){


        System.out.println("------------RECEIPT--------------");
        System.out.println("Welcome Guest");
        System.out.println("Your purchase value: " +purchaseValue + "$");
        System.out.println("Discount Rate: " + 0 + "%");
        System.out.println("Your discount is: " + 0+"$");
        System.out.println("Your final receipt is: " + purchaseValue + "$");
        System.out.println("---------------------------------");

    }


    public static void checkOut(double purchaseValue, Customer customer){
        PayDesk desk = new PayDesk();
        if(purchaseValue<0){
            System.out.println("Purchase value can't be less than 0");
        }else if(customer.getDiscountCard()==null){
            desk.printReceipt(purchaseValue);
        } else{
            desk.printReceipt(purchaseValue,customer);
        }

    }

}
