package com.technical.test.quote.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CAR_DRIVER")
@Data
public class CarDriver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="DRIVER_ID")
	private Driver driver;
	
	@ManyToOne
	@JoinColumn(name="CAR_ID")
	private Car car;
	
	@Column(name="IS_MAIN_DRIVER")
	private boolean isMainDriver;

}
