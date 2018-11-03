package com.app.Dao.Impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.app.Dao.Interfaces.IUser_Dao;
import com.app.model.Books;
import com.app.model.Category;
import com.app.model.Issued_books;
import com.app.model.Users;

@Repository
public class User_Dao_impl implements IUser_Dao {

	@Autowired
	private SessionFactory sf;
	@Autowired
	private BCryptPasswordEncoder be;

	@Override
	public int Insert_User(Users u) {
		u.setPassword(be.encode(u.getPassword()));
		return (int) sf.getCurrentSession().save(u);
	}

	@Override
	public Users select_User(String un) {
		Users u = (Users) sf.getCurrentSession().createQuery("from " + Users.class.getName() + " where username=:un")
				.setParameter("un", un).uniqueResult();
		return u;
	}

	@Override
	public List<Users> select_Users_list() {
		List<Users> l = (List<Users>) sf.getCurrentSession().createQuery("from " + Users.class.getName()).list();
		return l;
	}

	@Override
	public int Update_User(Users u) {
		Query q = sf.getCurrentSession()
				.createQuery("update " + Users.class.getName() + " set role= :role,approved=:appr where uid=:uid");
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
		String prefix = "issue/resesrve";
		int x = ((BigDecimal) sf.getCurrentSession().createNativeQuery("select nextval ('diglib_i_r_id')")
				.uniqueResult()).intValue();
		return prefix + x;
	}

	@Override
	public int Insert_Book(Books b) {
		return (int) sf.getCurrentSession().save(b);
	}

	@Override
	public List<Category> select_cat_list() {
		List<Category> l = (List<Category>) sf.getCurrentSession().createQuery("from " + Category.class.getName())
				.list();
		return l;
	}

	@Override
	public List<Books> select_Books_list() {
		List<Books> l = (List<Books>) sf.getCurrentSession().createQuery("from " + Books.class.getName()).list();
		return l;
	}

	@Override
	public String Issue_Book(Issued_books i, int qty) {
		String id = "fff";
		List<Issued_books> l = sf.getCurrentSession()
				.createQuery(
						"from " + Issued_books.class.getName() + "  where book_id=:bid and status=:s and iusername=:un")
				.setParameter("s", "NOT RETURNED").setParameter("bid", i.getBook_id())
				.setParameter("un", i.getIusername()).list();

		if (l.isEmpty()) {
			Query q1 = sf.getCurrentSession()
					.createQuery("update " + Books.class.getName() + " set quantity= :qty where book_id=:bid");
			q1.setParameter("qty", qty - 1);
			q1.setParameter("bid", i.getBook_id());
			id = (String) sf.getCurrentSession().save(i);
			if (!id.equals("fff")) {
				q1.executeUpdate();
			}
			return "Successfully issued book with id= " + id;
		} else {
			return "same book is already issued to the user please return the book before issuing another of same kind";
		}
	}

	@Override
	public List<Books> Return_books(String un) {
		List<Integer> l = sf.getCurrentSession()
				.createQuery(
						"select book_id from " + Issued_books.class.getName() + "  where status=:s and iusername=:un")
				.setParameter("s", "NOT RETURNED").setParameter("un", un).list();
		List<Books> lb = new ArrayList<>();
		if (!l.isEmpty()) {
			for (Integer i : l) {

				Books b = (Books) sf.getCurrentSession()
						.createQuery("from " + Books.class.getName() + " where book_id=:id").setParameter("id", i)
						.uniqueResult();
				lb.add(b);
			}
		}

		return lb;
	}

	@Override
	public String return_Book_reg(int id, int qty, String un) {
		int x = sf.getCurrentSession()
				.createQuery(
						"update " + Issued_books.class.getName() + " set status=:s where book_id=:id and iusername=:un")
				.setParameter("s", "RETURNED").setParameter("id", id).setParameter("un", un).executeUpdate();
		if (x > 0) {
			int res = sf.getCurrentSession()
					.createQuery("update " + Books.class.getName() + " set quantity=:q  where book_id=:id ")
					.setParameter("id", id).setParameter("q", (qty + 1)).executeUpdate();
			if (res > 0) {
				return "Successfully returned book of id= " + id;
			}
		}
		return "failed to return book of id= " + id + " try after sometime";

	}

}
