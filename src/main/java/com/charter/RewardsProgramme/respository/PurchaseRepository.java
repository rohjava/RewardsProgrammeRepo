package com.charter.RewardsProgramme.respository;

import com.charter.RewardsProgramme.entity.CustomerRewardCountInterface;
import com.charter.RewardsProgramme.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Long> {

    @Query(value = "SELECT c.customer_id AS customerId, SUM(c.reward_points) AS  totalRewardPoints "
            + "FROM Purchase AS c GROUP BY c.customer_id", nativeQuery = true)
    public List<CustomerRewardCountInterface> fetchTotalRewards();

    @Query(value = "SELECT c.customer_id AS customerId, SUM(c.reward_points) AS  totalRewardPoints "
            + "FROM Purchase AS c " +
            "where c.customer_id = :customerId GROUP BY c.customer_id", nativeQuery = true)
    List<CustomerRewardCountInterface> fetchTotalRewardsByCustomerId(@Param("customerId")Long customerId);

    @Query(value = "SELECT c.customer_id AS customerId, SUM(c.reward_points) AS  totalRewardPoints "
            + "FROM Purchase AS c where c.purchase_date >= :startDate AND c.purchase_date <= :endDate " +
            "GROUP BY c.customer_id", nativeQuery = true)
    List<CustomerRewardCountInterface> fetchTotalRewardsByDateRange(@Param("startDate")Date startDate, @Param("endDate")Date endDate);
    @Query(value = "SELECT c.customer_id AS customerId, SUM(c.reward_points) AS  totalRewardPoints "
            + "FROM Purchase AS c where c.customer_id = :customerId AND " +
            "c.purchase_date >= :startDate AND c.purchase_date <= :endDate " +
            "GROUP BY c.customer_id", nativeQuery = true)
    List<CustomerRewardCountInterface> fetchRewardsByByCustomerIdAndDateRange(@Param("customerId")Long customerId, @Param("startDate")Date startDate, @Param("endDate")Date endDate);

}
