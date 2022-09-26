package com.springboot.springboot.model;

import java.util.List;
import java.util.Map;

import com.springboot.springboot.domain.House;

public class CreateHouseCollectionResponse {

    private List<Map<String,String>> HousesObjList;
    private List<House> House;

    public CreateHouseCollectionResponse(List<House> house){

        this.House = house;
    }

    public List<Map<String,String>> getResponse(){

        for(House houseObj : House){
            CreateHouseResponse houseResponseObj = new CreateHouseResponse(houseObj);
            Map<String, String> houseResponse = houseResponseObj.getResponse();
            HousesObjList.add(houseResponse);
        }
        return HousesObjList;
    }
    
}
