package com.technical.test.quote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technical.test.quote.model.Claims;

@Repository
public interface ClaimsRepository extends JpaRepository<Claims, Long> {


}