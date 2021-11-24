package org.query.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t3")
public class T3 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9077579724768329523L;

	public T3() {
		super();
	}

	public T3(Long id, Double c, Double z) {
		super();
		this.id = id;
		this.c = c;
		this.z = z;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Double c;

	@Column
	private Double z;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getC() {
		return c;
	}

	public void setC(Double c) {
		this.c = c;
	}

	public Double getZ() {
		return z;
	}

	public void setZ(Double z) {
		this.z = z;
	}

	
}
