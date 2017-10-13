package com.cgi.farm.service;

import java.util.List;

import com.cgi.farm.model.Animal;
import com.cgi.farm.model.Farm;


/**
 * The Interface IFarmService.
 */
public interface IFarmService {
	
	/**
	 * Find by address.
	 *
	 * @param name the name
	 * @return the farm
	 */
	Farm findByAddress(String name);
	
	/**
	 * Find by farmer name.
	 *
	 * @param name the name
	 * @return the farm
	 */
	Farm findByFarmerName(String name);
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Farm> findAll();
	
	/**
	 * Save farm.
	 *
	 * @param aFarm the a farm
	 */
	void saveFarm(Farm aFarm);
	
	/**
	 * Adds the animal.
	 *
	 * @param aFarm the a farm
	 * @param anAnimal the an animal
	 */
	public void addAnimal(Farm aFarm, Animal anAnimal);
	
	/**
	 * Update farm.
	 *
	 * @param farmToBeEdited the farm to be edited
	 */
	void updateFarm(Farm farmToBeEdited);
}
