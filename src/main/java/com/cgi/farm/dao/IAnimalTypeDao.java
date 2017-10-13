package com.cgi.farm.dao;

import java.util.List;

import com.cgi.farm.model.AnimalType;

/**
 * The Interface IAnimalTypeDao.
 */
public interface IAnimalTypeDao {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<AnimalType> findAll();
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the animal type
	 */
	AnimalType findByName(String name);
}
