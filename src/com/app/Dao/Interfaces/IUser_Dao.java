package com.app.Dao.Interfaces;

import java.util.List;

import com.app.model.Users;

public interface IUser_Dao {
	public int Insert_User(Users u);
	public Users select_User(int uid);
	public List<Users> select_Users_list();
	public int Update_User(Users u);
	

}
