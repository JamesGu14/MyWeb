package com.james.myweb.model;

import java.sql.Timestamp;
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

/**
 * Course entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "course", catalog = "jamesdb")
public class Course implements java.io.Serializable {

	// Fields

	private Integer id;
	private String courseName;
	private Timestamp startDate;
	private Timestamp endDate;
	private String description;
	private Set<TeacherCourseRegistration> teacherCourseRegistrations = new HashSet<TeacherCourseRegistration>(0);
	private Set<StudentCourseRegistration> studentCourseRegistrations = new HashSet<StudentCourseRegistration>(0);

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** full constructor */
	public Course(String courseName, Timestamp startDate, Timestamp endDate, String description,
			Set<TeacherCourseRegistration> teacherCourseRegistrations,
			Set<StudentCourseRegistration> studentCourseRegistrations) {
		this.courseName = courseName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.teacherCourseRegistrations = teacherCourseRegistrations;
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

	@Column(name = "courseName", length = 150)
	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Column(name = "startDate", length = 0)
	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	@Column(name = "endDate", length = 0)
	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<TeacherCourseRegistration> getTeacherCourseRegistrations() {
		return this.teacherCourseRegistrations;
	}

	public void setTeacherCourseRegistrations(Set<TeacherCourseRegistration> teacherCourseRegistrations) {
		this.teacherCourseRegistrations = teacherCourseRegistrations;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<StudentCourseRegistration> getStudentCourseRegistrations() {
		return this.studentCourseRegistrations;
	}

	public void setStudentCourseRegistrations(Set<StudentCourseRegistration> studentCourseRegistrations) {
		this.studentCourseRegistrations = studentCourseRegistrations;
	}

}