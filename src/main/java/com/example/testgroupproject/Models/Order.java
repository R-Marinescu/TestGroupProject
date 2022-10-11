package com.example.testgroupproject.Models;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_ID", nullable = false)
    private Integer id;

    @Column(name = "payment_type", length = 45)
    private String paymentType;

    @Column(name = "shipment_info")
    private Integer shipmentInfo;

    @Convert(disableConversion = true)
    @Column(name = "order_date")
    private Instant orderDate;

    @Column(name = "totalPrice")
    private Double totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_customer_Id")
    private CustomerGuest fkCustomer;

    public Order(String paymentType) {
        this.paymentType = paymentType;
    }

    public Order(Double totalPrice){
        this.totalPrice = totalPrice;
    }

    public Order() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getShipmentInfo() {
        return shipmentInfo;
    }

    public void setShipmentInfo(Integer shipmentInfo) {
        this.shipmentInfo = shipmentInfo;
    }

    public Instant getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Instant orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CustomerGuest getFkCustomer() {
        return fkCustomer;
    }

    public void setFkCustomer(CustomerGuest fkCustomer) {
        this.fkCustomer = fkCustomer;
    }

}