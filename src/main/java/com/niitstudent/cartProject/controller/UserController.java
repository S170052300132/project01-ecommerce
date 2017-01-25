package com.niitstudent.cartProject.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.niitstudent.cartProjectBackEnd.dao.CartDAO;
import com.niitstudent.cartProjectBackEnd.dao.CategoryDAO;
import com.niitstudent.cartProjectBackEnd.dao.SupplierDAO;
import com.niitstudent.cartProjectBackEnd.dao.UserDAO;
import com.niitstudent.cartProjectBackEnd.domainobj.Cart;
import com.niitstudent.cartProjectBackEnd.domainobj.Category;
import com.niitstudent.cartProjectBackEnd.domainobj.Supplier;
import com.niitstudent.cartProjectBackEnd.domainobj.User;

@Controller

public class UserController {

	public static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserDAO userDAO;

	@Autowired
	User user;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;
	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private Cart cart;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;

	
	@Autowired
	private HttpSession session;

	
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public ModelAndView validate(@RequestParam(value = "username") String userID,
			@RequestParam(value = "password") String password) {
		log.debug("Starting of the method validate");

		ModelAndView mv = new ModelAndView("/home");
		user = userDAO.validate(userID, userID);
		if (user != null) {
			log.debug("Valid Credentials");
			
			session.setAttribute("loggedInUser", user.getName());
			session.setAttribute("loggedInUserID", user.getId());

			session.setAttribute("user", user); //

			if (user.getRole().equals("ROLE_ADMIN")) {
				log.debug("Logged in as Admin");
				mv.addObject("isAdmin", "true");
				session.setAttribute("supplier", supplier);
				session.setAttribute("supplierList", supplierDAO.list());

				session.setAttribute("category", category);
				session.setAttribute("categoryList", categoryDAO.list());

			} else {
				log.debug("Logged in as User");
				mv.addObject("isAdmin", "false");
				//myCart = cartDAO.list(userID);
				mv.addObject("mycart", cart);
				// Fetch the myCart list based on user ID
				List<Cart> cartList = cartDAO.list(userID);
				mv.addObject("cartList", cartList);
				mv.addObject("cartSize", cartList.size());
			}

		} else {
			log.debug("Invalid Credentials");

			mv.addObject("invalidCredentials", "true");
			mv.addObject("errorMessage", "Invalid Credentials");

		}
		log.debug("Ending of the method validate");
		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
		log.debug("Starting of the method logout");
		ModelAndView mv = new ModelAndView("/home");
		session.invalidate(); // will remove the attributes which are added
								// session
		session = request.getSession(true);
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.list());

		mv.addObject("logoutMessage", "You successfully logged out");
		mv.addObject("loggedOut", "true");
		
		 
		    
		log.debug("Ending of the method logout");
		return mv;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute User user) {
		log.debug("Starting of the method registerUser");
		ModelAndView mv = new ModelAndView("home");
		if (userDAO.get(user.getId()) == null) {
			user.setRole("ROLE_USER"); // all the users are end users by default
			userDAO.saveOrUpdate(user);
			log.debug("You are successfully register");
			mv.addObject("successMessage", "You are successfully registered");
		} else {
			log.debug("User exist with this id");
			mv.addObject("errorMessage", "User exist with this id");
		}
		log.debug("Ending of the method registerUser");
		return mv;
	}

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(Model model) {
		log.debug("Starting of the method loginError");
		model.addAttribute("errorMessage", "Login Error");
		log.debug("Ending of the method loginError");
		return "home";

	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model) {
		log.debug("Starting of the method accessDenied");
		model.addAttribute("errorMessage", "You are not authorized to access this page");
		log.debug("Ending of the method accessDenied");
		return "home";

	}

}
