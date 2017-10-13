package com.cgi.farm.model;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The Class Animal.
 */
@Entity
@Table(name = "animal")
public class Animal {
	
	/** The id animal. */
	@Id 
	@Column(name = "id_animal", nullable = false)
	private Integer id_animal;
	
	
	/** The food eated. */
	@Column(name="foodEated", nullable=false)
	private Integer foodEated;
	
	
    /** The farm. */
    @JoinColumn(name="farm_address", nullable = false, updatable = false, insertable = true)
	@ManyToOne(cascade=CascadeType.ALL) 
	private Farm farm;

	/** The type. */
	@JoinColumn(name = "type")
	@ManyToOne(targetEntity = AnimalType.class, fetch = FetchType.EAGER)
	private AnimalType type;
	
	/** The food list. */
	@OneToMany(mappedBy = "id_food", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Food> foodList;
	
	
	// UTILITY
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Animal [id_animal=" + id_animal + ", foodEated=" + foodEated
				+ ", farm=" + farm + ", type=" + type + "]";
	}
	
	
	// GETTER SETTER

	/**
	 * Gets the farm.
	 *
	 * @return the farm
	 */
	public Farm getFarm(){
		return farm;
	}
	
	/**
	 * Sets the farm.
	 *
	 * @param aFarm the Farm to set
	 */
	public void setFarm(Farm aFarm){
		this.farm = aFarm;
	}
	
	/**
	 * Gets the id animal.
	 *
	 * @return the id_animal
	 */
	public Integer getId_animal() {
		return id_animal;
	}

	/**
	 * Sets the id animal.
	 *
	 * @param id_animal the id_animal to set
	 */
	public void setId_animal(Integer id_animal) {
		this.id_animal = id_animal;
	}

	/**
	 * Gets the food eated.
	 *
	 * @return the foodEated
	 */
	public Integer getfoodEated() {
		return foodEated;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public AnimalType getType() {
		return type;
	}

	/**
	 * Gets the food list.
	 *
	 * @return the foodList
	 */
	public Set<Food> getFoodList() {
		return foodList;
	}

	/**
	 * Sets the food eated.
	 *
	 * @param foodEated            the foodEated to set
	 */
	public void setfoodEated(Integer foodEated) {
		this.foodEated = foodEated;
	}

	/**
	 * Sets the type.
	 *
	 * @param type            the type to set
	 */
	public void setType(AnimalType type) {
		this.type = type;
	}

	/**
	 * Sets the food list.
	 *
	 * @param foodList            the foodList to set
	 */
	public void setFoodList(Set<Food> foodList) {
		this.foodList = foodList;
	}
}
