package com.niitstudent.cartProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niitstudent.cartProjectBackEnd.dao.UserDAO;
import com.niitstudent.cartProjectBackEnd.domainobj.User;

@Controller

public class HomeController {
	@Autowired
	UserDAO userDAO;
	@Autowired
	User user;
	@RequestMapping("/")
	public String homePage() {
		return "home";
	}

	@RequestMapping("/login")
	public ModelAndView showLoginPage() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("msg", "you clicked the login link");
		mv.addObject("showLoginPage", "true");

		return mv;
	}

	@RequestMapping("/register")
	public ModelAndView showRegistrationPage() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("msg", "you clicked the registration link");
		mv.addObject("showRegistrationPage", "true");
		return mv;

	}
	@RequestMapping("/aboutus")
	public String showAbout()
	{
		return "aboutus";
	}
	@RequestMapping("/validate")
	public ModelAndView validate(@RequestParam("id")  String id, @RequestParam("password") String password)
	{
	ModelAndView mv = new ModelAndView("home");
	
	
	if (userDAO.validate(id,password)!=null)
	{
		mv.addObject("successMsg","You have logged in successfully");
	}
	else
	{
		mv.addObject("errorMsg","invalid username or password.Please try again");
	}
	return mv;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

