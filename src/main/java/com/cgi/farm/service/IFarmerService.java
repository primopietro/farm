package com.cgi.farm.service;

import java.util.List;

import com.cgi.farm.model.Farmer;


/**
 * The Interface IFarmerService.
 */
public interface IFarmerService {
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the farmer
	 */
	Farmer findByName(String name);
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Farmer> findAll();
}
