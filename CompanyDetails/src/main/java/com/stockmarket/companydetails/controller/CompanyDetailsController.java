package com.stockmarket.companydetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmarket.companydetails.entity.CompanyDetails;
import com.stockmarket.companydetails.exception.CompanyCannotBeRegisteredException;
import com.stockmarket.companydetails.exception.CompanyNotFoundException;
import com.stockmarket.companydetails.service.CompanyDetailsService;

@RestController
@RequestMapping("/api/v1.0/market/company")
public class CompanyDetailsController {

	@Autowired
	private CompanyDetailsService companyDetailsService;

	@GetMapping("/getall")
	public ResponseEntity<List<CompanyDetails>> getAllCompanyDetails() {
		return new ResponseEntity<>(companyDetailsService.getAllCompanyDetails(), HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<CompanyDetails> getCompanyDetailsById(@PathVariable int id) throws CompanyNotFoundException {
		return new ResponseEntity<>(companyDetailsService.getById(id), HttpStatus.OK);
	}

	@GetMapping("/info/{companycode}")
	public ResponseEntity<CompanyDetails> getCompanyDetailsByCompanyCode(@PathVariable String companycode) throws CompanyNotFoundException {
		return new ResponseEntity<>(companyDetailsService.getByCompanyCode(companycode), HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<CompanyDetails> registerCompanyDetails(@RequestBody CompanyDetails companyDetails) throws CompanyCannotBeRegisteredException {
		return new ResponseEntity<>(companyDetailsService.postCompanyDetails(companyDetails), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CompanyDetails> updateCompanyDetails(@RequestBody CompanyDetails companyDetails,
			@PathVariable int id) throws CompanyNotFoundException {
		return new ResponseEntity<>(companyDetailsService.updateCompanyDetailsbyId(companyDetails, id), HttpStatus.OK);
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<Boolean> deleteCompanyDetails(@PathVariable int id) {
		return new ResponseEntity<>(companyDetailsService.deleteCompanyDetails(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{companyCode}")
	public ResponseEntity<Long> deleteCompanyDetailsByCompanyCode(@PathVariable String companyCode) {
		return new ResponseEntity<>(companyDetailsService.deleteCompanyDetailsByCompanycode(companyCode), HttpStatus.OK);
	}
}
