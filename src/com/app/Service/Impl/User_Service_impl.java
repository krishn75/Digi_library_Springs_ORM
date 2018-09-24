package com.app.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Dao.Interfaces.IUser_Dao;
import com.app.Service.Interfaces.IUser_service;
import com.app.model.Books;
import com.app.model.Category;
import com.app.model.Issued_books;
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
	public Users select_User(String un) {
		
		return i.select_User(un);
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
	@Override
	@Transactional
	public int Insert_cat(Category c) {
		return i.Insert_cat(c);
	}
	@Override
	@Transactional(readOnly=true)
	public String generate() {
		return i.generate();
	}
	@Override
	@Transactional
	public int Insert_Book(Books b) {
		return i.Insert_Book(b);
	}
	@Override
	@Transactional(readOnly=true)
	public List<Category> select_cat_list() {
		
		return i.select_cat_list();
	}
	@Override
	@Transactional(readOnly=true)
	public List<Books> select_Books_list() {
		
		return i.select_Books_list();
	}
	@Override
	@Transactional
	public String Issue_Book(Issued_books ib, int qty) {
		return i.Issue_Book(ib, qty);
	}

}
