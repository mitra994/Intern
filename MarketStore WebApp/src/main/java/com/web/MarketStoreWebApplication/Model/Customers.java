package com.web.MarketStoreWebApplication.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Customer")
@Table(name="customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int customerId;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="password")
    private String password;

    @OneToOne(targetEntity = DiscountCard.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private DiscountCard discountCard;

    @OneToMany(targetEntity = Products.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Products> purchasesList = new ArrayList<Products>();

    public Customers(String name,String password){
        customerName = name;
        this.password = password;
    }
    public Customers(){

    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPassword() {
        return password;
    }

    public DiscountCard getDiscountCard() {
        return discountCard;
    }

    public void setDiscountCard(DiscountCard discountCard) {
        this.discountCard = discountCard;
    }

    public List<Products> getPurchasesList() {
        return purchasesList;
    }


}
