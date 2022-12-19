package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="StudentList")
public class StudentList {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Sid")
	private int Sid;
	
	@Column(name="Sname")
	private String Sname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private Long phone;
	
	@ManyToOne
	ClassList ClassList;

	//constructors//
	public StudentList() {
		super();
	}
	
	public StudentList(String sname, String email, long phone) {
		super();
		Sname = sname;
		this.email = email;
		this.phone = phone;
	}
    
	//getters and setters//
	public int getSid() {
		return Sid;
	}

	public void setSid(int sid) {
		Sid = sid;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public ClassList getListClasses() {
		return ClassList;
	}

	public void setListClasses(ClassList listClasses) {
		ClassList = listClasses;
	}
}
