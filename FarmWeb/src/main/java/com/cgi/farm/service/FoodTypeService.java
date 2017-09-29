package com.cgi.farm.service;

import java.util.List;

import com.cgi.farm.model.AnimalType;
import com.cgi.farm.model.Farmer;
import com.cgi.farm.model.FoodType;

public interface FoodTypeService {
	FoodType findByName(String name);
	List<FoodType> findAll();
}
