package com.pupov.oleg.purchase.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pupov.oleg.purchase.model.User;

public interface UserDao extends JpaRepository<User, Long> {

	User findByName(String name);

}
