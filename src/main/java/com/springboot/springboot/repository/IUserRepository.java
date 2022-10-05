package com.springboot.springboot.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.springboot.domain.AppUser;


public interface IUserRepository extends JpaRepository<AppUser, String> {
    Optional<AppUser> findByUserName(String UserName);
}
