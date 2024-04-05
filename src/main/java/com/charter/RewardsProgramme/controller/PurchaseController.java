package com.charter.RewardsProgramme.controller;

import com.charter.RewardsProgramme.entity.Purchase;
import com.charter.RewardsProgramme.entity.CustomerRewardCountInterface;
import com.charter.RewardsProgramme.service.PurchaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PurchaseController {

    @Autowired
    PurchaseService service;
    @PostMapping("/purchases")
    public Purchase savePurchase(@Valid @RequestBody Purchase purchase){

        return  service.savePurchase(purchase);

    }
    @GetMapping("/purchases/rewards")
    public List<CustomerRewardCountInterface> fetchTotalRewrds(){
        return service.fetchTotalRewards();
    }

    @GetMapping("/purchases/rewards/daterange")
    public List<CustomerRewardCountInterface> fetchTotalRewrdsByDateRange(@RequestParam("fromDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date fromDate,@RequestParam("toDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date toDate){
        return service.fetchTotalRewardsByDateRange(fromDate,toDate);
    }

    @GetMapping("/purchases/rewards/{customerId}")
    public List<CustomerRewardCountInterface> fetchTotalRewardseByCustomerId(@PathVariable("customerId") Long customerId) //throws PurchaseNotFoundException
    {
        return service.fetchTotalRewardsByCustomerId(customerId);
    }

    @GetMapping("/purchases/rewards/daterange/{customerId}")
    public List<CustomerRewardCountInterface> fetchTotalRewardseByCustomerIdAndDateRange(@PathVariable("customerId") Long customerId,@RequestParam("fromDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date fromDate,@RequestParam("toDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date toDate) //throws PurchaseNotFoundException
    {
        return service.fetchRewardsByByCustomerIdAndDateRange(customerId,fromDate,toDate);
    }
}
