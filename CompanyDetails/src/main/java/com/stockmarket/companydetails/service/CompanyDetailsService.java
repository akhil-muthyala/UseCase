package com.stockmarket.companydetails.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmarket.companydetails.entity.CompanyDetails;
import com.stockmarket.companydetails.exception.CompanyCannotBeRegisteredException;
import com.stockmarket.companydetails.exception.CompanyNotFoundException;
import com.stockmarket.companydetails.repository.CompanyDetailsRepository;

@Service
public class CompanyDetailsService {

	@Autowired
	CompanyDetailsRepository companyDetailsRepository;

	public List<CompanyDetails> getAllCompanyDetails() {
		return companyDetailsRepository.findAll();
	}

	public CompanyDetails getById(int id) throws CompanyNotFoundException {
		Optional<CompanyDetails> findById = companyDetailsRepository.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		} else {
			throw new CompanyNotFoundException("Company not found in DB for the id: "+ id) ;
		}
	}
	
	public CompanyDetails getByCompanyCode(String companycode) throws CompanyNotFoundException {
		Optional<CompanyDetails> findByCompanycode= companyDetailsRepository.findByCompanyCode(companycode);
		if(findByCompanycode.isPresent()) {
			return findByCompanycode.get();
		}
		else {
			throw new CompanyNotFoundException("Company not found in DB for the companycode: "+ companycode) ;
		}
	}

	public CompanyDetails postCompanyDetails(CompanyDetails obj) throws CompanyCannotBeRegisteredException {
		Optional<CompanyDetails> findByCompanyCode = companyDetailsRepository.findByCompanyCode(obj.getCompanyCode());
		if(!findByCompanyCode.isPresent() && obj.getCompanyTurnover() > 100000000) {
		return companyDetailsRepository.save(obj);
		}
		else {
		throw new CompanyCannotBeRegisteredException("Company Cannot be registered because the Company code already exits or company turnover should be greater than 10Cr");
		}
	}

	public CompanyDetails updateCompanyDetailsbyId(CompanyDetails companydetails, int id) throws CompanyNotFoundException {
		companydetails.setId(id);

		Optional<CompanyDetails> findById = companyDetailsRepository.findById(id);

		if (findById.isPresent()) {
			CompanyDetails companydetailsObj = findById.get();
		//	companydetailsObj.setCompanyCode(companydetails.getCompanyCode());
			companydetailsObj.setCompanyName(companydetails.getCompanyName());
			companydetailsObj.setCompanyCEO(companydetails.getCompanyCEO());
			companydetailsObj.setCompanyTurnover(companydetails.getCompanyTurnover());
			companydetailsObj.setCompanyWebsite(companydetails.getCompanyWebsite());
			companydetailsObj.setStockExchange(companydetails.getStockExchange());
			companyDetailsRepository.save(companydetailsObj);
			return companydetailsObj;
		} else {
			throw new CompanyNotFoundException("Cannot update the Company details, Company id "+ id +" is not found in DB");
		}

	}

	public boolean deleteCompanyDetails(int id)  {
		Optional<CompanyDetails> findById = companyDetailsRepository.findById(id);
		if (findById.isPresent()) {
			companyDetailsRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
	@Transactional
	public long deleteCompanyDetailsByCompanycode(String companycode)  {
		Optional<CompanyDetails> findByCompanyCode = companyDetailsRepository.findByCompanyCode(companycode);
		if (findByCompanyCode.isPresent()) {
			long num = companyDetailsRepository.deleteByCompanyCode(companycode);
			return num;
		} else {
			return 0;
		}
	}
}
