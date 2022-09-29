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
    private double HousePrice;
    private double LotArea;
    private String Street;
    private String SaleCondtion;
    private int YearBuilt;

    public House(){
        
    }

    public House(double housePrice, double lotArea, String street, String saleCondtion, int yearBuilt, String createdBy) {
        super(createdBy);
        Id = UUID.randomUUID().toString();
        HousePrice = housePrice;
        LotArea = lotArea;
        Street = street;
        SaleCondtion = saleCondtion;
        YearBuilt = yearBuilt;
    }

    public void Update(double housePrice, double lotArea, String street, String saleCondtion, int yearBuilt, String modifiedBy){
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
