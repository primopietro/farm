package com.cgi.farm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


/**
 * The Class Farmer.
 */
@Entity
@Table(name = "farmer")
public class Farmer {
	
	/** The name. */
	@Id
	@Column(name = "name", nullable = false)
	private String name;
	
	/** The age. */
	@Min(1)
	@Max(110)
	@Column(name = "age", nullable = false)
	private Integer age;

	
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
	 * Gets the age.
	 *
	 * @return the age
	 */
	public Integer getAge() {
		return age;
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
	 * Sets the age.
	 *
	 * @param age            the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
}
