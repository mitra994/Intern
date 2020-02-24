package com.web.MarketStoreWebApplication.Controllers;


import com.web.MarketStoreWebApplication.Controllers.Utility.StoreUtility;
import com.web.MarketStoreWebApplication.Model.Customers;
import com.web.MarketStoreWebApplication.Model.DiscountCard;
import com.web.MarketStoreWebApplication.Controllers.Utility.CustomerRepository;
import com.web.MarketStoreWebApplication.Model.DiscountCards.BronzeDiscountCard;
import com.web.MarketStoreWebApplication.Model.DiscountCards.GoldDiscountCard;
import com.web.MarketStoreWebApplication.Model.DiscountCards.SilverDiscountCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private CustomerRepository repo;

    @PostMapping
    public String register(@RequestParam String username, @RequestParam String password,
                         @RequestParam String cardType) throws IOException {



        Optional<Customers> check = repo.findByCustomerName(username);


        if(check.isPresent()){
            return "Username already taken!";
        }

        Customers customer = new Customers(username,password);


        cardType = cardType.toLowerCase();
        DiscountCard card = new StoreUtility().getCardByType(cardType);

        if(card==null){
            return "Invalid card type, card type can be only bronze, silver or gold!";
        }

        card.setCustomer(customer);
        card.setTurnover(0);
        customer.setDiscountCard(card);

        repo.save(customer);

        return "Sucessfull registration. "+ customer.getCustomerName()+" " +
                "with "+ customer.getDiscountCard().getCardType()+"card. Please /login";
    }

}
