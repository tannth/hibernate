package com.java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "Student")
public class Student implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "STUDENT_ID")
	private Long id;
	@Column(name = "STUDENT_name")
	private String name;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Fetch(org.hibernate.annotations.FetchMode.SELECT)
	@JoinTable(name = "STUDENT_Course", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = { @JoinColumn(name = "C_ID") })
	private List<Course> c;

	public Long getId() {
		return id;
	}

	public Student() {
		c = new ArrayList<Course>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getC() {
		return c;
	}

	public void setC(List<Course> c) {
		this.c = c;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
