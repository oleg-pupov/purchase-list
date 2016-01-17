package com.pupov.oleg.purchase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pupov.oleg.purchase.dao.UserDao;
import com.pupov.oleg.purchase.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Override
	@Transactional
	public User getUserByName (String name) {
		User user = userDao.findByName(name);
		// TODO remove this workaround for Lazy initialization		
		if (user != null) {
			user.getUserRoles().size();
		}
		
		return user;
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		List<User> users = userDao.findAll();
	// TODO remove this workaround for Lazy initialization
		for (User user:users) {
			user.getUserRoles().size();
		}
		
		return users;
	}
	

}
