package com.blucursor.UserInformation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userinfo")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserID")
	public Integer UserID;

	@Column(name = "fullname")
	public String fullname;

	@Column(name = "Email")
	public String email;

	@Column(name = "Password")
	public String password;
	//	public User(String fullName,String email,String password) {
	//		this.fullName = fullName;
	//		this.email=email;
	//		this.password=password;
	//	}

	String getFullname() {
		return fullname;
	}

	String getemail() {
		return email;
	}

	String getpassword() {
		return password;
	}

	void setFullName(String fullname) {
		this.fullname = fullname;
	}

	void setemail(String email) {
		this.email = email;
	}

	void setpassword(String password) {
		this.password = password;
	}

}
