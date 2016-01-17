package com.pupov.oleg.purchase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PENCILS")
public class Pencil {
	
	@Id
	@Column(name = "PENCIL_ID")
	private Long id;

	@Column(name = "COLOR", nullable = false)
	private String color;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Pencil [id=" + id + ", color=" + color + "]";
	}
}