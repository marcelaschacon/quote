package com.technical.test.quote.controller;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.technical.test.quote.dto.BudgetRequest;
import com.technical.test.quote.service.InsuranceService;

@ExtendWith(MockitoExtension.class)
class InsuranceControllerTest {
	
	@Mock
	private InsuranceService insuranceService;
	@InjectMocks
	private InsuranceController insuranceController;
	
	private BudgetRequest budgetRequest;
	
	@Test
	public void newBudgetServiceIsCalled() {
		insuranceController.createNewInsurance(budgetRequest);
		verify(insuranceService).createNewInsurance(budgetRequest);
		
	}
	

}
