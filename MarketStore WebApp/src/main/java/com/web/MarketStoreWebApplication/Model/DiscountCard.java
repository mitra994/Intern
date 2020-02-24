package com.web.MarketStoreWebApplication.Model;

import javax.persistence.*;

@Entity(name="DiscountCard")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="discount_cards")
public class DiscountCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="card_id")
    private int cardId;

    @Column(name="turnover_last_month")
    private double turnoverLastMonth;

    @Column(name="discount_rate")
    private double discountRate;

    @Column(name="card_type")
    private String cardType;


    @OneToOne
    @JoinColumn(name = "customer_fk")
    private Customers customer;


    public DiscountCard(Customers cardOwner){
        this.customer = cardOwner;

    }
    public DiscountCard(){

    }


    public void setTurnover(double turnover){

    }

    public double getTurnoverLastMonth() {
        return turnoverLastMonth;
    }

    protected void setTurnoverLastMonth(double turnoverLastMonth) {
        this.turnoverLastMonth = turnoverLastMonth;


    }

    public double getDiscountRate() {
        return discountRate;
    }

    protected void setDiscountRate(double discountRate) {
       this.discountRate = discountRate;

        }


    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public void setCardType(String type){
        this.cardType = type.toLowerCase();

    }

    public String getCardType(){
        return this.cardType;
    }
}
