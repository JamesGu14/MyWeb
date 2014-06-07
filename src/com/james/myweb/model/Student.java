package com.james.myweb.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "student", catalog = "jamesdb")
public class Student implements java.io.Serializable {

	// Fields

	private Integer id;
	private String fname;
	private String lname;
	private Date dob;
	private String gender;
	private String note;
	private Set<StudentCourseRegistration> studentCourseRegistrations = new HashSet<StudentCourseRegistration>(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(String fname, String lname, Date dob, String gender, String note,
			Set<StudentCourseRegistration> studentCourseRegistrations) {
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.gender = gender;
		this.note = note;
		this.studentCourseRegistrations = studentCourseRegistrations;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "fname", length = 100)
	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@Column(name = "lname", length = 100)
	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dob", length = 0)
	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name = "gender", length = 1)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "note", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "student")
	public Set<StudentCourseRegistration> getStudentCourseRegistrations() {
		return this.studentCourseRegistrations;
	}

	public void setStudentCourseRegistrations(Set<StudentCourseRegistration> studentCourseRegistrations) {
		this.studentCourseRegistrations = studentCourseRegistrations;
	}

}