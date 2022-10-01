package com.springboot.springboot.repository;
import com.springboot.springboot.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<AppUser, String> {
    
}
