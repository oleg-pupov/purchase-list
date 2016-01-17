package com.pupov.oleg.purchase.service;

import java.util.List;

import com.pupov.oleg.purchase.model.User;

public interface UserService {
	
	User getUserByName(String name);

	List<User> getAllUsers();
}