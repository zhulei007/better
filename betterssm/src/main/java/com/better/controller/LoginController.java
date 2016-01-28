package com.better.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.better.service.UserService;

@Controller
@RequestMapping(value = "login.do")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "act=login", method = RequestMethod.GET)
	public ModelAndView addMessType(HttpServletRequest request,
			HttpServletResponse response) {
		
		return null;
	}
}
