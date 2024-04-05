package com.charter.RewardsProgramme.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PURCHASE_ID")
    private Long purchaseId;
    @Column(name = "CUSTOMER_ID")
    private Long customerId;
    @Column(name = "COST")
    private Integer cost;
    @Column(name = "REWARD_POINTS")
    private Integer rewardPoints;
    @Column(name = "PURCHASE_DATE")
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
}
