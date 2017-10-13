package com.cgi.farm.service;

import java.util.List;

import com.cgi.farm.model.Animal;
import com.cgi.farm.model.Food;


/**
 * The Interface IAnimalService.
 */
public interface IAnimalService {
	
	/**
	 * Find by ID.
	 *
	 * @param ID the id
	 * @return the animal
	 */
	Animal findByID(int ID);
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Animal> findAll();
	
	/**
	 * Adds the food.
	 *
	 * @param anAnimal the an animal
	 * @param aFood the a food
	 */
	public void addFood(Animal anAnimal,Food aFood);
	
	/**
	 * Update animal.
	 *
	 * @param anAnimal the an animal
	 */
	void updateAnimal(Animal anAnimal);
}
