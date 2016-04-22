package com.better.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.better.entity.FriendBean;
import com.better.entity.GroupUserBeanKey;
import com.better.entity.UserBean;
import com.better.service.FriendService;
import com.better.service.GroupService;
import com.better.service.UserService;

@Controller
@RequestMapping(value = "message.do")
public class MessageController {
	// @Autowired
	// private MessageService messageService;
//	@Autowired
//	private MessTypeService messTypeService;
//	@Autowired
//	private UserService userService;
	
	@Autowired
	private GroupService groupService;
	
	@Autowired
	private FriendService friendService;
	
	@Autowired
	private UserService userService;
	private Map<String,String> map = new HashMap();
	

	@RequestMapping(value = "act=addMessType", method = RequestMethod.GET)
	public ModelAndView addMessType(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mav = new ModelAndView("test");
		return mav;

	}
}
