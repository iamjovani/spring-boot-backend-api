package com.springboot.springboot.domain;

import java.util.Collection;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class AppUser extends Auditable{
    
    @Id
    private String Id;
    private String FirstName;
    private String LastName;
    private String UserName;
    private String Password;
   // @ManyToMany(fetch = FetchType.EAGER)
    //private Collection<Role> Roles = new ArrayList<>();

    

    public AppUser() {
    }



    public AppUser(String firstName, String lastName, String userName, String password,
            Collection<Role> roles) {
        Id = UUID.randomUUID().toString();
        FirstName = firstName;
        LastName = lastName;
        UserName = userName;
        Password = password;
        //Roles = roles;
    }



    public String getId() {
        return Id;
    }



    public void setId(String id) {
        Id = id;
    }



    public String getFirstName() {
        return FirstName;
    }



    public void setFirstName(String firstName) {
        FirstName = firstName;
    }



    public String getLastName() {
        return LastName;
    }



    public void setLastName(String lastName) {
        LastName = lastName;
    }



    public String getUserName() {
        return UserName;
    }



    public void setUserName(String userName) {
        UserName = userName;
    }



    public String getPassword() {
        return Password;
    }



    public void setPassword(String password) {
        Password = password;
    }



    // public Collection<Role> getRoles() {
    //     return Roles;
    // }



    // public void setRoles(Collection<Role> roles) {
    //     Roles = roles;
    // }

}
