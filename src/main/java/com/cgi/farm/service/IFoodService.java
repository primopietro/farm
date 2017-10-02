package com.cgi.farm.service;

import java.util.List;

import com.cgi.farm.model.Food;

public interface IFoodService {
	Food findByID(int ID);
	List<Food> findAll();
	void updateFood(Food aFood);
}
