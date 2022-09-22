package com.example.testgroupproject.Models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "product_ID", nullable = false)
    private Integer id;

    @Column(name = "product_Name", length = 45)
    private String productName;

    @Column(name = "product_Price")
    private Double productPrice;

    @Lob
    @Column(name = "product_Info")
    private String productInfo;

    @Column(name = "possible_discount", nullable = false)
    private Double possibleDiscount;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "FK_productType_ID")
    private ProductType fkProducttype;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_county_ID")
    private County fkCounty;

    public Product() {
    }

    public Product(String productName, Double productPrice, String message, Double discount) {
    }

    public Product(String productName, Double productPrice, String productInfo) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public Double getPossibleDiscount() {
        return possibleDiscount;
    }

    public void setPossibleDiscount(Double possibleDiscount) {
        this.possibleDiscount = possibleDiscount;
    }

    public ProductType getFkProducttype() {
        return fkProducttype;
    }

    public void setFkProducttype(ProductType fkProducttype) {
        this.fkProducttype = fkProducttype;
    }

    public County getFkCounty() {
        return fkCounty;
    }

    public void setFkCounty(County fkCounty) {
        this.fkCounty = fkCounty;
    }

}