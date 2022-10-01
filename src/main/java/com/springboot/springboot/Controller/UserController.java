package com.springboot.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springboot.repository.IUserRepository;

@RestController
@RequestMapping("${url.base.path}/User")
public class UserController {
    
    @Autowired
    IUserRepository _UserRepository;

    @RequestMapping(value = "/Create", method = RequestMethod.POST)
    public ResponseEntity<?> post(/*@RequestBody @Valid CreateUserRequest request*/)
    {
        //User userRequest = new User(request.HousePrice, request.LotArea, request.Street, request.SaleCondtion, request.YearBuilt, "Admin");
        //_UserRepository.save(houseRequest);
        return ResponseEntity.ok().build();
    }
}
