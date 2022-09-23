package com.springboot.springboot.model;
import java.util.HashMap;
import java.util.Map;

import com.springboot.springboot.Entity.*;

public class CreateHouseResponse {

    private House House;

    public CreateHouseResponse(House house) {
        
        House = house;
    }

    public Map<String, String> getResponse() {
        
        HashMap<String, String> map = new HashMap<>();

        map.put("houseprice", String.valueOf(House.getHousePrice()));
        map.put("salecondition", House.getSaleCondtion());
        map.put("yearBuilt", String.valueOf(House.getYearBuilt()));

        return map;
    }
}
    
