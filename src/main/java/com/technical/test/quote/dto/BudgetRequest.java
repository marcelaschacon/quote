package com.technical.test.quote.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BudgetRequest {
	
	private DriverInformation mainDriver;
	private CarDetails carDetails;
	private List<DriverInformation> otherDrivers;
	

}
