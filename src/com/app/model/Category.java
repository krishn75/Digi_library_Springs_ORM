package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;

@Entity
@Table(name = "category")
public class Category {

	@GeneratedValue(generator = "userid", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "userid", sequenceName = "diglib_cat_id", allocationSize = 1)

	@Id
	@Column(name = "C_id", length = 5)
	private int id;
	@Column(name = "C_name", length = 10,unique=true)
	private String C_name;

	public Category() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getC_name() {
		return C_name;
	}

	public void setC_name(String c_name) {
		C_name = c_name;
	}

	
}
