package com.springboot.springboot.model;

public class CreateHouseRequest {
    public double HousePrice;
    public double LotArea;
    public String Street;
    public String SaleCondtion;
    public int YearBuilt;



    public CreateHouseRequest(double housePrice, double lotArea, String street, String saleCondtion,
            int yearBuilt) {
        HousePrice = housePrice;
        LotArea = lotArea;
        Street = street;
        SaleCondtion = saleCondtion;
        YearBuilt = yearBuilt;
    }
    
}
