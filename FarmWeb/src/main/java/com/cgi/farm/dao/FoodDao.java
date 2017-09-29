package com.cgi.farm.dao;

import java.util.List;

import com.cgi.farm.model.Farmer;
import com.cgi.farm.model.Food;

public interface FoodDao {

	List<Food> findAll();
	
	Food findByID(int ID);
	public void save(Food aFood);
}
