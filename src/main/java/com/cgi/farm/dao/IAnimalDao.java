package com.cgi.farm.dao;

import java.util.List;

import com.cgi.farm.model.Animal;

public interface IAnimalDao {

	List<Animal> findAll();
	public void save(Animal anAnimal);
	Animal findByID(int ID);
	void update(Animal anAnimal);
}
