//package com.assignment.service;
//
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import com.assignment.entity.BookFlight;
//import com.assignment.repository.BookFlightRepository;
//
//@Service
//public class KafkaConsumerListener {
//
//    private static final String TOPIC = "kafka_topic";
//    
//    @Autowired
//	StockRepository bookFlightRepository;
//
//    @KafkaListener(topics = TOPIC, groupId="group_id", containerFactory = "userKafkaListenerFactory")
//    public void consumeJson(String flightAirlineName) {
//        System.out.println("Consumed Kafka message," + flightAirlineName);
//        String[] split = flightAirlineName.split(":");
//        if(split.length == 2) {
//        	String extractedAirlineName = split[1].trim();
//	        List<Stock> blockingFlight = bookFlightRepository.findByFlightAirlineNameAndBookStatus(extractedAirlineName,"booked");
//	       System.out.println("Blocking"+blockingFlight);
//	        for (Stock bookFlight : blockingFlight) {
//				bookFlight.setBookStatus("Blocked");
//				bookFlightRepository.save(bookFlight);
//			}
//        }
//        
//    }
//    
//}