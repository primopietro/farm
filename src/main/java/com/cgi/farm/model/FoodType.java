package com.cgi.farm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The Class FoodType.
 */
@Entity
@Table(name = "food_type")
public class FoodType {
	
	/** The name. */
	@Id
	@Column(name = "name", nullable = false)
	private String name;
	
	/** The nutritional value. */
	@Column(name = "nutritionalValue", nullable = false)
	private String nutritionalValue;

	
	
	// GETTER SETTER
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the nutritional value.
	 *
	 * @return the nutritionalValue
	 */
	public String getNutritionalValue() {
		return nutritionalValue;
	}

	/**
	 * Sets the name.
	 *
	 * @param name            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the nutritional value.
	 *
	 * @param nutritionalValue            the nutritionalValue to set
	 */
	public void setNutritionalValue(String nutritionalValue) {
		this.nutritionalValue = nutritionalValue;
	}
}
