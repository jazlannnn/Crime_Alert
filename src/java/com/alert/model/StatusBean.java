/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alert.model;

/**
 *
 * @author Jazlan
 */
public class StatusBean {
    private int statusId;
    private String status;
    private int reportId;

    // Constructors, getters, and setters

    public StatusBean() {
    }

    public StatusBean(int statusId, String status, int reportId) {
        this.statusId = statusId;
        this.status = status;
        this.reportId = reportId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }
}
