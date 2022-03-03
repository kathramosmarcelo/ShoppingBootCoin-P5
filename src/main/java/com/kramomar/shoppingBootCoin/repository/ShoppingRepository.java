package com.kramomar.shoppingBootCoin.repository;

import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;

import com.kramomar.shoppingBootCoin.Entity.Shopping;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ShoppingRepository {
	private final ReactiveRedisOperations<String, Shopping> redisOperations;
	  private final ReactiveHashOperations<String,String, Shopping> hashOperations;

	  public static final String KEY = "Shopping";
	  public ShoppingRepository(ReactiveRedisOperations<String, Shopping> redisOperations) {
	    this.redisOperations = redisOperations;
	    this.hashOperations = redisOperations.opsForHash();
	  }
	  
	  public Flux<Shopping> findall(){
	    return hashOperations.values(KEY);
	  }
	  
	  
	  public Mono<Shopping> save(Shopping shopping){
		return hashOperations.put(KEY, shopping.getId(), shopping).map(isSaved -> shopping);
	  }	  
}
