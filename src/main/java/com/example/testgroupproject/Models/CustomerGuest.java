package com.example.testgroupproject.Models;

import javax.persistence.*;


@Entity
@Table(name = "customer_guest")
public class CustomerGuest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cus_ID", nullable = false)
    private Integer id;

    @Column(name = "cus_FName", length = 45)
    private String cusFname;

    @Column(name = "cus_LName", length = 45)
    private String cusLname;

    @Column(name = "cus_email", length = 45)
    private String cusEmail;

    @Column(name = "cus_phoneNr")
    private Integer cusPhoneNr;

    @Column(name = "cus_PostalC")
    private String cusPostalC;

    @Column(name = "cus_Street", length = 45)
    private String cusStreet;

    @Column(name = "cus_StreetNr")
    private String cusStreetNr;

    @Column(name = "cus_username", length = 45)
    private String cusUsername;

    @Column(name = "cus_password", length = 45)
    private String cusPassword;
    public CustomerGuest(String cusFname, String cusLname, String cusEmail, Integer cusPhoneNr, String cusPostalC, String cusStreet, String cusStreetNr, String cusUsername, String cusPassword) {
        this.cusFname = cusFname;
        this.cusLname = cusLname;
        this.cusEmail = cusEmail;
        this.cusPhoneNr = cusPhoneNr;
        this.cusPostalC = cusPostalC;
        this.cusStreet = cusStreet;
        this.cusStreetNr = cusStreetNr;
        this.cusUsername = cusUsername;
        this.cusPassword = cusPassword;

    }

    public CustomerGuest() {

    }

    public CustomerGuest(String name, String pass) {
        this.cusUsername = name;
        this.cusPassword = pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCusFname() {
        return cusFname;
    }

    public void setCusFname(String cusFname) {
        this.cusFname = cusFname;
    }

    public String getCusLname() {
        return cusLname;
    }

    public void setCusLname(String cusLname) {
        this.cusLname = cusLname;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public Integer getCusPhoneNr() {
        return cusPhoneNr;
    }

    public void setCusPhoneNr(Integer cusPhonenr) {
        this.cusPhoneNr = cusPhonenr;
    }

    public String getCusPostalc() {
        return cusPostalC;
    }

    public void setCusPostalc(String cusPostalc) {
        this.cusPostalC = cusPostalc;
    }

    public String getCusStreet() {
        return cusStreet;
    }

    public void setCusStreet(String cusStreet) {
        this.cusStreet = cusStreet;
    }

    public String getCusStreetnr() {
        return cusStreetNr;
    }

    public void setCusStreetnr(String cusStreetnr) {
        this.cusStreetNr = cusStreetnr;
    }

    public String getCusUsername() {
        return cusUsername;
    }

    public void setCusUsername(String cusUsername) {
        this.cusUsername = cusUsername;
    }

    public String getCusPassword() {
        return cusPassword;
    }

    public void setCusPassword(String cusPassword) {
        this.cusPassword = cusPassword;
    }
}