package com.cgi.farm.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.cgi.farm.dao.IAnimalDao;
import com.cgi.farm.model.Animal;
import com.cgi.farm.model.Food;
import com.cgi.farm.service.IAnimalService;

@Service("AnimalService")
@Transactional
public class AnimalServiceImpl implements IAnimalService , InitializingBean {

	@Autowired
	IAnimalDao dao;
	
	@Override
	public Animal findByID(int ID) {
		return dao.findByID(ID);
	}

	@Override
	public List<Animal> findAll() {
		return dao.findAll();
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(dao, "dao can t be null");
		
	}
	public void updateAnimal(Animal anAnimal){
		dao.update(anAnimal);
	}
	public void addFood(Animal anAnimal,Food aFood){
		Set<Food> aimalFoods = anAnimal.getFoodList();
		if(aimalFoods == null){
			aimalFoods = new HashSet<Food>();
		}
		aimalFoods.add(aFood);
		anAnimal.setFoodList(aimalFoods);
	}
}
