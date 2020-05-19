package com.tobias.saul.springbootgraphqlexample;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tobias.saul.springbootgraphqlexample.entity.Food;
import com.tobias.saul.springbootgraphqlexample.service.FoodService;

@SpringBootApplication
public class SpringBootGraphqlExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGraphqlExampleApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(FoodService foodService) {
		return args -> {
			Stream.of("Pizza", "Spam", "Eggs", "Avocado").forEach(name -> {
				Food food = new Food();
				food.setName(name);
				foodService.save(food);
			});
			foodService.getFoods().forEach(System.out::println);
		};
	}

}
