package com.technical.test.quote.facade;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.technical.test.quote.dto.BudgetRequest;
import com.technical.test.quote.dto.DriverInformation;
import com.technical.test.quote.model.Car;
import com.technical.test.quote.model.CarDriver;
import com.technical.test.quote.model.Customer;
import com.technical.test.quote.model.Driver;
import com.technical.test.quote.model.Insurance;
import com.technical.test.quote.repository.CarDriverRepository;
import com.technical.test.quote.repository.CarRepository;
import com.technical.test.quote.repository.CustomerRepository;
import com.technical.test.quote.repository.DriverRepository;
import com.technical.test.quote.repository.InsuranceRepository;

@Component
public class InsuranceFacade {
	
	private static final String INSURANCE_NOT_FOUND = "Insurance not found";
	
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private DriverRepository driverRepository;
	@Autowired
	private CarDriverRepository carDriverRepository;
	@Autowired
	private InsuranceRepository insuranceRepository;
	
	public Insurance createNewInsurance(BudgetRequest request) {
		Insurance insurance = new Insurance();
		Driver mainDriver = saveMainDriver(request);
		Customer customer = saveCustomer(request, mainDriver);
		Car car = saveCarDetails(request);
		saveCarDriver(mainDriver, car, true);
		saveOtherDrivers(request, car);
		saveInsurance(customer, car, insurance);
		return insurance;
	}
	
	public Insurance getInsurance(long insuranceId) {
		Insurance insurance = insuranceRepository.findById(insuranceId).orElseThrow(() -> new RuntimeException(INSURANCE_NOT_FOUND));
		return insurance;
	}

	private void saveInsurance(Customer customer, Car car, Insurance insurance) {
		insurance.setCar(car);
		insurance.setCreationDt(LocalDate.now());
		insurance.setUpdatedAt(LocalDate.now());
		insurance.setCustomer(customer);
		insurance.setActive(true);
		insuranceRepository.saveAndFlush(insurance);
	}

	private void saveOtherDrivers(BudgetRequest request, Car car) {
		for (DriverInformation drivers : request.getOtherDrivers()) {
			Driver driver = new Driver();
			driver.setBirthDate(drivers.getBirthDate());
			driver.setDocument(drivers.getDocument());
			driverRepository.saveAndFlush(driver);
			saveCarDriver(driver, car, false);
		}
	}

	private void saveCarDriver(Driver driver, Car car, boolean isMainDriver) {
		CarDriver carDriver = new CarDriver();
		carDriver.setCar(car);
		carDriver.setDriver(driver);
		carDriver.setMainDriver(isMainDriver);
		carDriverRepository.saveAndFlush(carDriver);
	}
	
	private Car saveCarDetails(BudgetRequest request) {
		Car car = new Car();
		car.setFipeValue(request.getCarDetails().getFipeValue());
		car.setManufacturer(request.getCarDetails().getManufacturer());
		car.setModel(request.getCarDetails().getModel());
		car.setReleasedYear(request.getCarDetails().getReleasedYear());
		carRepository.saveAndFlush(car);
		return car;
	}

	private Customer saveCustomer(BudgetRequest request, Driver mainDriver) {
		Customer customer = new Customer();
		customer.setName(request.getMainDriver().getName());
		customer.setDriver(mainDriver);
		customerRepository.saveAndFlush(customer);
		return customer;
	}

	private Driver saveMainDriver(BudgetRequest request) {
		Driver mainDriver = new Driver();
		mainDriver.setBirthDate(request.getMainDriver().getBirthDate());
		mainDriver.setDocument(request.getMainDriver().getDocument());
		driverRepository.saveAndFlush(mainDriver);
		return mainDriver;
	}
	

}
