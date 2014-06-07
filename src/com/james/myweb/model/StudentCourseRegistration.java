package com.james.myweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * StudentCourseRegistration entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "student_course_registration", catalog = "jamesdb")
public class StudentCourseRegistration implements java.io.Serializable {

	// Fields

	private Integer id;
	private Course course;
	private Student student;

	// Constructors

	/** default constructor */
	public StudentCourseRegistration() {
	}

	/** full constructor */
	public StudentCourseRegistration(Course course, Student student) {
		this.course = course;
		this.student = student;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "courseId")
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "studentId")
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}