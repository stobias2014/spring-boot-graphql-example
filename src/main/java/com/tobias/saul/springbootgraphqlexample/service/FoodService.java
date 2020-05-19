package com.tobias.saul.springbootgraphqlexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobias.saul.springbootgraphqlexample.entity.Food;
import com.tobias.saul.springbootgraphqlexample.repository.FoodRepository;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class FoodService {
	
	private final FoodRepository foodRepository;
	
	@Autowired
	public FoodService(FoodRepository foodRepository) {
		this.foodRepository = foodRepository;
	}
	
	@GraphQLQuery(name = "foods")
	public List<Food> getAll() {
		return foodRepository.findAll();
	}

}
