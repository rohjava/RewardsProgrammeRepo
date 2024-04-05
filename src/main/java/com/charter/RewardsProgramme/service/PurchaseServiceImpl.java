package com.charter.RewardsProgramme.service;

import com.charter.RewardsProgramme.Utilities.RewardsUtility;
import com.charter.RewardsProgramme.entity.Purchase;
import com.charter.RewardsProgramme.entity.CustomerRewardCountInterface;
import com.charter.RewardsProgramme.respository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;
    public Purchase savePurchase(@RequestBody Purchase purchase) {

        purchase.setRewardPoints(RewardsUtility.calculateRewardsForPurchase(purchase.getCost()));
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
