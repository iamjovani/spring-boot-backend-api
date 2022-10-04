package com.springboot.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Role {

    @Id
    private String Id;
    private String Code;
    private String Name;

    

    public Role() {
    }

    public Role(String id, String code, String name) {
        Id = id;
        Code = code;
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
       
}
