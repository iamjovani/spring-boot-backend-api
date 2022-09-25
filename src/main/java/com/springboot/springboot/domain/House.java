package com.springboot.springboot.domain;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "House")
public class House {

    @Id
    private String Id;

    @Column
    private double HousePrice;

    @Column
    private double LotArea;

    @Column
    private String Street;

    @Column
    private String SaleCondtion;

    @Column
    private int YearBuilt;

    public House(){
        
    }

    public House(double housePrice, double lotArea, String street, String saleCondtion, int yearBuilt) {
        Id = UUID.randomUUID().toString();
        HousePrice = housePrice;
        LotArea = lotArea;
        Street = street;
        SaleCondtion = saleCondtion;
        YearBuilt = yearBuilt;
    }

    public double getHousePrice() {
        return HousePrice;
    }

    public void setHousePrice(double housePrice) {
        HousePrice = housePrice;
    }

    public double getLotArea() {
        return LotArea;
    }

    public void setLotArea(double lotArea) {
        LotArea = lotArea;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getSaleCondtion() {
        return SaleCondtion;
    }

    public void setSaleCondtion(String saleCondtion) {
        SaleCondtion = saleCondtion;
    }

    public int getYearBuilt() {
        return YearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        YearBuilt = yearBuilt;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
