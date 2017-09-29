package com.cgi.farm.service;

import java.util.List;

import com.cgi.farm.model.AnimalType;
import com.cgi.farm.model.Farmer;
import com.cgi.farm.model.Food;
import com.cgi.farm.model.FoodType;

public interface FoodService {
	Food findByID(int ID);
	List<Food> findAll();
}
