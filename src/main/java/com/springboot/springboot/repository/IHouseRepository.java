package com.springboot.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.springboot.domain.House;

public interface IHouseRepository extends JpaRepository<House, String> {
    //List<House> findByPriceList(Double title);
  }

