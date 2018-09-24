package com.app.Service.Interfaces;

import java.util.List;

import com.app.model.Books;
import com.app.model.Category;
import com.app.model.Users;

public interface IUser_service {
	public int Insert_User(Users u);
	public Users select_User(int uid);
	public List<Users> select_Users_list();
	public int Update_User(Users u);
	public int Insert_cat(Category c);
	public String generate();
	public int Insert_Book(Books b);
	public List<Category> select_cat_list();
	

}
