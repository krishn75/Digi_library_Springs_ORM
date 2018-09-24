package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Reserved_books")
public class Reserved_books {
	
	@Id
	@Column(name="id",table="Reserved_books",length=20)
	private String rid;
	@Column(name="userid",table="Reserved_books",length=5)
	private int ruserid;
	@Column(name="book_id",length=5)
	private int book_id;
	public Reserved_books() {
		super();
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public int getRuserid() {
		return ruserid;
	}
	public void setRuserid(int ruserid) {
		this.ruserid = ruserid;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	@Override
	public String toString() {
		return "Reserved_books [rid=" + rid + ", ruserid=" + ruserid + ", book_id=" + book_id + "]";
	}
	

}
