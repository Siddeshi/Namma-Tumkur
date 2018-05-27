package com.app.nammatumkur.generic.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class ContactDetails implements Serializable {

    private String address;

    private long phone1;

    private long phone2;

    private String email;

    private long pincode;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone1() {
        return phone1;
    }

    public void setPhone1(long phone1) {
        this.phone1 = phone1;
    }

    public long getPhone2() {
        return phone2;
    }

    public void setPhone2(long phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }
}
