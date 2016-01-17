package com.pupov.oleg.purchase.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pupov.oleg.purchase.dao.PencilDao;
import com.pupov.oleg.purchase.dao.UserDao;
import com.pupov.oleg.purchase.model.Pencil;
import com.pupov.oleg.purchase.model.User;
import com.pupov.oleg.purchase.service.UserService;

@Transactional
@Controller
public class HelloWorldController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PencilDao pencilDao;
	
	
	String message = "Welcome to Spring MVC!";
	 
	@RequestMapping("/hello")
	@Transactional
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "Oleg") String name) {
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);


		mv.addObject("user_by_name", userService.getUserByName("not_real_user"));
		

		mv.addObject("users", userService.getAllUsers());

		Pencil pencil = pencilDao.findOne(2L);
		if (pencil != null)
		{
			mv.addObject("color", pencil.getColor());
			
		}

		Pencil pencilBlue = pencilDao.findByColor("blue");
		mv.addObject("pencilBlue", pencilBlue);		
		
		return mv;
	}
	
	@RequestMapping("/admin")
	public ModelAndView showAdmin() {
		ModelAndView mv = new ModelAndView("admin");
		return mv;
	}
	
	@RequestMapping("/403")
	public ModelAndView showNotPermitted() {
		ModelAndView mv = new ModelAndView("not_permitted");
		return mv;
	}
	
	@RequestMapping("/other")
	public ModelAndView showOther() {
		ModelAndView mv = new ModelAndView("other");
		return mv;
	}	

	@RequestMapping("/about")
	public ModelAndView showAbout() {
		ModelAndView mv = new ModelAndView("about");
		return mv;
	}	
	
}
