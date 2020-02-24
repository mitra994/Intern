package com.web.MarketStoreWebApplication.Controllers;

import com.web.MarketStoreWebApplication.Controllers.Utility.StoreUtility;
import com.web.MarketStoreWebApplication.Model.Customers;
import com.web.MarketStoreWebApplication.Model.DiscountCard;
import com.web.MarketStoreWebApplication.Model.Products;
import com.web.MarketStoreWebApplication.Controllers.Utility.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/store")
public class StoreController {


    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private StoreUtility calculator;

    private PrintWriter writer;
    private Customers logedInCustomer;
    private List<Products> productsList;
    private List<Products> cart = new ArrayList<>();
    private double cartValue = 0;



    public StoreController(){
        populateStore();
    }

    @GetMapping
    public List<Products> getProducts(){
        return productsList;
    }


    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String addToCart(@RequestParam String itemName){


        if(cart == null){
            cart = new ArrayList<>();
        }

        for (Products p:productsList){
            if(p.getProductName().equals(itemName)) {
                cart.add(p);
                cartValue += p.getPurchaseValue();
                return "Product added to the cart sucessfuly!";
            }
        }
        return "No such product exists!";
    }

    @RequestMapping(value="/remove",method = RequestMethod.GET)
    public String removeFromCart(@RequestParam String itemName){
        if(cart.size()<1){
            return "Cart is empty. No items to remove.";
        }else{
            for (Products p:cart){
                if(p.getProductName().equals(itemName)){
                    cart.remove(p);
                    return p.getProductName() + " sucessfuly removed";
                }
            }
        }
        return "No such item exists!";


    }


    @RequestMapping(value="/cart",method = RequestMethod.GET)
    public void getCart(HttpServletResponse response) throws IOException{

        writer= response.getWriter();


        if(cart.size()<1){
            writer.println("Cart is empty.");
        }else{
            writer.println("Cart valute: "+ cartValue);
            writer.print("----------------------");
            for (Products p: cart){
                writer.println("Item name: " + p.getProductName()+",");
                writer.println("Item price: " + p.getPurchaseValue());
                writer.println("-------------------------------");
            }
        }
    }


    @RequestMapping(value="/checkout")
    public void checkout(HttpServletResponse response, HttpSession session)throws IOException{
        writer = response.getWriter();

       Optional<Customers> isLogedIn = customerRepo.findByCustomerName((String)session.getAttribute("username"));

        if(isLogedIn.isEmpty()){
            writer.println("----------RECEIPT----------");
            writer.println("Welcome guest");
            writer.println("Purchase value= " + cartValue + "$");
            writer.println("Discount Rate= 0%");
            writer.println("Your discount = 0$");
            writer.println("Your total= "+ cartValue+"$");
            writer.println("/accept to finish the transaction");
        }else{
            logedInCustomer = isLogedIn.get();
            writer.println("----------RECEIPT----------");
            writer.println("Welcome " + logedInCustomer.getCustomerName());
            writer.println("Your type of membership: " + logedInCustomer.getDiscountCard().getCardType());
            writer.println("Purchase value=: " + cartValue + "$");
            writer.println("Discount rate: " + logedInCustomer.getDiscountCard().getDiscountRate() + "%");
            writer.println("Your discount is: " + calculator.calculateDiscount(cartValue, logedInCustomer.getDiscountCard()) + "$");
            writer.println("Your total is: "+ calculator.calculateTotal(cartValue, logedInCustomer.getDiscountCard())+"$");
            writer.println("/accept to finish the transaction");


        }
    }

    @RequestMapping(value = "/checkout/accept")
    private String finishPurchase(){

        if(logedInCustomer != null){
            DiscountCard card = logedInCustomer.getDiscountCard();
            for (Products p:productsList){
                p.setCustomer(logedInCustomer);
                logedInCustomer.getPurchasesList().add(p);

            }
            card.setTurnover(cartValue);
            logedInCustomer.setDiscountCard(card);
            customerRepo.save(logedInCustomer);
        }
        cart = new ArrayList<>();
        cartValue=0;
        return "Purchase sucessfull!";



    }

    public void populateStore(){

        if(productsList ==null){
            productsList = new ArrayList<>();
            Products productOne = new Products();
            productOne.setProductName("Item1");
            productOne.setPurchaseValue(200);

            Products productTwo = new Products();
            productTwo.setProductName("Item2");
            productTwo.setPurchaseValue(500);

            Products productThree = new Products();
            productThree.setProductName("Item3");
            productThree.setPurchaseValue(1000);

            Products productFour = new Products();
            productFour.setProductName("Item4");
            productFour.setPurchaseValue(1500);



            productsList.add(productOne);
            productsList.add(productTwo);
            productsList.add(productThree);
            productsList.add(productFour);

        }
    }



    }