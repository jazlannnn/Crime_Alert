/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alert.model;

/**
 *
 * @author raimi
 */
public class customer implements java.io.Serializable{
    private Long id;
    private String email;
    private String username;
    private String password;
    private String address;
    private String phoneNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public customer(Long id, String email, String username, String password, String address, String phoneNum) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phoneNum = phoneNum;
    }

     public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

}
