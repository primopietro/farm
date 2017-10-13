package com.cgi.farm.dao;

import java.util.List;

import com.cgi.farm.model.Farmer;

/**
 * The Interface IFarmerDao.
 */
public interface IFarmerDao {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Farmer> findAll();
	
	/**
	 * Save.
	 *
	 * @param aFarmer the a farmer
	 */
	public void save(Farmer aFarmer);
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the farmer
	 */
	Farmer findByName(String name);
}
