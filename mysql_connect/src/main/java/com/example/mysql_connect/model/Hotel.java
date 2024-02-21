package com.example.mysql_connect.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Hotel {
    
    @Id
    private int HotelId;
    private int totalmembers;
    private double HotelPrice;
    private String Name;
    private String Checkin;
    private String checkout;
    private int hotelNo;

    

    public Hotel() {
    }



    public Hotel(int hotelId, int totalmembers, double hotelPrice, String name, String checkin, String checkout,int hotelNo) {
        HotelId = hotelId;
        this.totalmembers = totalmembers;
        HotelPrice = hotelPrice;
        Name = name;
        Checkin = checkin;
        this.checkout = checkout;
        this.hotelNo=hotelNo;
    }



    public int getHotelId() {
        return HotelId;
    }



    public void setHotelId(int hotelId) {
        HotelId = hotelId;
    }



    public int getTotalmembers() {
        return totalmembers;
    }



    public void setTotalmembers(int totalmembers) {
        this.totalmembers = totalmembers;
    }



    public double getHotelPrice() {
        return HotelPrice;
    }



    public void setHotelPrice(double hotelPrice) {
        HotelPrice = hotelPrice;
    }



    public String getName() {
        return Name;
    }



    public void setName(String name) {
        Name = name;
    }



    public String getCheckin() {
        return Checkin;
    }



    public void setCheckin(String checkin) {
        Checkin = checkin;
    }



    public String getCheckout() {
        return checkout;
    }



    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }



    public int getHotelNo() {
        return hotelNo;
    }



    public void setHotelNo(int hotelNo) {
        this.hotelNo = hotelNo;
    }

    
   
    
}