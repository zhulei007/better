package com.better.controller.ios;

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

import com.better.entity.GroupBean;
import com.better.service.GroupService;

/**
 * 移动端，组织信息控制器
 * 
 * @author zhule_000
 * 
 */
@Controller
@RequestMapping(value = "IOSLogin.do")
public class IOSGroupController {
	@Autowired
	private GroupService groupService;
	private Map<String, Object> result = new HashMap<String, Object>();
	private Map<String, Object> map = new HashMap<String, Object>();
	
	 /*
	  * 
	  * ｛
			organization组织名称
			organizationId组织id
			department部门名称
			departmentId 部门id
			name用户姓名
			cerNo证件号码
			｝

	  * */
	/**
	 * 获取我的组织信息
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "act=getMyGroup", method = RequestMethod.POST)
	public Map<String, Object> getMyGroup(HttpServletRequest request,
			HttpServletResponse response) {
		result.clear();
		map.clear();
		String userId = request.getParameter("userId");
		List<GroupBean> list = groupService.queryGroupList(Integer.parseInt(userId));
		
		for(GroupBean group:list){
			Map<String,Object> mapAmp = new HashMap<String,Object>();
			mapAmp.put("", group.getGname());
		}
		return map;
	}
}
