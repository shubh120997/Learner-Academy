package com.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="ClassList")
public class ClassList {
	//variables//
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="cid")	
			private int cid;

		@Column(name="cname")
			private String cname;
		
		//classes to student mapping//
		@OneToMany(cascade= CascadeType.ALL, mappedBy="ClassList")
		@LazyCollection(LazyCollectionOption.FALSE)
		List<StudentList> StudentList;
		
		// Classes to subject mapping //
		@OneToMany(cascade= CascadeType.ALL,mappedBy="ClassList")
		@LazyCollection(LazyCollectionOption.FALSE)
		List<SubjectList> SubjectList;
		
		//classes to teachers mapping//
		@OneToMany(cascade= CascadeType.ALL,mappedBy="ClassList")
		@LazyCollection(LazyCollectionOption.FALSE)
		List<TeacherList> TeacherList;
		 
		//construtors//
		public ClassList() {
			super();
		}
				
		public ClassList(String cname) {
			super();
			
			this.cname = cname;
		}

		public ClassList(int cid, String cname) {
			super();
			this.cid = cid;
			this.cname = cname;
		}
		
		//getters and setters//
		public int getCid() {
			return cid;
		}

		public void setCid(int cid) {
			this.cid = cid;
		}

		public String getCname() {
			return cname;
		}

		public void setCname(String cname) {
			this.cname = cname;
		}

		//student setters and getters//
		public List<StudentList> getListStudents() {
			return StudentList;
		}

		public void SetListStudents(List<StudentList> stu) {
			StudentList = stu;
		}

		//subject getters and setters//
		public List<SubjectList> getListSubjects() {
			return SubjectList;
		}

		public void setListSubjects(List<SubjectList> listSubjects) {
			SubjectList = listSubjects;
		}

		//teacher getters and setters//
		public List<TeacherList> getListTeachers() {
			return TeacherList;
		}

		public void setListTeachers(List<TeacherList> listTeachers) {
			TeacherList = listTeachers;
		}

		@Override
		public String toString() {
			return "List of Classes [cid=" + cid + ", cname=" + cname + ", List of Students=" + StudentList + ", ListSubjects="
					+ SubjectList + ", List of Teachers=" + TeacherList + "]";
		}
}
