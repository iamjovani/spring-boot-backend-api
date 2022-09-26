package com.springboot.springboot.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springboot.domain.House;
import com.springboot.springboot.model.CreateHouseRequest;
import com.springboot.springboot.model.CreateHouseResponse;
import com.springboot.springboot.model.UpdateHouseRequest;
import com.springboot.springboot.repository.IHouseRepository;


@RestController
public class HousePricePredictorController {

    @Autowired
    IHouseRepository _HouseRepository;

    @RequestMapping(value = "/HousePricePredictor/House", method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody CreateHouseRequest request)
    {
        House houseRequest = new House(request.HousePrice, request.LotArea, request.Street, request.SaleCondtion, request.YearBuilt);
        _HouseRepository.save(houseRequest);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value="/HousePricePredictor/House/{id}", method=RequestMethod.GET)
    public Map<String, String> requestMethodName(@PathVariable String id) 
    {
        
        House houseObj = _HouseRepository.getReferenceById(id);
        CreateHouseResponse houseResponseObj = new CreateHouseResponse(houseObj);
        return houseResponseObj.getResponse();
    }
    
    @RequestMapping(value="HousePricePredictor/House/{id}", method=RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody UpdateHouseRequest request)
    {
        House houseObj= _HouseRepository.getReferenceById(id);
        houseObj.Update(request.HousePrice, request.LotArea, request.Street, request.SaleCondtion, request.YearBuilt);
        _HouseRepository.save(houseObj);
        return ResponseEntity.ok().build();
    }
    
}
