package com.technical.test.quote.model;

import java.time.LocalDate;
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
@Table(name="DRIVER")
@Data
public class Driver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String document;
	
	@Column
	private LocalDate birthDate;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "driver")
    private List<Claims> claims;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "driver")
    private List<CarDriver> carDriver;

}
