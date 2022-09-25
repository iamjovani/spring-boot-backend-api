package com.springboot.springboot.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.springboot.domain.House;

public interface IHouseRepository extends JpaRepository<House, String> {
    //House findBy(UUID published);
    //List<House> findByPriceList(Double title);
  }

