package com.springboot.springboot.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class CreateHouseRequest {

    @Min(value = 1, message = "House price required")
    public float HousePrice;

    @Min(value = 1, message = "Lot Area required required")
    public float LotArea;

    @NotBlank(message = "Street Address required")
    public String Street;

    @NotBlank(message = "Sale Condition required")
    public String SaleCondtion;

    @Min(value = 1700, message = "Year built required")
    public int YearBuilt;



    public CreateHouseRequest(float housePrice, float lotArea, String street, String saleCondtion,
            int yearBuilt) {
        HousePrice = housePrice;
        LotArea = lotArea;
        Street = street;
        SaleCondtion = saleCondtion;
        YearBuilt = yearBuilt;
    }
    
}
