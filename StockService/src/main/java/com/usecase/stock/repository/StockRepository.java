package com.usecase.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usecase.stock.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer>{

	Long deleteByCompanyCode(String companyCode);

	Stock findByCompanyCode(String companyCode);

//	List<Stock> findByPnrNo(String pnrNo);
//
////	List<Stock> findByEmailId(String emailId);
//
//	List<Stock> findByFlightAirlineName(String airline);

//	List<Stock> findByFlightAirlineNameAndBookStatus(String flightAirlineName, String string);
}
