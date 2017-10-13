package com.cgi.farm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Class Farm.
 */
@Entity
@Table(name = "farm")
public class Farm {
	
	/** The address. */
	@Id
	@Column(name = "address", nullable = false)
	private String address;

	/** The farmer. */
	@OneToOne (cascade= CascadeType.ALL )
	@JoinColumn(name = "farmer_name")
	private Farmer farmer;


	/** The animal list. */
	@JoinColumn(name = "farm_address")//parent's foreign key
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Animal> animalList;

	
	// GETTER SETTER

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Gets the farmer.
	 *
	 * @return the farmer
	 */
	public Farmer getFarmer() {
		return farmer;
	}

	/**
	 * Gets the animals.
	 *
	 * @return the animals
	 */
	public List<Animal> getAnimals() {
		return animalList;
	}

	/**
	 * Sets the address.
	 *
	 * @param address            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Sets the farmer.
	 *
	 * @param farmer            the farmer to set
	 */
	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	/**
	 * Sets the animals.
	 *
	 * @param animals            the animals to set
	 */
	public void setAnimals(List<Animal> animals) {
		this.animalList = animals;
	}
}
