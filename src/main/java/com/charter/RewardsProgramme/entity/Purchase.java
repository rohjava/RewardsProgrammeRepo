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
    private Long purchaseId;
    private Long customerId;
    private Integer cost;
    private Integer rewardPoints;
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
}
