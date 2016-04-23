package com.better.controller.ios;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.better.entity.DepartBean;
import com.better.entity.OrgBean;
import com.better.service.OrgService;
import com.better.service.UserService;

@Controller
@RequestMapping(value = "IOSOrg.do")
public class IOSOrgController {
	@Autowired
	private OrgService orgService;
	@Autowired
	private UserService userService;
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
			cerNo证件号码//这个证件号不知所云，暂不返回
			｝

	  * */
	/**
	 * 
	 * 获取我的组织信息<br>
	 * 根据返回值只有个组织，所以必须根据组织id来获取
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "act=getMyOrg", method = RequestMethod.POST)
	public Map<String, Object> getMyOrg(HttpServletRequest request,
			HttpServletResponse response) {
		result.clear();
		map.clear();
		//得到组织id
		String orgId = request.getParameter("orgId");
		String userId = request.getParameter("userId");
		
		OrgBean orgBean = new OrgBean();
		DepartBean departBean = new DepartBean();
		
		if(orgId == null ||"".equals(orgId)){
			map.put("code", 0);
			//没有该组织直接返回失败
			return map;
		}
		orgBean = orgService.queryOrg(Integer.parseInt(orgId));
		
		result.put("organization", orgBean.getOname());
		result.put("organizationId", orgBean.getOid());
		departBean = orgService.queryUserDepart(Integer.parseInt(orgId), Integer.parseInt(userId));
		if(departBean == null){
			result.put("department","" );
			result.put("departmentId", "");
		}else{
			result.put("department", departBean.getDname());
			result.put("departmentId", departBean.getDid());
		}
		result.put("name", userService.queryUser(Integer.parseInt(userId)).getUsername());
		map.put("code", 1);
		map.put("result", result);
		return map;
	}
}
