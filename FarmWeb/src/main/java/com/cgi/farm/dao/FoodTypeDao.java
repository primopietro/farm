package com.cgi.farm.dao;

import java.util.List;

import com.cgi.farm.model.AnimalType;
import com.cgi.farm.model.Farmer;
import com.cgi.farm.model.FoodType;

public interface FoodTypeDao {

	List<FoodType> findAll();
	
	FoodType findByName(String name);
}
