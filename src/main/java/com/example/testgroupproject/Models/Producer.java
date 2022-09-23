package com.example.testgroupproject.Models;

import javax.persistence.*;

@Entity
@Table(name = "producer")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_ID", nullable = false)
    private Integer id;

    @Column(name = "prod_FName", length = 45)
    private String prodFname;

    @Column(name = "prod_LName", length = 45)
    private String prodLname;

    @Column(name = "prod_Address", length = 45)
    private String prodAddress;

    @Column(name = "prod_Area", length = 45)
    private String prodArea;

    @Column(name = "prod_Email", nullable = false, length = 45)
    private String prodEmail;

    @Column(name = "prod_IBAN", length = 20)
    private String prodIban;

    @Column(name = "prod_Bus_Title", length = 45)
    private String prodBusTitle;

    @Column(name = "prod_username", nullable = false, length = 45)
    private String prodUsername;

    @Column(name = "prod_password", length = 45)
    private String prodPassword;

    public Producer(String prodFname, String prodLname, String prodAddress, String prodArea, String prodEmail, String prodIban, String prodBusTitle, String prodUsername, String prodPassword) {
        this.prodFname = prodFname;
        this.prodLname = prodLname;
        this.prodAddress = prodAddress;
        this.prodArea = prodArea;
        this.prodEmail = prodEmail;
        this.prodIban = prodIban;
        this.prodBusTitle = prodBusTitle;
        this.prodUsername = prodUsername;
        this.prodPassword = prodPassword;
    }

    public Producer() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProdFname() {
        return prodFname;
    }

    public void setProdFname(String prodFname) {
        this.prodFname = prodFname;
    }

    public String getProdLname() {
        return prodLname;
    }

    public void setProdLname(String prodLname) {
        this.prodLname = prodLname;
    }

    public String getProdAddress() {
        return prodAddress;
    }

    public void setProdAddress(String prodAddress) {
        this.prodAddress = prodAddress;
    }

    public String getProdArea() {
        return prodArea;
    }

    public void setProdArea(String prodArea) {
        this.prodArea = prodArea;
    }

    public String getProdEmail() {
        return prodEmail;
    }

    public void setProdEmail(String prodEmail) {
        this.prodEmail = prodEmail;
    }

    public String getProdIban() {
        return prodIban;
    }

    public void setProdIban(String prodIban) {
        this.prodIban = prodIban;
    }

    public String getProdBusTitle() {
        return prodBusTitle;
    }

    public void setProdBusTitle(String prodBusTitle) {
        this.prodBusTitle = prodBusTitle;
    }

    public String getProdUsername() {
        return prodUsername;
    }

    public void setProdUsername(String prodUsername) {
        this.prodUsername = prodUsername;
    }

    public String getProdPassword() {
        return prodPassword;
    }

    public void setProdPassword(String prodPassword) {
        this.prodPassword = prodPassword;
    }

}