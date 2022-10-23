package com.springboot.springboot.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.boot.ansi.AnsiOutput.Enabled;

@Entity
public class AppUser extends Auditable{
    
    @Id
    private String Id;
    private String FirstName;
    private String LastName;
    private String userName;
    private String Password;
    private boolean Enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> Roles = new ArrayList<>();

    public AppUser() {
    }



    public AppUser(String firstName, String lastName, String userName, String password,
            Collection<Role> roles, String createdBy) {
        super(createdBy);
        Id = UUID.randomUUID().toString();
        FirstName = firstName;
        LastName = lastName;
        this.userName = userName;
        Password = password;
        Roles = roles;
        Enabled = true;
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
        return this.userName;
    }



    public void setUserName(String userName) {
        this.userName = userName;
    }



    public String getPassword() {
        return Password;
    }



    public void setPassword(String password) {
        Password = password;
    }

    public boolean getEnabled(){
        return Enabled;
    }

    public void setEnabled(boolean enabled){
        Enabled = enabled;
    }



    public Collection<Role> getRoles() {
        return Roles;
    }



    public void setRoles(Collection<Role> roles) {
        Roles = roles;
    }

}
