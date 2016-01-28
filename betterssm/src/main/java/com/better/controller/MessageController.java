package com.better.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.better.entity.GroupUserBeanKey;
import com.better.entity.UserBean;
import com.better.service.FriendService;
import com.better.service.GroupService;

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

	@RequestMapping(value = "act=addMessType", method = RequestMethod.GET)
	public ModelAndView addMessType(HttpServletRequest request,
			HttpServletResponse response) {
//		UserBean user = userService.queryUser(100);
//		System.out.println(user);
		ModelAndView mav = new ModelAndView("test");
//		UserBean user = new UserBean();
//		user.setMobile("13088888888");
//		user.setPass("123456");
//		userService.checkUser(user);
		
//		List<UserBean>  list = groupService.queryUserList(1);
//		if(list==null){
//			System.out.println("chucuo");
//		}
		
//		
		GroupUserBeanKey groupUserBean = new GroupUserBeanKey();
		groupUserBean.setGid(1);
		groupUserBean.setUid(100);
		
		groupService.addUser(groupUserBean);
		//groupService.deleteUser(groupUserBean);
		
		List<UserBean> userList = friendService.queryFriendList(5);
		for(UserBean user:userList){
			System.out.println(user.getUsername());
		}
		
		for(UserBean user:groupService.queryUserList(1)){
			System.out.println("----------------");
			System.out.println(user.getUsername()+"::::");
		}
		System.out.println(groupService.deleteUser(groupUserBean)+"=========");
		//groupService.addUser(groupUserBean);
//		GroupBean group = groupService.queryGroup(1);
//		System.out.println(group.getGname());
//		System.out.println("用户列表数量："+list.size());
		// MessTypeBean messTypeBean = new MessTypeBean();
		// messTypeBean.setMemo("演出消息类别，是学校、学院等组织发布的消息。");
		// messTypeBean.setStatus((short)1);
		// messTypeBean.setTname("演出");
		// messTypeBean.setTid(1);
		// int i = messageService.;
		// if(i>0){
		// return mav;
		// }

		// System.out.println(messTypeService.getMessType(1).getTname());

		return mav;

	}
}
