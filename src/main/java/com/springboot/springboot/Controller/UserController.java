package com.springboot.springboot.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springboot.domain.AppUser;
import com.springboot.springboot.domain.Role;
import com.springboot.springboot.model.CreateUserRequest;
import com.springboot.springboot.repository.IRoleRepository;
import com.springboot.springboot.repository.IUserRepository;

@RestController
@RequestMapping("${url.base.path}/user")
public class UserController {
    
    @Autowired
    IUserRepository _UserRepository;

    @Autowired
    IRoleRepository _RoleRepository;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody @Valid CreateUserRequest request)
    {

        Role role = _RoleRepository.getReferenceById(request.RoleId.toString());

        if (role == null)
        {
            ResponseEntity.notFound().build();
        }

        Collection<Role> lRoles = new ArrayList<>();
        lRoles.add(role);

        AppUser userRequest = new AppUser(request.FirstName, request.LastName, request.UserName, request.Password, lRoles, "Admin");
        _UserRepository.save(userRequest);
        return ResponseEntity.ok().build();
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<AppUser> findAll()
    {
        List<AppUser> houseRequest = _UserRepository.findAll();
        return houseRequest;
    }

    // @RequestMapping(value="/{id}", method=RequestMethod.GET)
    // public Map<String, String> requestMethodName(@PathVariable String id) 
    // {
        
    //     Role role = _RoleRepository.getReferenceById(id.toString());
    //     CreateHouseResponse houseResponseObj = new CreateHouseResponse(houseObj);
    //     return houseResponseObj.getResponse();
    // }
    
}
