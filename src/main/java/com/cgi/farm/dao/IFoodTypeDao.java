package com.cgi.farm.dao;

import java.util.List;

import com.cgi.farm.model.FoodType;

public interface IFoodTypeDao {

	List<FoodType> findAll();
	
	FoodType findByName(String name);
}
