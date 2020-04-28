package com.techprimers.db.model;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.Date;

@Configuration
@EntityScan(basePackageClasses = LocyaltyCards.class)
@Entity
@EnableAutoConfiguration
@Table(name = "locyaltycards", schema = "open_pm")
public class LocyaltyCards {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;
    @Column(name = "code", nullable = false, unique = true)
    private String code;
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
    @Column(name = "cardrank")
    private String cardrank;
    @Column(name = "point")
    private Integer point;
    @Column(name = "revenue")
    private Integer revenue;
    @Column(name = "starttime")
    private Date startTime;
    @Column(name = "endtime")
    private Date endTime;
    @Column(name = "updatedate")
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardrank() {
        return cardrank;
    }

    public void setCardrank(String cardrank) {
        this.cardrank = cardrank;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
