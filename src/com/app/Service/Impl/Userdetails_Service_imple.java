package com.app.Service.Impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Dao.Interfaces.IUser_Dao;
import com.app.model.Users;

@Service
public class Userdetails_Service_imple implements UserDetailsService {

	@Autowired
	private IUser_Dao iud;
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String un) throws UsernameNotFoundException {
		Users u=iud.select_User(un);
		Set<GrantedAuthority> sg=new HashSet<>();
		sg.add(new SimpleGrantedAuthority(u.getRole()));
		
		return new User(u.getUsername(), u.getPassword(), sg);
	}

}
