package com.springboot.springboot.model;

public class UpdateHouseRequest {

    public float HousePrice;
    public float LotArea;
    public String Street;
    public String SaleCondtion;
    public int YearBuilt;

    public UpdateHouseRequest(float housePrice, float lotArea, String street, String saleCondtion, int yearBuilt) {
        HousePrice = housePrice;
        LotArea = lotArea;
        Street = street;
        SaleCondtion = saleCondtion;
        YearBuilt = yearBuilt;
    }
}
