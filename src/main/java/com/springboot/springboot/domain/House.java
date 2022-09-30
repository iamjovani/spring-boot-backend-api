package com.springboot.springboot.domain;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "House")
public class House extends Auditable{

    @Id
    private String Id;
    private float HousePrice;
    private float LotArea;
    private String Street;
    private String SaleCondtion;
    private int YearBuilt;

    public House(){
        
    }

    public House(float housePrice, float lotArea, String street, String saleCondtion, int yearBuilt, String createdBy) {
        super(createdBy);
        Id = UUID.randomUUID().toString();
        HousePrice = housePrice;
        LotArea = lotArea;
        Street = street;
        SaleCondtion = saleCondtion;
        YearBuilt = yearBuilt;
    }

    public void Update(float housePrice, float lotArea, String street, String saleCondtion, int yearBuilt, String modifiedBy){
        super.setModifiedBy(modifiedBy);
        HousePrice = housePrice;
        LotArea = lotArea;
        Street = street;
        SaleCondtion = saleCondtion;
        YearBuilt = yearBuilt;
    }

    public double getHousePrice() {
        return HousePrice;
    }

    public void setHousePrice(float housePrice) {
        HousePrice = housePrice;
    }

    public double getLotArea() {
        return LotArea;
    }

    public void setLotArea(float lotArea) {
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
