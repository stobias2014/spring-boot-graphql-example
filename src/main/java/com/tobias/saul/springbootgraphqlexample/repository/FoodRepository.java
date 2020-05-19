package com.tobias.saul.springbootgraphqlexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobias.saul.springbootgraphqlexample.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long>{

}
