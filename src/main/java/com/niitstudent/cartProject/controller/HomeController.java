package com.niitstudent.cartProject.controller;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niitstudent.cartProjectBackEnd.dao.CategoryDAO;
import com.niitstudent.cartProjectBackEnd.dao.ProductDAO;
import com.niitstudent.cartProjectBackEnd.dao.SupplierDAO;
import com.niitstudent.cartProjectBackEnd.dao.UserDAO;
import com.niitstudent.cartProjectBackEnd.domainobj.Category;
import com.niitstudent.cartProjectBackEnd.domainobj.Product;
import com.niitstudent.cartProjectBackEnd.domainobj.Supplier;
import com.niitstudent.cartProjectBackEnd.domainobj.User;

@Controller

public class HomeController {
	
	Logger log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	UserDAO userDAO;
	@Autowired
	User user;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;
	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private Supplier supplier;
	@Autowired
	private Product product;
	@Autowired
	private ProductDAO productDAO;




	@RequestMapping("/")
	public ModelAndView onLoad(HttpSession session){
		log.debug("Starting of the method onLoad");

		ModelAndView mv = new ModelAndView("home");
		
		session.setAttribute("category", category);
		session.setAttribute("product", product);
		session.setAttribute("supplier", supplier);
		
		
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("supplierList", supplierDAO.list());

		log.debug("Ending of the method onLoad");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView showLoginPage() {
		log.debug("Starting of the method showLoginPage");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("user", user);
		mv.addObject("showLoginPage", "true");
		log.debug("Ending of the method showLoginPage");
		return mv;
	}

	@RequestMapping("/register")
	public ModelAndView showRegistrationPage() {
		log.debug("Starting of the method showRegistrationPage");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("user", user);
		mv.addObject("showRegistrationPage", "true");
		log.debug("Ending of the method registerHere");
		return mv;

	}
	@RequestMapping("/aboutus")
	public String showAbout()
	{
		return "aboutus";
	}
	@RequestMapping("/contactus")
	public String showContact()
	{
		return "contactus";
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
	
	@RequestMapping("/home")
	public String reDirectToHome(@ModelAttribute("selectedProduct") final Product selectedProduct, final Model model) {
		log.debug("Starting of the method reDirectToHome");
		model.addAttribute("selectedProduct", selectedProduct);
	   /* model.addAttribute("categoryList", this.categoryDAO.list());
	    model.addAttribute("productList", this.productDAO.list());*/
		log.debug("Ending of the method reDirectToHome");
		return "/home";
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

