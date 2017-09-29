package com.cgi.farm.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name = "animal")
public class Animal {
	@Id //@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_animal", nullable = false)
	private int id_animal;
	
	//@NotEmpty
	@Column(name="foodEated", nullable=false)
	private int foodEated;
	
	
    @JoinColumn(name="farm_address", nullable = false, updatable = false, insertable = true)
	@ManyToOne(cascade=CascadeType.ALL) 
	private Farm farm;

	@JoinColumn(name = "type")
	@ManyToOne(targetEntity = AnimalType.class, fetch = FetchType.EAGER)
	private AnimalType type;
	
	@OneToMany(mappedBy = "id_food", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Food> foodList;
	
	public void addFood(Food aFood){
		if(foodList == null){
			foodList = new HashSet<Food>();
		}
		foodList.add(aFood);
	}
	
	
	public Farm getFarm(){
		return farm;
	}
	
	public void setFarm(Farm aFarm){
		this.farm = aFarm;
	}
	
	
	/**
	 * @return the id_animal
	 */
	public int getId_animal() {
		return id_animal;
	}

	/**
	 * @param id_animal the id_animal to set
	 */
	public void setId_animal(int id_animal) {
		this.id_animal = id_animal;
	}

	/**
	 * @return the foodEated
	 */
	public int getfoodEated() {
		return foodEated;
	}

	/**
	 * @return the type
	 */
	public AnimalType getType() {
		return type;
	}

	/**
	 * @return the foodList
	 */
	public Set<Food> getFoodList() {
		return foodList;
	}

	/**
	 * @param foodEated
	 *            the foodEated to set
	 */
	public void setfoodEated(int foodEated) {
		this.foodEated = foodEated;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(AnimalType type) {
		this.type = type;
	}

	/**
	 * @param foodList
	 *            the foodList to set
	 */
	public void setFoodList(Set<Food> foodList) {
		this.foodList = foodList;
	}
}
