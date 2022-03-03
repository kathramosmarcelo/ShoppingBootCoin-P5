package com.kramomar.shoppingBootCoin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kramomar.shoppingBootCoin.Entity.Shopping;
import com.kramomar.shoppingBootCoin.Service.KafkaProducer;
import com.kramomar.shoppingBootCoin.repository.ShoppingRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ShoppingBootCoin")
public class KafkaController {

	private final KafkaProducer kafkaProducer;
	
	private final ShoppingRepository shoppingRepository;
	
	@GetMapping("/Data/amount/{amount}/paymode/{paymode}/numberPhone/{numberPhone}")
	public String SendPayment(@PathVariable double amount,@PathVariable String paymode,@PathVariable String numberPhone) {
		return kafkaProducer.createShopping(amount,paymode, numberPhone);
	}
	
	
	@GetMapping("/getall")
	public Flux<Shopping> all() {
	return shoppingRepository.findall();
	}
	    
	 
	@PostMapping
	Mono<Shopping> createUser(@RequestBody Shopping shopping) {
	return shoppingRepository.save(shopping);
	}
}