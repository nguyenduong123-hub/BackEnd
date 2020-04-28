package com.techprimers.db.model;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.Date;

@Configuration
@EntityScan(basePackageClasses = CardRank.class)
@Entity
@EnableAutoConfiguration
@Table(name = "cardrank", schema = "open_pm")
public class CardRank {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;
    @Column(name = "namecardrank")
    private String namecardrank;
    @Column(name = "promotionsales")
    private int promotionsales;
    @Column(name = "duration")
    private String duration;
    @Column(name = "discount")
    private String discount;
    @Column(name = "createdate")
    private Date createdate;
    @Column(name = "updatedate")
    private Date updateddate;
    @Column(name = "code")
    private String code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamecardrank() {
        return namecardrank;
    }

    public void setNamecardrank(String namecardrank) {
        this.namecardrank = namecardrank;
    }

    public int getPromotionsales() {
        return promotionsales;
    }

    public void setPromotionsales(int promotionsales) {
        this.promotionsales = promotionsales;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdateddate() {
        return updateddate;
    }

    public void setUpdateddate(Date updateddate) {
        this.updateddate = updateddate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
