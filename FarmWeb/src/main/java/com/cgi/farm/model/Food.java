package com.cgi.farm.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "food")
public class Food {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_food", nullable = false)
	private int id_food;

	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	@JoinColumn(name = "id_animal")
	@ManyToOne(targetEntity = Animal.class, fetch = FetchType.EAGER)
	private Animal anAnimal;
	
	/**
	 * @return the anAnimal
	 */
	public Animal getAnAnimal() {
		return anAnimal;
	}

	/**
	 * @param anAnimal the anAnimal to set
	 */
	public void setAnAnimal(Animal anAnimal) {
		this.anAnimal = anAnimal;
	}

	@JoinColumn(name = "food_type_name")
	@ManyToOne(targetEntity = FoodType.class, fetch = FetchType.EAGER)
	private FoodType foodType;
	
	/**
	 * @return the id_food
	 */
	public int getId_food() {
		return id_food;
	}

	/**
	 * @param id_food
	 *            the id_food to set
	 */
	public void setId_food(int id_food) {
		this.id_food = id_food;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @return the foodType
	 */
	public FoodType getFoodType() {
		return foodType;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @param foodType
	 *            the foodType to set
	 */
	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}
}
