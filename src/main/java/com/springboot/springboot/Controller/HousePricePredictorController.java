package com.springboot.springboot.controller;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springboot.domain.House;
import com.springboot.springboot.model.CreateHouseRequest;
import com.springboot.springboot.model.CreateHouseResponse;
import com.springboot.springboot.model.UpdateHouseRequest;
import com.springboot.springboot.repository.IHouseRepository;


@RestController
@RequestMapping("${url.base.path}/HousePricePredictor")
public class HousePricePredictorController {

    @Autowired
    IHouseRepository _HouseRepository;

    @RequestMapping(value = "/House", method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody @Valid CreateHouseRequest request)
    {
        House houseRequest = new House(request.HousePrice, request.LotArea, request.Street, request.SaleCondtion, request.YearBuilt, "Admin");
        _HouseRepository.save(houseRequest);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/House", method = RequestMethod.GET)
    public @ResponseBody List<House> findAll()
    {
        List<House> houseRequest = _HouseRepository.findAll();
        return houseRequest;
    }

    @RequestMapping(value="/House/{id}", method=RequestMethod.GET)
    public Map<String, String> requestMethodName(@PathVariable String id) 
    {
        
        House houseObj = _HouseRepository.getReferenceById(id);
        CreateHouseResponse houseResponseObj = new CreateHouseResponse(houseObj);
        return houseResponseObj.getResponse();
    }
    
    @RequestMapping(value="House/{id}", method=RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody @Valid UpdateHouseRequest request)
    {
        House houseObj= _HouseRepository.getReferenceById(id);
        houseObj.Update(request.HousePrice, request.LotArea, request.Street, request.SaleCondtion, request.YearBuilt, "Admin");
        _HouseRepository.save(houseObj);
        return ResponseEntity.ok().build();
    }
    
}
