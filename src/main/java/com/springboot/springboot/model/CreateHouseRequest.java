package com.springboot.springboot.model;

public class CreateHouseRequest {
    private double HousePrice;
    private double LotArea;
    private String Street;
    private String SaleCondtion;
    private int YearBuilt;


    
    public CreateHouseRequest() {
    }

    public CreateHouseRequest(double housePrice, double lotArea, String street, String saleCondtion,
            int yearBuilt) {
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
   
    
}
