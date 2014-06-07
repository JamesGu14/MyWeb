package com.james.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;
import com.james.myweb.model.*;

@Controller
public class IndexController {

	@RequestMapping("/")
	public ModelAndView index() {
		StudentDAO studentDAO = new StudentDAO();
		List<Student> studentList = studentDAO.findAll();
		ModelAndView resView = new ModelAndView();
		resView.setViewName("index");
		resView.addObject("stuList", studentList);
		return resView;
	}
}
