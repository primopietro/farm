package com.cgi.farm.dao;

import java.util.List;

import com.cgi.farm.model.Animal;

public interface AnimalDao {

	List<Animal> findAll();
	public void save(Animal anAnimal);
	Animal findByID(int ID);
}
