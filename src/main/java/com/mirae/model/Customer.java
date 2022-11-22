package com.mirae.model;

import lombok.Data;

@Data
public class Customer {

    private int customerID;
    private String companyName;
    private String firstName;
    private String lastName;
    private String billingAddress;
    private String city;
    private String stateOrProvince;
    private String zipCode;
    private String email;
    private String companyWebsite;
    private String phoneNumber;
    private String faxNumber;
    private String shipAddress;
    private String shipCity;
    private String shipStateOrProvince;
    private String shipZIPCode;
    private String shipPhoneNumber;
}
