package com.stockmarket.companydetails.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmarket.companydetails.entity.CompanyDetails;

@Repository
public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, Integer> {

	public Optional<CompanyDetails> findByCompanyCode(String companycode);
	
	public long deleteByCompanyCode(String companycode);
}


 
