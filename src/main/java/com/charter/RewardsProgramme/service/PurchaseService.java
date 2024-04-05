package com.charter.RewardsProgramme.service;

import com.charter.RewardsProgramme.entity.Purchase;
import com.charter.RewardsProgramme.model.custom.CustomerRewardCountInterface;
import com.charter.RewardsProgramme.respository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;
    public Purchase savePurchase(Purchase purchase) {

        return purchaseRepository.save(purchase);
    }



    public List<CustomerRewardCountInterface> fetchTotalRewards() {
        return purchaseRepository.fetchTotalRewards();
    }

    public List<CustomerRewardCountInterface> fetchTotalRewardsByDateRange(Date startDate, Date endDate) {
        return purchaseRepository.fetchTotalRewardsByDateRange(startDate, endDate);
    }
    public List<CustomerRewardCountInterface> fetchTotalRewardsByCustomerId(Long customerId) {
        return purchaseRepository.fetchTotalRewardsByCustomerId(customerId);
    }
    public List<CustomerRewardCountInterface> fetchRewardsByByCustomerIdAndDateRange(Long customerId, Date startDate, Date endDate) {
        return purchaseRepository.fetchRewardsByByCustomerIdAndDateRange(customerId,startDate,endDate);
    }
}
