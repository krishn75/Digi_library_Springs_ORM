package com.app.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Dao.Interfaces.IUser_Dao;
import com.app.Service.Interfaces.IUser_service;
import com.app.model.Users;


@Service
public class User_Service_impl implements IUser_service {

	@Autowired
	private IUser_Dao i;
	@Override
	@Transactional
	public int Insert_User(Users u) {
		// TODO Auto-generated method stub
		return i.Insert_User(u);
	}

}
