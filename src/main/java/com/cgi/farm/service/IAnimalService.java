package com.cgi.farm.service;

import java.util.List;

import com.cgi.farm.model.Animal;
import com.cgi.farm.model.Food;

public interface IAnimalService {
	Animal findByID(int ID);
	List<Animal> findAll();
	public void addFood(Animal anAnimal,Food aFood);
	void updateAnimal(Animal anAnimal);
}
