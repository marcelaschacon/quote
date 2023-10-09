package com.technical.test.quote.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.technical.test.quote.dto.BudgetRequest;
import com.technical.test.quote.dto.BudgetResponse;
import com.technical.test.quote.facade.InsuranceFacade;
import com.technical.test.quote.model.Car;
import com.technical.test.quote.model.Claims;
import com.technical.test.quote.model.Customer;
import com.technical.test.quote.model.Driver;
import com.technical.test.quote.model.Insurance;
import com.technical.test.quote.repository.InsuranceRepository;


@ExtendWith(MockitoExtension.class)
class InsuranceServiceTest {
	
	private static final float EXPECTED_BUDGET = 19.98f;
	private static final float FIPE_VALUE = 333f;
	
	@Mock
	private InsuranceFacade insuranceFacade;
	@InjectMocks
	private InsuranceService insuranceService;
	
	private BudgetRequest budgetRequest = new BudgetRequest();
	private Insurance insurance = new Insurance();
	private BudgetResponse budgetResponse = new BudgetResponse();
	private Car car = new Car();
	private Customer customer = new Customer();
	private Driver driver = new Driver();
	
	@BeforeEach
	protected void setUp() {
		ArrayList<Claims> claimsList = new ArrayList<Claims>();
		car.setClaims(claimsList);
		car.setFipeValue(FIPE_VALUE);
		driver.setClaims(claimsList);
		driver.setBirthDate(LocalDate.now());
		customer.setDriver(driver);
		insurance.setCar(car);
		insurance.setCustomer(customer);
		budgetResponse.setBudget(333f);
	}
	
	
	@Test
	public void newInsuranceIsCreated() {
		when(insuranceFacade.createNewInsurance(budgetRequest)).thenReturn(insurance);
		Insurance createdInsurance = insuranceService.createNewInsurance(budgetRequest);
		assertEquals(insurance, createdInsurance);
	}
	
	@Test
	public void budgetIsCalculated() {
		when(insuranceFacade.getInsurance(1l)).thenReturn(insurance);
		BudgetResponse budgetResponse = insuranceService.getBudget(1l);
		assertEquals(EXPECTED_BUDGET, budgetResponse.getBudget());
	}


}
