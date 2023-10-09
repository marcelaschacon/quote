package com.technical.test.quote.service;


import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.technical.test.quote.dto.BudgetRequest;
import com.technical.test.quote.dto.BudgetResponse;
import com.technical.test.quote.facade.InsuranceFacade;
import com.technical.test.quote.model.Insurance;
import com.technical.test.quote.repository.InsuranceRepository;

@Service
public class InsuranceService {
	
	private static final float BASE_VALUE = 0.06f;
	private static final float EXTRA_VALUE = 0.02f;
	
	@Autowired
	private InsuranceRepository insuranceRepository;
	@Autowired
	private InsuranceFacade insuranceFacade;
	
	public Insurance createNewInsurance(BudgetRequest request) {
		return insuranceFacade.createNewInsurance(request);
	}
	
	public void updateInsurance(BudgetRequest request) {
		//budgetStoreFacade.updateInsurance(request);
	}
	
	public BudgetResponse getBudget(long insuranceId) {
		BudgetResponse budgetReponse = new BudgetResponse();
		Insurance insurance = insuranceFacade.getInsurance(insuranceId);
		Float budgetValue = sumBudget(insurance);
		budgetReponse.setBudget(budgetValue);
		return budgetReponse;
	}

	public void deleteBudget(long insuranceId) {
		insuranceRepository.deleteById(insuranceId);
	}
	
	private Float sumBudget(Insurance insurance) {
		float fipeValue = insurance.getCar().getFipeValue();
		Float budgetValue = fipeValue * BASE_VALUE;
		float extraValue = fipeValue * EXTRA_VALUE;
		int age = getAge(insurance);
		if(age > 18 && age < 25) {
			budgetValue = budgetValue + extraValue;
		} else if(!insurance.getCar().getClaims().isEmpty()) {
			budgetValue = budgetValue + extraValue;
		} else if(!insurance.getCustomer().getDriver().getClaims().isEmpty()) {
			budgetValue = budgetValue + extraValue;
		}
		return budgetValue;
	}

	
	private int getAge(Insurance insurance) {
	    return Period.between(insurance.getCustomer().getDriver().getBirthDate(), LocalDate.now()).getYears();
	}

}
