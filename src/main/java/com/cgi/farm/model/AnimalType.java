package com.cgi.farm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * The Class AnimalType.
 */
@Entity
@Table(name = "animal_type")
public class AnimalType {

/** The name. */
@Id
private String name;


//GETTER SETTER
/**
 * Gets the name.
 *
 * @return the name
 */
public String getName() {
	return name;
}

/**
 * Sets the name.
 *
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}

}
