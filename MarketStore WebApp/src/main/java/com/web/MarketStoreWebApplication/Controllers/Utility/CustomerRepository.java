package com.web.MarketStoreWebApplication.Controllers.Utility;

import com.web.MarketStoreWebApplication.Model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customers,Integer> {


    @Override
    List<Customers> findAll();

    Optional<Customers> findByCustomerName(String customerName);




}
