package com.springboot.springboot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.springboot.springboot.domain.AppUser;

public class UserCollectionResponse {
    
    private List<Map<String,Object>> AppUserObjList = new ArrayList<Map<String,Object>>();
    private List<AppUser> AppUser;

    public UserCollectionResponse(List<AppUser> appUsers){

        this.AppUser = appUsers;
    }

    public List<Map<String,Object>> getResponse(){

        for(AppUser AppUserObj : AppUser){
            UserResponse ResponseObj = new UserResponse(AppUserObj);
            Map<String, Object> appUserResponse = ResponseObj.getResponse();
            AppUserObjList.add(appUserResponse);
        }

        return AppUserObjList;
    }
}
