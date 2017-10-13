package com.cgi.farm.service;

import java.util.List;

import com.cgi.farm.model.Food;


/**
 * The Interface IFoodService.
 */
public interface IFoodService {
	
	/**
	 * Find by ID.
	 *
	 * @param ID the id
	 * @return the food
	 */
	Food findByID(int ID);
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Food> findAll();
	
	/**
	 * Update food.
	 *
	 * @param aFood the a food
	 */
	void updateFood(Food aFood);
}
