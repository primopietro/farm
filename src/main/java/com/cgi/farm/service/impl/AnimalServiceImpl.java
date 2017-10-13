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


/**
 * The Class AnimalServiceImpl.
 */
@Service("AnimalService")
@Transactional
public class AnimalServiceImpl implements IAnimalService , InitializingBean {

	/** The dao. */
	@Autowired
	IAnimalDao dao;
	
	/* (non-Javadoc)
	 * @see com.cgi.farm.service.IAnimalService#findByID(int)
	 */
	@Override
	public Animal findByID(int ID) {
		return dao.findByID(ID);
	}

	/* (non-Javadoc)
	 * @see com.cgi.farm.service.IAnimalService#findAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Animal> findAll() {
		return dao.findAll();
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	@Transactional(readOnly = true)
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(dao, "dao can t be null");
		
	}
	
	/* (non-Javadoc)
	 * @see com.cgi.farm.service.IAnimalService#updateAnimal(com.cgi.farm.model.Animal)
	 */
	public void updateAnimal(Animal anAnimal){
		dao.update(anAnimal);
	}
	
	/* (non-Javadoc)
	 * @see com.cgi.farm.service.IAnimalService#addFood(com.cgi.farm.model.Animal, com.cgi.farm.model.Food)
	 */
	public void addFood(Animal anAnimal,Food aFood){
		Set<Food> aimalFoods = anAnimal.getFoodList();
		if(aimalFoods == null){
			aimalFoods = new HashSet<Food>();
		}
		aimalFoods.add(aFood);
		anAnimal.setFoodList(aimalFoods);
	}
}
