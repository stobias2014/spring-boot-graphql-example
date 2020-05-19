package com.tobias.saul.springbootgraphqlexample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.leangen.graphql.annotations.GraphQLQuery;

@Entity
public class Food {
	
	@Id
	@GeneratedValue
	@GraphQLQuery()
	private Long id;
	private String name;

}
