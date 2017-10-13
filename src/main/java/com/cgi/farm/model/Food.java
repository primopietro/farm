package com.cgi.farm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The Class Food.
 */
@Entity
@Table(name = "food")
public class Food {
	
	/** The id food. */
	@Id
	@Column(name = "id_food", nullable = false)
	private int id_food;

	/** The quantity. */
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	/** The an animal. */
	@JoinColumn(name = "id_animal")
	@ManyToOne(targetEntity = Animal.class, fetch = FetchType.EAGER)
	private Animal anAnimal;
	
	
	/** The food type. */
	@JoinColumn(name = "food_type_name")
	@ManyToOne(targetEntity = FoodType.class, fetch = FetchType.EAGER)
	private FoodType foodType;
	
	
	/**
	 * Gets the an animal.
	 *
	 * @return the anAnimal
	 */
	public Animal getAnAnimal() {
		return anAnimal;
	}

	/**
	 * Sets the an animal.
	 *
	 * @param anAnimal the anAnimal to set
	 */
	public void setAnAnimal(Animal anAnimal) {
		this.anAnimal = anAnimal;
	}

	
	/**
	 * Gets the id food.
	 *
	 * @return the id_food
	 */
	public int getId_food() {
		return id_food;
	}

	/**
	 * Sets the id food.
	 *
	 * @param id_food            the id_food to set
	 */
	public void setId_food(int id_food) {
		this.id_food = id_food;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Gets the food type.
	 *
	 * @return the foodType
	 */
	public FoodType getFoodType() {
		return foodType;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Sets the food type.
	 *
	 * @param foodType            the foodType to set
	 */
	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}
}
