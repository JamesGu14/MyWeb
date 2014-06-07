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
 * TeacherCourseRegistration entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "teacher_course_registration", catalog = "jamesdb")
public class TeacherCourseRegistration implements java.io.Serializable {

	// Fields

	private Integer id;
	private Teacher teacher;
	private Course course;

	// Constructors

	/** default constructor */
	public TeacherCourseRegistration() {
	}

	/** full constructor */
	public TeacherCourseRegistration(Teacher teacher, Course course) {
		this.teacher = teacher;
		this.course = course;
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
	@JoinColumn(name = "teacherId")
	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "courseId")
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}