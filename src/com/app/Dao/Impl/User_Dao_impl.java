package com.app.Dao.Impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.Dao.Interfaces.IUser_Dao;
import com.app.model.Books;
import com.app.model.Category;
import com.app.model.Users;

@Repository
public class User_Dao_impl implements IUser_Dao{

	@Autowired
	private SessionFactory sf;
	@Override
	public int Insert_User(Users u) {
		
		return (int) sf.getCurrentSession().save(u);
	}
	@Override
	public Users select_User(int uid) {
		Users u=(Users) sf.getCurrentSession().createQuery("from "+Users.class.getName()+" where uid=:uid").setParameter("uid", uid).uniqueResult();
		return u;
	}
	@Override
	public List<Users> select_Users_list() {
		List<Users> l=(List<Users>) sf.getCurrentSession().createQuery("from "+Users.class.getName()).list();
		return l;
	}
	@Override
	public int Update_User(Users u) {
		Query q=sf.getCurrentSession().createQuery("update " + Users.class.getName() + " set role= :role,approved=:appr where uid=:uid");
		q.setParameter("role", u.getRole());
		q.setParameter("appr", u.getApproved());
		q.setParameter("uid", u.getUid());
		return q.executeUpdate();
	}
	@Override
	public int Insert_cat(Category c) {
		
		return (int) sf.getCurrentSession().save(c);
	}
	@Override
	public String generate() {
		String prefix="issue/resesrve";
		int x=((BigDecimal)sf.getCurrentSession().createNativeQuery("select diglib_i_r_id.nextval from dual").uniqueResult()).intValue();
		return prefix+x;
	}
	@Override
	public int Insert_Book(Books b) {
		return (int) sf.getCurrentSession().save(b);
	}
	@Override
	public List<Category> select_cat_list() {
		List<Category> l=(List<Category>) sf.getCurrentSession().createQuery("from "+Category.class.getName()).list();
		return l;
	}

}
