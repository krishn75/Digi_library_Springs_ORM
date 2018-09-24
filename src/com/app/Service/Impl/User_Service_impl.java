package com.app.Service.Impl;

import java.util.List;

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
		return i.Insert_User(u);
	}
	@Override
	@Transactional(readOnly=true)
	public Users select_User(int uid) {
		
		return i.select_User(uid);
	}
	@Override
	@Transactional(readOnly=true)
	public List<Users> select_Users_list() {
		
		return i.select_Users_list();
	}
	@Override
	@Transactional
	public int Update_User(Users u) {
		return i.Update_User(u);
	}

}
