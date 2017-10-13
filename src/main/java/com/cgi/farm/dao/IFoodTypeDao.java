package com.cgi.farm.dao;

import java.util.List;

import com.cgi.farm.model.FoodType;


/**
 * The Interface IFoodTypeDao.
 */
public interface IFoodTypeDao {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<FoodType> findAll();
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the food type
	 */
	FoodType findByName(String name);
}
