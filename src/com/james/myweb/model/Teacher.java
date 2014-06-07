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
 * Teacher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "teacher", catalog = "jamesdb")
public class Teacher implements java.io.Serializable {

	// Fields

	private Integer id;
	private String fname;
	private String lname;
	private Date dob;
	private String gender;
	private Integer teachYears;
	private String description;
	private Set<TeacherCourseRegistration> teacherCourseRegistrations = new HashSet<TeacherCourseRegistration>(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** full constructor */
	public Teacher(String fname, String lname, Date dob, String gender, Integer teachYears, String description,
			Set<TeacherCourseRegistration> teacherCourseRegistrations) {
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.gender = gender;
		this.teachYears = teachYears;
		this.description = description;
		this.teacherCourseRegistrations = teacherCourseRegistrations;
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

	@Column(name = "teachYears")
	public Integer getTeachYears() {
		return this.teachYears;
	}

	public void setTeachYears(Integer teachYears) {
		this.teachYears = teachYears;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teacher")
	public Set<TeacherCourseRegistration> getTeacherCourseRegistrations() {
		return this.teacherCourseRegistrations;
	}

	public void setTeacherCourseRegistrations(Set<TeacherCourseRegistration> teacherCourseRegistrations) {
		this.teacherCourseRegistrations = teacherCourseRegistrations;
	}

}