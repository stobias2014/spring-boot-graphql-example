package com.tobias.saul.springbootgraphqlexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobias.saul.springbootgraphqlexample.entity.Food;
import com.tobias.saul.springbootgraphqlexample.repository.FoodRepository;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
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
	public List<Food> getFoods() {
		return foodRepository.findAll();
	}
	
	@GraphQLQuery(name = "food")
	public Optional<Food> getFood(@GraphQLArgument(name = "id") Long id) {
		return foodRepository.findById(id);
	}
	
	@GraphQLMutation(name = "saveFood")
	public Food save(@GraphQLArgument(name = "food") Food food) {
		return foodRepository.save(food);
	}
	
	@GraphQLMutation(name = "deleteFood")
	public void deleteFood(@GraphQLArgument(name = "id") Long id) {
		foodRepository.deleteById(id);
	}

}
