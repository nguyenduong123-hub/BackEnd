package com.techprimers.db.model;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.Date;

@Configuration
@EntityScan(basePackageClasses = AccumulatedTransactions.class)
@Entity
@EnableAutoConfiguration
@Table(name = "accumulatedtransactions", schema = "open_pm")
public class AccumulatedTransactions {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;
    @Column(name = "idloyaltycard")
    private String idLoyaltyCard;
    @Column(name = "adjustmentpoint")
    private Integer adjustmentPoint;
    @Column(name = "adjustmentrevenue")
    private Integer adjustmentRevenue;
    @Column(name = "createdDate")
    private Date createdDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdLoyaltyCard() {
        return idLoyaltyCard;
    }

    public void setIdLoyaltyCard(String idLoyaltyCard) {
        this.idLoyaltyCard = idLoyaltyCard;
    }

    public Integer getAdjustmentPoint() {
        return adjustmentPoint;
    }

    public void setAdjustmentPoint(Integer adjustmentPoint) {
        this.adjustmentPoint = adjustmentPoint;
    }

    public Integer getAdjustmentRevenue() {
        return adjustmentRevenue;
    }

    public void setAdjustmentRevenue(Integer adjustmentRevenue) {
        this.adjustmentRevenue = adjustmentRevenue;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
