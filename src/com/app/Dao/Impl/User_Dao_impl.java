package com.app.Dao.Impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.Dao.Interfaces.IUser_Dao;
import com.app.model.Users;

@Repository
public class User_Dao_impl implements IUser_Dao{

	@Autowired
	private SessionFactory sf;
	@Override
	public int Insert_User(Users u) {
		
		return (int) sf.getCurrentSession().save(u);
	}

}
