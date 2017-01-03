package com.niitstudent.cartProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niitstudent.cartProjectBackEnd.dao.UserDAO;
import com.niitstudent.cartProjectBackEnd.daoimplement.UserDAOImpl;

@Controller
public class HomeController {

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
	@RequestMapping("/validate")
	public ModelAndView validate(@RequestParam("uname")  String id, @RequestParam("pass") String pwd)
	{
	ModelAndView mv = new ModelAndView("home");
	
	UserDAO userDAO = new UserDAOImpl();
	
	if (userDAO.isValidInfo(id,pwd)== true)
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

