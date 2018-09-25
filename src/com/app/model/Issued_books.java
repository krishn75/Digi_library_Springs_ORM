package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="issued_books")
public class Issued_books {
	@Id
	@Column(name="id",table="issued_books",length=20)
	private String iid;
	@Column(name="iusername",table="issued_books",length=15)
	private String iusername;
	@Column(name="book_id",length=5)
	private int book_id;
	@Column(name="Rtn_Status",length=13)
	private String status;
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public String getIusername() {
		return iusername;
	}
	public void setIusername(String iusername) {
		this.iusername = iusername;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Issued_books [iid=" + iid + ", iusername=" + iusername + ", book_id=" + book_id + ", status=" + status
				+ "]";
	}
	
	
	


}
