package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(generator="userid",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="userid",sequenceName="diglib_uid",allocationSize=1)
	@Column(name="user_id",length=5)
	private int uid;
	@Column(name="username",length=10)
	private String username;
	@Column(name="password",length=10)
	private String password;
	@Column(name="email",length=20)
	private String email;
	@Column(name="phone_no",length=10)
	private String phno;
	@Column(name="role",length=10)
	private String role;
	@Column(name="approved",length=5)
	private String approved;
	public Users() {
		super();
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getApproved() {
		return approved;
	}
	public void setApproved(String approved) {
		this.approved = approved;
	}
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phno=" + phno + ", role=" + role + ", approved=" + approved + "]";
	}
	

}
