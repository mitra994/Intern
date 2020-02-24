package com.web.MarketStoreWebApplication.Model;

import javax.persistence.*;


@Entity(name="Product")
@Table(name="products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private int purchaseId;

    @Column(name="product_value")
    private double purchaseValue;

    @Column(name="product_name")
    private String productName;


    @OneToOne
    @JoinColumn(name="customer_fk")
     private Customers customer;


    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public double getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(double purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
