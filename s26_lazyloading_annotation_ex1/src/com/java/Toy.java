package com.java;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TOYS")
public class Toy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TOY_ID")
	/** 
	 * The primary key of the TOYS table 
	 */
	private Long toyId;
	@Column(name = "TOY_NAME")
	/** 
	 * The name of the toy 
	 */
	private String toyName;

	public Long getToyId() {
		return toyId;
	}

	public void setToyId(Long toyId) {
		this.toyId = toyId;
	}

	public String getToyName() {
		return toyName;
	}

	public void setToyName(String toyName) {
		this.toyName = toyName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((toyName == null) ? 0 : toyName.hashCode());
		return result;
	}

	@Override
	/** 
	 * Overriden because within the child class we use a Set to 
	 * hold all unique toys 
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Toy other = (Toy) obj;
		if (toyName == null) {
			if (other.toyName != null)
				return false;
		} else if (!toyName.equals(other.toyName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Toy [toyId=" + toyId + ", toyName=" + toyName + "]";
	}
}
