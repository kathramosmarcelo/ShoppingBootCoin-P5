package com.kramomar.shoppingBootCoin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kramomar.shoppingBootCoin.Entity.Shopping;
import com.kramomar.shoppingBootCoin.Utils.Topic;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class KafkaProducer {


	@Autowired
	public  KafkaTemplate<String, Shopping> ShoppingkafkaTemplate;
	
	public String createShopping( double amount,String paymode,String numberPhone) {
		ShoppingkafkaTemplate.send(Topic.CREATE_SHOPPING, new Shopping("SHOP-001",amount,paymode,numberPhone,"88888888","hotmail@hotmail.com"));
	    return "Connecting Successfully :D";
	}

	public Shopping publishEventcreateWallet(Shopping shopping){
		ShoppingkafkaTemplate.send(Topic.CREATE_SHOPPING,shopping);
	    return shopping;
	}
	
	
	
	
	
	
	
	
    }

