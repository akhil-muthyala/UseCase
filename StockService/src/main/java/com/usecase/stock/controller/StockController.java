package com.usecase.stock.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.usecase.stock.entity.CompanyDetails;
import com.usecase.stock.entity.Stock;
import com.usecase.stock.service.StockService;


@RestController
@RequestMapping("/api/v1.0/market/stock")
@CrossOrigin
public class StockController {

	@Autowired
	RestTemplate restTemplate;
	
//	@Autowired
//    private Environment env;
	
	public static String companyServiceURL;

	/*
	 * http://localhost:8L080/api/v1.0/flight/user/search
	 */
	
	@Autowired
	StockService stockService;
	
	@PostMapping("/add/{companyCode}")
	public Stock addStock(@PathVariable String companyCode,@RequestBody Stock stock) {
		//checking whether company exists
		HttpMethod method = HttpMethod.GET;
		HttpEntity<?> requestEntity = new HttpEntity<>(stock);
		ParameterizedTypeReference<CompanyDetails> responseType = new ParameterizedTypeReference<CompanyDetails>() {
		};
		companyServiceURL = "http://COMPANY-SERVICE/api/v1.0/market/company/info/";
		System.out.println(companyServiceURL);
		ResponseEntity<CompanyDetails> res = restTemplate.exchange(companyServiceURL+companyCode, method, requestEntity,responseType);
		if(res.getBody().getCompanyCode() != null) {
			stock.setCompanyCode(res.getBody().getCompanyCode());
			return stockService.addStock(stock);
		}
		return null;
	}
	
	@Transactional
	@PostMapping("/delete/{companyCode}")
	public Long deleteStock(@PathVariable String companyCode) {
		return stockService.deleteStock(companyCode);
	}
	
	@GetMapping("/getStockInfo/{companyCode}")
	public Stock getStockInfo(@PathVariable String companyCode) {
		return stockService.getStockInfoByCompanyCode(companyCode);
	}
	
//	@PostMapping("/search")
//	public List<FlightVo> findBy(@RequestBody FlightVo bookFlight) {
//		// find all flights from database -> admin-service
//
//		String url = "http://ADMIN-SERVICE/api/v1.0/flight/user/search";
//		System.out.println(bookFlight);
//		HttpMethod method = HttpMethod.POST;
//		HttpEntity<?> requestEntity = new HttpEntity<>(bookFlight);
//		ParameterizedTypeReference<List<FlightVo>> responseType = new ParameterizedTypeReference<List<FlightVo>>() {
//		};
//
//		ResponseEntity<List<FlightVo>> res = restTemplate.exchange(url, method, requestEntity, responseType);
//		System.out.println("printing body");
//		System.out.println(res.getBody());
//		return res.getBody();
//	}
//
//	/*
//	 * http://localhost:8080/api/v1.0/flight/user/ticket/{pnr}
//	 */
//	@GetMapping("/ticket/{pnrNo}")
//	public List<BookFlight> viewHistoryViaPnr(@PathVariable String pnrNo) {
//		return userService.findByPnrNo(pnrNo);
//	}
//
//	/*
//	 * http://localhost:8080/api/v1.0/flight/user/booking/history/{emailId}
//	 */
//	@GetMapping("/booking/history/{emailId}")
//	public List<BookFlight> viewHistory(@PathVariable String emailId) {
//		return userService.findByEmailId(emailId);
//	}
//
//	/*
//	 * http://localhost:8080/api/v1.0/flight/user/booking/{flightId}
//	 */
//	@PostMapping("/booking/{flightId}")
//	public BookFlightVo addFlightBooking(@RequestBody BookFlightVo bookFlight, @PathVariable("flightId") int flightId) throws NotFoundException {
//		String url = "http://ADMIN-SERVICE/api/v1.0/flight/user/getDetails/"+flightId;
//		System.out.println(bookFlight);
//		HttpMethod method = HttpMethod.GET;
//		HttpEntity<?> requestEntity = new HttpEntity<>(null, null);
//		ParameterizedTypeReference<FlightVo> responseType = new ParameterizedTypeReference<FlightVo>() {
//		};
//
//		ResponseEntity<FlightVo> res = restTemplate.exchange(url, method, requestEntity, responseType);
//		System.out.println("printing response" + res.getBody());
//		FlightVo body = res.getBody();
//		if(body  != null) {
//			bookFlight.setFlightNo(body.getFlightNumber());
//			bookFlight.setBookFlightTime(body.getStartDate());
//			bookFlight.setBookFlightFrom(body.getFromPlace());
//			bookFlight.setBookFlightDestinationTime(body.getEndDate());
//			bookFlight.setBookFlightTo(body.getToPlace());
//			bookFlight.setAirlineName(body.getAirlineName());
//			return userService.addFlightBooking(bookFlight);
//		}
//		throw new NotFoundException("Booking unsuccessFul");
//	}
//
//	/*
//	 * http://localhost:8080/api/v1.0/flight/user/booking/cancel/{pnrNo}
//	 */
//	@DeleteMapping("/booking/cancel/{pnrNo}")
//	public boolean deleteFlightBooking(@PathVariable String pnrNo) {
//		return userService.deleteFlightBooking(pnrNo);
//	}

}
