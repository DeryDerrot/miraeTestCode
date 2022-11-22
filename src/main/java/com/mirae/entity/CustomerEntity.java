package com.mirae.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="customers")
public class CustomerEntity {

    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private int customerID;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "billing_address", nullable = false)
    private String billingAddress;

    private String city;

    @Column(name = "state_or_province", nullable = false)
    private String stateOrProvince;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    private String email;

    @Column(name = "company_website", nullable = false)
    private String companyWebsite;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "fax_number", nullable = false)
    private String faxNumber;

    @Column(name = "ship_address", nullable = false)
    private String shipAddress;

    @Column(name = "ship_city", nullable = false)
    private String shipCity;

    @Column(name = "ship_state_or_province", nullable = false)
    private String shipStateOrProvince;

    @Column(name = "ship_zip_code", nullable = false)
    private String shipZIPCode;

    @Column(name = "ship_phone_number", nullable = false)
    private String shipPhoneNumber;
}
