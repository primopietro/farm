package com.cgi.farm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cgi.farm.model.Animal;


@Repository("animalDao")
public class AnimalDaoImpl extends AbstractDao<Integer, Animal>implements AnimalDao{

	public Animal findByID(int ID) {
		return getByKey(ID);
	}

	
	@SuppressWarnings("unchecked")
	public List<Animal> findAll(){
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("id_animal"));
		return (List<Animal>)crit.list();
	}
	
	
	public void save(Animal anAnimal){
		persist(anAnimal);
	}
}
