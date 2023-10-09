package com.technical.test.quote.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="CAR")
@Data
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String model;
	
	@Column
	private String manufacturer;
	
	@Column(name="RELEASED_YEAR")
	private String releasedYear;
	
	@Column(name="FIPE_VALUE")
	private float fipeValue;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    private List<Claims> claims;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    private List<CarDriver> carDriver;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
	private List<Insurance> insurance;

}
