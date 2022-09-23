package com.springboot.springboot.model;

public class CreateHouseRequest {
    private double HousePrice;
    private double LotArea;
    private double SquareFeet;
    private String SaleCondtion;
    private int YearBuilt;


    
    public CreateHouseRequest() {
    }

    public CreateHouseRequest(double housePrice, double lotArea, double squareFeet, String saleCondtion,
            int yearBuilt) {
        HousePrice = housePrice;
        LotArea = lotArea;
        SquareFeet = squareFeet;
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
    public double getSquareFeet() {
        return SquareFeet;
    }
    public void setSquareFeet(double squareFeet) {
        SquareFeet = squareFeet;
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
