package com.example.testgroupproject.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "county")
public class County {
    @Id
    @Column(name = "county_id", nullable = false)
    private Integer id;

    @Column(name = "county_name", length = 45)
    private String countyName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

}