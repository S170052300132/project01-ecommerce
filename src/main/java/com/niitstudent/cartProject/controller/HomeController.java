package com.niitstudent.cartProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	 public String homePage()
	 {
		 return "home";
	 }
 
  @RequestMapping("/login")
  public ModelAndView showLoginPage()
  { 
	 ModelAndView mv = new ModelAndView("login");
	 mv.addObject("msg", "you clicked the login link");
	 
	  return mv;
  }

  @RequestMapping("/register")
  public String showRegistrationPage()
  {
	  return "registration";
  }
}
