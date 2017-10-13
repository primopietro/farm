package com.cgi.farm.service;

import java.util.List;

import com.cgi.farm.model.AnimalType;


/**
 * The Interface IAnimalTypeService.
 */
public interface IAnimalTypeService {
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the animal type
	 */
	AnimalType findByName(String name);
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<AnimalType> findAll();
}
