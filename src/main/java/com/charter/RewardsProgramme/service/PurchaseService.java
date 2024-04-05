package com.charter.RewardsProgramme.service;

import com.charter.RewardsProgramme.entity.CustomerRewardCountInterface;
import com.charter.RewardsProgramme.entity.Purchase;

import java.util.Date;
import java.util.List;

public interface PurchaseService {
    Purchase savePurchase(Purchase purchase);

    List<CustomerRewardCountInterface> fetchTotalRewards();

    List<CustomerRewardCountInterface> fetchTotalRewardsByDateRange(Date fromDate, Date toDate);

    List<CustomerRewardCountInterface> fetchTotalRewardsByCustomerId(Long customerId);

    List<CustomerRewardCountInterface> fetchRewardsByByCustomerIdAndDateRange(Long customerId, Date fromDate, Date toDate);
}
