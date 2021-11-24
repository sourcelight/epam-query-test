package org.query.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t2")
public class T2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9077579724768329523L;

	public T2() {
		super();
	}

	public T2(Long id, Double b, Double y) {
		super();
		this.id = id;
		this.b = b;
		this.y = y;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Double b;

	@Column
	private Double y;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getB() {
		return b;
	}

	public void setB(Double b) {
		this.b = b;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

}
