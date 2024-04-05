package com.charter.RewardsProgramme.respository;

import com.charter.RewardsProgramme.entity.Purchase;
import com.charter.RewardsProgramme.model.custom.CustomerRewardCountInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {

    public Purchase findByDepartmentName(String departmentName);

    public Purchase findByDepartmentNameIgnoreCase(String departmentName);

    @Query(value = "SELECT c.customerId AS customerId, SUM(c.rewardPoints) AS  totalRewardPoints"
            + "FROM Purchase AS c GROUP BY c.customerId", nativeQuery = true)
    public List<CustomerRewardCountInterface> fetchTotalRewards();

    @Query(value = "SELECT c.customerId AS customerId, SUM(c.rewardPoints) AS  totalRewardPoints"
            + "FROM Purchase AS c where c.customerId = :customerId GROUP BY c.customerId", nativeQuery = true)
    List<CustomerRewardCountInterface> fetchTotalRewardsByCustomerId(@Param("customerId")Long customerId);

    @Query(value = "SELECT c.customerId AS customerId, SUM(c.rewardPoints) AS  totalRewardPoints"
            + "FROM Purchase AS c where c.purchaseDate >= :startDate AND c.purchaseDate <= :endDate" +
            "GROUP BY c.customerId", nativeQuery = true)
    List<CustomerRewardCountInterface> fetchTotalRewardsByDateRange(@Param("startDate")Date startDate, @Param("endDate")Date endDate);
    @Query(value = "SELECT c.customerId AS customerId, SUM(c.rewardPoints) AS  totalRewardPoints"
            + "FROM Purchase AS c where c.customerId = :customerId AND c.purchaseDate >= :startDate AND c.purchaseDate <= :endDate" +
            "GROUP BY c.customerId", nativeQuery = true)
    List<CustomerRewardCountInterface> fetchRewardsByByCustomerIdAndDateRange(@Param("customerId")Long customerId, @Param("startDate")Date startDate, @Param("endDate")Date endDate);


}
