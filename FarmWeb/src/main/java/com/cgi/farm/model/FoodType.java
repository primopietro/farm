package com.cgi.farm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "food_type")
public class FoodType {
	@Id
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "nutritionalValue", nullable = false)
	private String nutritionalValue;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the nutritionalValue
	 */
	public String getNutritionalValue() {
		return nutritionalValue;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param nutritionalValue
	 *            the nutritionalValue to set
	 */
	public void setNutritionalValue(String nutritionalValue) {
		this.nutritionalValue = nutritionalValue;
	}
}
