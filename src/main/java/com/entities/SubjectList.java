package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SubjectList")
public class SubjectList {
	 //variables//
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Subid")
	private int Subid;
	
	@Column(name="Subname")
	private String Subname;
	
	@ManyToOne
	ClassList ClassList;

	@ManyToOne
	TeacherList TeacherList ;
	
	public SubjectList(String subname) {
		super();
		Subname = subname;
	}
	
	public SubjectList() {
		super();
	}

	public SubjectList(int subid, String subname) {
		super();
		Subid = subid;
		Subname = subname;
	}

	//getters and setters //
	public int getSubid() {
		return Subid;
	}

	public void setSubid(int subid) {
		Subid = subid;
	}

	public String getSubname() {
		return Subname;
	}

	public void setSubname(String subname) {
		Subname = subname;
	}

	public ClassList getListClasses() {
		return ClassList;
	}

	public void setListClasses(ClassList listClasses) {
		ClassList = listClasses;
	}

	public TeacherList getListTeachers() {
		return TeacherList;
	}

	public void setListTeachers(TeacherList listTeachers) {
		TeacherList = listTeachers;
	}
}
