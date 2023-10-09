package com.technical.test.quote.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDetails {
	
	private String model;
	private String manufacturer;
	private String releasedYear;
	private float fipeValue;

}