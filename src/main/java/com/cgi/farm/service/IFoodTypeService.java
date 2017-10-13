package com.cgi.farm.service;

import java.util.List;

import com.cgi.farm.model.FoodType;


/**
 * The Interface IFoodTypeService.
 */
public interface IFoodTypeService {
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the food type
	 */
	FoodType findByName(String name);
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<FoodType> findAll();
}
