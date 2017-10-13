package com.cgi.farm.dao;

import java.util.List;

import com.cgi.farm.model.Food;

/**
 * The Interface IFoodDao.
 */
public interface IFoodDao {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Food> findAll();
	
	/**
	 * Find by ID.
	 *
	 * @param ID the id
	 * @return the food
	 */
	Food findByID(int ID);
	
	/**
	 * Save.
	 *
	 * @param aFood the a food
	 */
	public void save(Food aFood);

	/**
	 * Update.
	 *
	 * @param aFood the a food
	 */
	void update(Food aFood);
}
