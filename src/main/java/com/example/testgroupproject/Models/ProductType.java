package com.example.testgroupproject.Models;

import javax.persistence.*;

@Entity
@Table(name = "product_type")
public class ProductType {
    @Id
    @Column(name = "productType_ID", nullable = false)
    private Integer id;

    @Column(name = "product_type", length = 45)
    private String productType;

    @Lob
    @Column(name = "prodTypeComment")
    private String prodTypeComment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProdTypeComment() {
        return prodTypeComment;
    }

    public void setProdTypeComment(String prodTypeComment) {
        this.prodTypeComment = prodTypeComment;
    }

}