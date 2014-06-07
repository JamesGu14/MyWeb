package com.james.myweb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.*;

import com.james.myweb.model.Student;
import com.james.myweb.model.StudentDAO;

@Controller
public class StudentController {
	
	@RequestMapping("/student/display")
	public ModelAndView student() {
		ModelAndView modelAndView = new ModelAndView("/Student/display");
		StudentDAO studentDAO = new StudentDAO();
		List<Student> studentList = studentDAO.findAll();
		modelAndView.addObject("stuList", studentList);
		return modelAndView;
	}
}
