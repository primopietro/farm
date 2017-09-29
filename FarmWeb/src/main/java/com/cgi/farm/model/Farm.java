package com.cgi.farm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "farm")
public class Farm {
	@Id
	@Column(name = "address", nullable = false)
	private String address;

	@OneToOne (cascade= CascadeType.ALL )
	@JoinColumn(name = "farmer_name")
	private Farmer farmer;

	@JoinColumn(name = "farm_address")//parent's foreign key
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Animal> animalList;

	public void addAnimal(Animal anAnimal) {
		if (animalList == null) {
			animalList = new ArrayList<>();
		}
		animalList.add(anAnimal);
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the farmer
	 */
	public Farmer getFarmer() {
		return farmer;
	}

	/**
	 * @return the animals
	 */
	public List<Animal> getAnimals() {
		return animalList;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param farmer
	 *            the farmer to set
	 */
	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	/**
	 * @param animals
	 *            the animals to set
	 */
	public void setAnimals(List<Animal> animals) {
		this.animalList = animals;
	}
}
