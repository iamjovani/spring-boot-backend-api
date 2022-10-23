package com.springboot.springboot.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springboot.springboot.domain.AppUser;
import com.springboot.springboot.domain.Role;

public class UserResponse {

    private AppUser appUser;

    public UserResponse(AppUser appUser) {
        
        this.appUser = appUser;
    }

    public Map<String, Object> getResponse() {
        
        HashMap<String, Object> map = new HashMap<>();

        map.put("id", String.valueOf(appUser.getId()));
        map.put("username", appUser.getUserName());
        map.put("firstname", appUser.getUserName());
        map.put("lastname", appUser.getLastName());
        map.put("roles", appUser.getRoles());

        return map;
    }
    
}
