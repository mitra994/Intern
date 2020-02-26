package com.web.MarketStoreWebApplication.Controllers;


import com.web.MarketStoreWebApplication.Controllers.Utility.CustomerRepository;
import com.web.MarketStoreWebApplication.Controllers.Utility.StoreUtility;
import com.web.MarketStoreWebApplication.Model.Customers;
import com.web.MarketStoreWebApplication.Model.DiscountCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("Duplicates")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repo;

    private Customers loggedInCustomer;

    @GetMapping
    public void getUser(HttpSession session, HttpServletResponse response) throws IOException {

        PrintWriter writer = response.getWriter();
        loggedInCustomer = repo.findByCustomerName((String) session.getAttribute("username")).get();

        writer.println("Customer name: "+ loggedInCustomer.getCustomerName());
        writer.println("Customer card type: "+loggedInCustomer.getDiscountCard().getCardType());
        writer.println("Turnover for last month " + loggedInCustomer.getDiscountCard().getTurnoverLastMonth());
        writer.println("Discount rate: "+loggedInCustomer.getDiscountCard().getDiscountRate());

    }

    @RequestMapping(value="/turnover",method = RequestMethod.GET)
    public String setTurnover(@RequestParam double value){

        DiscountCard card = loggedInCustomer.getDiscountCard();
        card.setTurnover(value);

        loggedInCustomer.setDiscountCard(card);
        repo.save(loggedInCustomer);

        return "Sucessful!";


    }

    @RequestMapping(value="/switch",method = RequestMethod.GET)
    public void switchCard(@RequestParam String cardType, HttpServletResponse response) throws IOException{

        PrintWriter writer = response.getWriter();
        cardType= cardType.toLowerCase();

        DiscountCard oldCard = loggedInCustomer.getDiscountCard();
        DiscountCard newCard = new StoreUtility().getCardByType(cardType);

        if(newCard==null){
            writer.println("Invalid card type. Card type can only be bronze,silver or gold!");
            return;
        }else if(oldCard.getCardType().equals(cardType)){
            writer.println("You already have " + oldCard.getCardType() + " card!");
            return;
        }

        writer.println("-----------------------------------------");
        writer.println("Old card type: " + oldCard.getCardType());
        writer.println("Turnover: " + oldCard.getTurnoverLastMonth());
        writer.println("Discount rate: "+ oldCard.getDiscountRate());

        newCard.setCustomer(loggedInCustomer);
        newCard.setTurnover(oldCard.getTurnoverLastMonth());
        loggedInCustomer.setDiscountCard(newCard);

        repo.save(loggedInCustomer);

        writer.println("-----------------------------------------");
        writer.println("New card type: " + newCard.getCardType());
        writer.println("Turnover: " + newCard.getTurnoverLastMonth());
        writer.println("Discount rate: "+ newCard.getDiscountRate());


    }


}
