package com.cgi.farm.dao;

import java.util.List;

import com.cgi.farm.model.Farm;

/**
 * The Interface IFarmDao.
 */
public interface IFarmDao {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Farm> findAll();
	
	/**
	 * Save.
	 *
	 * @param aFarm the a farm
	 */
	void save(Farm aFarm);
	
	/**
	 * Update.
	 *
	 * @param aFarm the a farm
	 */
	void update(Farm aFarm);
	
	/**
	 * Find by address.
	 *
	 * @param name the name
	 * @return the farm
	 */
	Farm findByAddress(String name);
	
	/**
	 * Find farmer name.
	 *
	 * @param name the name
	 * @return the farm
	 */
	Farm findFarmerName(String name);
}
