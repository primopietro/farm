package com.cgi.farm.service;

import java.util.List;

import com.cgi.farm.model.FoodType;

public interface IFoodTypeService {
	FoodType findByName(String name);
	List<FoodType> findAll();
}
