package com.cgi.farm.dao;

import java.util.List;

import com.cgi.farm.model.Animal;

/**
 * The Interface IAnimalDao.
 */
public interface IAnimalDao {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Animal> findAll();
	
	/**
	 * Save.
	 *
	 * @param anAnimal the an animal
	 */
	public void save(Animal anAnimal);
	
	/**
	 * Find by ID.
	 *
	 * @param ID the id
	 * @return the animal
	 */
	Animal findByID(int ID);
	
	/**
	 * Update.
	 *
	 * @param anAnimal the an animal
	 */
	void update(Animal anAnimal);
}
