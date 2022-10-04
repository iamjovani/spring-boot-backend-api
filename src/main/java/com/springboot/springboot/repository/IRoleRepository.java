package com.springboot.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.springboot.domain.Role;

public interface IRoleRepository extends JpaRepository<Role, String> {
    
}
