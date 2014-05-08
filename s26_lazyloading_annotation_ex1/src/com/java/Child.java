package com.java;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CHILD")
@NamedQuery(name = "findChildByName", query = "select DISTINCT(chd) from Child chd left join fetch chd.toyList where chd.childName=:chdName")
public class Child {
	public static interface Constants {
		public static final String FIND_CHILD_BY_NAME_QUERY = "findChildByName";

		public static final String CHILD_NAME_PARAM = "chdName";

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "childId")
	private Long childId;

	@Column(name = "CHILD_NAME")
	/** 
	 * The name of the child 
	 */
	private String childName;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	/** 
	 * The toys the child has. We do not want the child to have the same toy more than 
	 * once, so we have used a set here. 
	 */
	private Set<Toy> toyList = new HashSet<Toy>();

	public Long getChildId() {
		return childId;
	}

	public void setChildId(Long childId) {
		this.childId = childId;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public Set<Toy> getToyList() {
		return toyList;
	}

	public void addToy(Toy toy) {
		toyList.add(toy);
	}
}
