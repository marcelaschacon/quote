package com.technical.test.quote.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CUSTOMER")
@Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="DRIVER_ID")
	private Driver driver;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	private List<Insurance> insurance;
}
