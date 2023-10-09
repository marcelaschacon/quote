package com.technical.test.quote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.technical.test.quote.dto.BudgetRequest;
import com.technical.test.quote.dto.BudgetResponse;
import com.technical.test.quote.model.Insurance;
import com.technical.test.quote.service.InsuranceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Insurance")
@RestController
@RequestMapping("/v1")
public class InsuranceController {
	
	@Autowired
	private InsuranceService insuranceService;

	@PostMapping(path = "/insurance/budget")
	@ApiOperation(value = "This operation is used to create a new Insurance")
	public ResponseEntity<Insurance> createNewInsurance(@ApiParam(value = "Client Informations", required = true) @RequestBody BudgetRequest json) {
		
		try {
			Insurance insurance = insuranceService.createNewInsurance(json);
			return new ResponseEntity<Insurance>(insurance, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping(path = "/insurance/budget/{insuranceId}")
	@ApiOperation(value = "This operation is used to retrieve an Insurance")
	public ResponseEntity<BudgetResponse> retrieveBudget(@ApiParam(value = "Client Informations", required = true) @RequestParam long insuranceId) {
		
		
		try {
			BudgetResponse budget = insuranceService.getBudget(insuranceId);
			return new ResponseEntity<BudgetResponse>(budget, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@PostMapping(path = "/insurance/budget/{insuranceId}")
	@ApiOperation(value = "This operation is used to retrieve an Insurance")
	public ResponseEntity<Object> changeBudget(@ApiParam(value = "Client Informations", required = true) @RequestParam long insuranceId) {
		
//			insuranceService.getBudget(insuranceId);

			return new ResponseEntity<>("", HttpStatus.OK);

	}
	
	@DeleteMapping(path = "/insurance/budget/{insuranceId}")
	@ApiOperation(value = "This operation is used to delete an Insurance")
	public ResponseEntity<Object> removeBudget(@ApiParam(value = "Client Informations", required = true) @RequestParam long insuranceId) {
		
			insuranceService.deleteBudget(insuranceId);

			return new ResponseEntity<>("Insurance was deleted", HttpStatus.OK);

	}
	
}