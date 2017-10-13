package com.cgi.farm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.cgi.farm.dao.IAbstractDao;
import com.cgi.farm.dao.IAnimalDao;
import com.cgi.farm.model.Animal;


/**
 * The Class AnimalDaoImpl.
 */
@Repository("animalDao")
public class AnimalDaoImpl extends IAbstractDao<Integer, Animal>implements IAnimalDao{

	/* (non-Javadoc)
	 * @see com.cgi.farm.dao.IAnimalDao#findByID(int)
	 */
	public Animal findByID(int ID) {
		return getByKey(ID);
	}

	
	/* (non-Javadoc)
	 * @see com.cgi.farm.dao.IAnimalDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List<Animal> findAll(){
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("id_animal"));
		return (List<Animal>)crit.list();
	}
	
	
	/* (non-Javadoc)
	 * @see com.cgi.farm.dao.IAnimalDao#save(com.cgi.farm.model.Animal)
	 */
	public void save(Animal anAnimal){
		persist(anAnimal);
	}
}
