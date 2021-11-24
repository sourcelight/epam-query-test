package org.query.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t1")
public class T1 extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9077579724768329523L;

	public T1() {
		super();
	}

	

	public T1(Long id, Double a, Double x) {
		super();
		this.id = id;
		this.a = a;
		this.x = x;
	}


	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Double a;

	@Column
	private Double x;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getA() {
		return a;
	}

	public void setA(Double a) {
		this.a = a;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	

}
