package com.usecase.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.usecase.stock.entity.Stock;
import com.usecase.stock.repository.StockRepository;


@Service
public class StockService {
	
	
	@Autowired
	StockRepository stockRepository;

	public Stock addStock(Stock stock) {
		return stockRepository.save(stock);
	}

	public Long deleteStock(String companyCode) {
		return stockRepository.deleteByCompanyCode(companyCode);
	}

	public Stock getStockInfoByCompanyCode(String companyCode) {
		return stockRepository.findByCompanyCode(companyCode);
	}
	
//	@Cacheable(key="#pnrNo",value="bookflight-pnrkey-store")
//	public List<Stock> findByPnrNo(String pnrNo) {
//		return bookFlightRepository.findByPnrNo(pnrNo);
//		
//	}
//
//	@Cacheable(key="#emailId",value="bookflight-emailkey-store")
//	public List<Stock> findByEmailId(String emailId) {
//		return bookFlightRepository.findByEmailId(emailId);
//		
//	}
//
//	public BookFlightVo addFlightBooking(BookFlightVo bookFlight) throws NotFoundException {
//		List<PassengerVo> passengers = bookFlight.getPassengers();
//		if(bookFlight.getEmailId() == null)
//			throw new NotFoundException("email id cannot be null");
//		String generatedPnr = FindPnr.getPnrNo(6);
//		for (PassengerVo passengerVo : passengers) {
//			Stock bFlight = new Stock();
//			bFlight.setFlightNo(bookFlight.getFlightNo());
//			bFlight.setBookFlightTime(bookFlight.getBookFlightTime());
//			bFlight.setBookFlightFrom(bookFlight.getBookFlightFrom());
//			bFlight.setBookFlightDestinationTime(bookFlight.getBookFlightDestinationTime());
//			bFlight.setBookFlightTo(bookFlight.getBookFlightTo());
//			bFlight.setFlightAirlineName(bookFlight.getAirlineName());
//			bFlight.setUserName(bookFlight.getUserName());
//			bFlight.setEmailId(bookFlight.getEmailId());
//			bFlight.setFlightNo(bookFlight.getFlightNo());
//			bFlight.setEmailId(bookFlight.getEmailId());
//			bFlight.setBookFlightTime(bookFlight.getBookFlightTime());
//			bFlight.setPnrNo(generatedPnr);
//			bFlight.setBookMeal(bookFlight.getBookMeal());
//			bFlight.setPassengerName(passengerVo.getPassengerName());
//			bFlight.setPassengerGender(passengerVo.getPassengerGender());
//			bFlight.setAge(passengerVo.getAge());
//			bFlight.setBookStatus("booked");
//			bFlight.setBookingCost(bookFlight.getTotalCost());
//			bookFlightRepository.save(bFlight);
//		}
//		bookFlight.setPnrNo(generatedPnr);
//		return bookFlight;
//	}
//
//	public boolean deleteFlightBooking(String pnrNo) {
//		List<Stock> findByPnrNo = bookFlightRepository.findByPnrNo(pnrNo);
//		for (Stock bookFlight : findByPnrNo) {
//			long findDifferenceOfDate = DateConversion.findDifferenceOfDate(bookFlight.getBookFlightTime());
//			if(findDifferenceOfDate >= 1) {
////				bookFlight.setBookStatus("cancelled");
//				bookFlightRepository.delete(bookFlight);
//			}else
//				return false;
//		}
//		if(findByPnrNo.size()>0)
//			return true;
//		return false;
//		
//	}
//
////	public List<Flight> findByFlightDeatils(Flight bookFlight) {
////		return flightRepository.findByFlightDetails(bookFlight.getStartDate(),bookFlight.getEndDate(),bookFlight.getFromPlace(),
////				bookFlight.getToPlace(),0,"round");
////	}

	
	  
	
}
