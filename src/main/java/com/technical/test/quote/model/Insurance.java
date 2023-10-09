package com.technical.test.quote.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="INSURANCE")
@Data
public class Insurance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;
	
	@Column(name="CREATION_DT")
	private LocalDate creationDt;
	
	@Column(name="UPDATED_AT")
	private LocalDate updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CAR_ID")
	private Car car;
	
	@Column(name="IS_ACTIVE")
	private boolean isActive;
	
	
	
	
	
	
	
	
	
	

}
