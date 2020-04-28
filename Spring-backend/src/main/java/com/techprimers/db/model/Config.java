package com.techprimers.db.model;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

@Configuration
@EntityScan(basePackageClasses = Config.class)
@Entity
@EnableAutoConfiguration
@Table(name = "config", schema = "open_pm")
public class Config {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;
    @Column(name = "config", nullable = false, unique = true)
    private Integer config;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConfig() {
        return config;
    }

    public void setConfig(Integer config) {
        this.config = config;
    }
}
