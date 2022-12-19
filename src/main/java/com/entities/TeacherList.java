package com.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="TeacherList")
public class TeacherList {
		//variables//
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="Tid")
		private int Tid;
		
		@Column(name="tname")
		private String tname;
		
		@ManyToOne
		@JoinColumn(name="classid")
		ClassList ClassList;
		
		//teacher to subject mapping//
		@OneToMany(cascade= CascadeType.ALL,mappedBy="TeacherList")
		@LazyCollection(LazyCollectionOption.FALSE)
		List<SubjectList> SubjectList;
		
		//constructors//
		public TeacherList() {
			super();
		}
		
		public TeacherList(String tname) {
			super();
			this.tname = tname;
		}

		public TeacherList(int tid, String tname) {
			super();
			Tid = tid;
			this.tname = tname;
		}
		
	    //getters and setters//
		public int getTid() {
			return Tid;
		}

		public void setTid(int tid) {
			Tid = tid;
		}

		public String getTname() {
			return tname;
		}

		public void setTname(String tname) {
			this.tname = tname;
		}

		public ClassList getListClasses() {
			return ClassList;
		}

		public void setListClasses(ClassList listClasses) {
			ClassList = listClasses;
		}

		public List<SubjectList> getListSubjects() {
			return SubjectList;
		}

		public void setListSubjects(List<SubjectList> listSubjects) {
			SubjectList = listSubjects;
		}
}
