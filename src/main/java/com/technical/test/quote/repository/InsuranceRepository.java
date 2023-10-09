package com.technical.test.quote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technical.test.quote.model.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {


}