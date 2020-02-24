package com.web.MarketStoreWebApplication.Controllers;


import com.web.MarketStoreWebApplication.Model.Customers;
import com.web.MarketStoreWebApplication.Controllers.Utility.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private CustomerRepository repo;

    @PostMapping
    public String authenticate(@RequestParam String name,
                               @RequestParam String password, HttpSession session) throws Exception{



        Optional<Customers> check = repo.findByCustomerName(name);

        if(check.isEmpty()){
            return "Username not found.";
        }

        Customers customer = check.get();

        if(!(customer.getPassword().equals(password))){
            return "Wrong password.";
        }

        session.setAttribute("username",customer.getCustomerName());

        return "Welcome " + customer.getCustomerName()+ ".Your type of membership: " + customer.getDiscountCard().getCardType();


    }
}
