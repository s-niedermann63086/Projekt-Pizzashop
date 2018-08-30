package org.test.webapp.project.dto;

import java.sql.Date;

public class Order {

    private Long id;
    private String address;
    private String phone;
    private Date date;

    public Order(Long id, String address, String phone, Date date) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
