package com.pupov.oleg.purchase.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.pupov.oleg.purchase.dao.UserDao;
import com.pupov.oleg.purchase.model.User;
import com.pupov.oleg.purchase.model.UserRole;

@Service
public class UserDetailService implements UserDetailsService {
	
	@Autowired
	UserDao userDao;

	@Override
	@Transactional()
	public UserDetails loadUserByUsername(final String name) throws UsernameNotFoundException {
		UserDetails userDetails = null;
		
		User user = userDao.findByName(name);
		if (user == null)
		{
			throw new UsernameNotFoundException("User not found: " + name);
		}
		userDetails = assembleUserDetails(user);			
		
		return userDetails;
	}
	
	private UserDetails assembleUserDetails(User user) {
		return new org.springframework.security.core.userdetails.User(
				user.getName(),
				user.getPassword(),
				user.isEnabled(),
				true,
				true,
				true,
				getAuthorities(user));
	}
	
	private Set<GrantedAuthority> getAuthorities (User user){
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		
		for(UserRole userRole:user.getUserRoles()) {
			authorities.add(new SimpleGrantedAuthority(userRole.getRole()));
		}		
		return authorities;		
	}

}
