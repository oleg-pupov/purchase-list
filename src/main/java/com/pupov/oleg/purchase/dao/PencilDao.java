package com.pupov.oleg.purchase.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pupov.oleg.purchase.model.Pencil;

public interface PencilDao extends JpaRepository <Pencil, Long> {
	Pencil findByColor(String color);
	
}
