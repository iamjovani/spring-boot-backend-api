package com.springboot.springboot.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springboot.Entity.*;
import com.springboot.springboot.model.CreateHouseRequest;
import com.springboot.springboot.model.CreateHouseResponse;

import java.util.Map;

@RestController
public class HousePricePredictorController {

    @RequestMapping(value = "/HousePricePredictor/House", method = RequestMethod.POST)
    public Map<String, String> test(@RequestBody CreateHouseRequest request)
    {
        House houseRequest = new House(request.getHousePrice(), request.getLotArea(), request.getSquareFeet(), request.getSaleCondtion(), request.getYearBuilt());
        CreateHouseResponse status = new CreateHouseResponse(houseRequest);
        return status.getResponse();
    }
    
}
