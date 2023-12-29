/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alert.model;

import java.sql.Date;

/**
 *
 * @author raimi
 */
public class ReportBean implements java.io.Serializable{
    private int reportId;
    private String email;
    private String description;
    private Date reportDate;
    private String status;
    
    private int userId;
    public ReportBean() {
     
    }
    public ReportBean(int reportId, String email, String description,Date reportDate,String status,int userId) {
        this.reportId = reportId;
        this.email = email;
        this.description = description;
        this.reportDate = reportDate;
        this.status = status;
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    
    

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
   
    
}
