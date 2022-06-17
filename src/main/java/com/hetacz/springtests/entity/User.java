package com.hetacz.springtests.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class User {
    @Id
    private Integer id;
    private String fromCountry;
    private String toCountry;
    private Date dob;
    private String firstName;
    private String lastName;
    @Column(name = "customer_email")
    private String email;
    private String phone;
    private String comments;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFromCountry() {
        return fromCountry;
    }

    public User setFromCountry(String fromCountry) {
        this.fromCountry = fromCountry;
        return this;
    }

    public String getToCountry() {
        return toCountry;
    }

    public User setToCountry(String toCounty) {
        this.toCountry = toCounty;
        return this;
    }

    public Date getDob() {
        return dob;
    }

    public User setDob(Date dob) {
        this.dob = dob;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getComments() {
        return comments;
    }

    public User setComments(String comments) {
        this.comments = comments;
        return this;
    }
}
