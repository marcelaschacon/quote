package com.technical.test.quote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technical.test.quote.model.CarDriver;

@Repository
public interface CarDriverRepository extends JpaRepository<CarDriver, Long> {


}