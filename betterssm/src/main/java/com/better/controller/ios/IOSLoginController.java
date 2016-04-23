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

import com.better.dao.IMTokenBeanMapper;
import com.better.entity.IMTokenBean;
import com.better.entity.UserBean;
import com.better.service.IMTokenService;
import com.better.service.UserService;
import com.better.util.im.TokenUtil;

/**
 * IOSLoginController:该控制器为移动ios\android提供数据
 * 
 * @author zhule_000
 * 
 */
@Controller
@RequestMapping(value = "IOSLogin.do")
public class IOSLoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private IMTokenService imTokenService;
	private Map<String, Object> result = new HashMap<String, Object>();
	private Map<String, Object> map = new HashMap<String, Object>();
	/**默认的头像图片地址**/
	static final String DEFAULT_IMG="";

	/*
	 * url:IOSLogin.do?act=login&phoneNo=x&password=xxx 
	 * { “code”:”0/1/”,
	 * “result”:{ “userId”:”主键” “phoneNo”:”手机号码”,
	 * “token”:”验证密钥”, “image”:”头像图片地址”, “rongYunId”：融云1d； “nickName”:”昵称”,
	 * “sex”:”性别”1-男 2-女 “signature”：个人签名 }
	 */
	@ResponseBody
	@RequestMapping(value = "act=login", method = RequestMethod.GET)
	public Map<String, Object> login(HttpServletRequest request,
			HttpServletResponse response) {

		result.clear();
		map.clear();

		String phoneNo = request.getParameter("phoneNo");
		String password = request.getParameter("password");
		System.out.println(phoneNo + password + "这是数据 ");
		UserBean userBean = new UserBean();
		userBean.setMobile(phoneNo);
		userBean.setPass(password);
		UserBean user = userService.queryUser(userBean);
		if (user == null) {
			map.put("code", "0");
			return map;
		}
		result.put("userId", user.getUid());
		result.put("phoneNo", user.getMobile());
		
		result.put("token",imTokenService.getNewToken(phoneNo) );
		result.put("email", user.getEmail());
		result.put("image", user.getHead());
		result.put("nickName", user.getUsername());
		result.put("sex", user.getSex());
		result.put("signature", user);
		
		map.put("code", 1);
		map.put("result", result);
		return map;
	}

	/*
	 * { “code”:”0/1/2/3”,
	 *  “message”:”用户不存在/用户已注册/注册成功/系统异常”,
	 *   “result”:{
	 * “id”:”主键” 
	 * “phoneNo”:”手机号码”,
		“token”:”验证密钥”, 
		“image”:”图片地址”,
	 * “nickName”:”昵称”, 
	 * “sex”:”性别” } }
	 */
	/**
	 * 注册
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "act=reg", method = RequestMethod.GET)
	public Map<String, Object> reg(HttpServletRequest request,
			HttpServletResponse response) {
		result.clear();
		map.clear();
		
		String phoneNo = request.getParameter("phoneNo");
		String password = request.getParameter("password");
		String verifyCode = request.getParameter("verifyCode");
		UserBean userBean = new UserBean();
		userBean.setMobile(phoneNo);
		if(verifyCode!=""){
			//注册码不正确:102
			map.put("code", "102");
			return map;
		}
		UserBean user = userService.queryUser(userBean);
		
		if(user.getMobile() == phoneNo){
			//手机号已被注册：204
			map.put("code", "204");
			return map;
		}
		//首先保存用户
		userBean.setPass(password);
		userService.addUser(userBean);
		
		result.put("token", imTokenService.getNewToken(phoneNo));
		result.put("image",DEFAULT_IMG);
		/**第一次注册默认为男性**/
		result.put("sex", "1");		
		return map;
	}

	/**
	 * 验证
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "act=verify", method = RequestMethod.POST)
	public Map<String,Object> verify(HttpServletRequest request,
			HttpServletResponse response){
		String verify = request.getParameter("verifyCode");
		String phoneNo = request.getParameter("phoneNo");
				return map;
		
	}
	/*
	 * 
	 * phoneNo，手机号码，String
password，密码，String
oldpwd，旧密码，String
token，密钥，String

	 * 
	 * */
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "act=changePass", method = RequestMethod.POST)
	public Map<String, Object> changePass(HttpServletRequest request,
			HttpServletResponse response){
		result.clear();
		map.clear();
		String phoneNo = request.getParameter("phoneNo");
		String password = request.getParameter("password");
		String oldpwd = request.getParameter("oldpwd");
		String token = request.getParameter("token");
		UserBean userBean = new UserBean();
		userBean.setMobile(phoneNo);
		userBean.setPass(oldpwd);
		if(userService.changePwd(userBean, password)){
			map.put("code", "1");
			return map;
		}
		map.put("code", "0");
		return map;
	}
	/*
	 * “userId”:”主键”
		“phoneNo”:”手机号码”,
		“token”:”验证密钥”,
		“image”:”头像图片地址”,
		“rongYunId”：融云1d；
		“nickName”:”昵称”,
		“sex”:”性别”
		“signature”：个人签名

	 * */
	/**
	 * 修改用户资料
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "act=changeUserInfo", method = RequestMethod.POST)
	public Map<String,Object> changeUserInfo(HttpServletRequest request,
			HttpServletResponse response){
		result.clear();
		map.clear();
		String userId = request.getParameter("userId");
		String phoneNo = request.getParameter("phoneNo");
		String token = request.getParameter("token");
		String rongYunId = request.getParameter("rongYunId");
		String image = request.getParameter("image");
		String nickName = request.getParameter("nickName");
		String sex = request.getParameter("sex");
		String signature = request.getParameter("signature");
		UserBean userBean = new UserBean();
		userBean.setPass(phoneNo);
		userBean.setHead(image);
		userBean.setUsername(nickName);
		userBean.setSex(Integer.parseInt(sex));
		userBean.setSignature(signature);
		
		if(userService.updateUser(userBean) >= 0){
			map.put("code", "1");
		}
		map.put("code", "0");
		return map;
	}
	
	
	/**
	 * 将user封装成map
	 * 
	 * @param user
	 * @return
	 */
	private Map<String, Object> userToMap(UserBean user) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", user.getUid());
		map.put("phoneNo", user.getMobile());
		map.put("token", null);
		map.put("email", user.getEmail());
		map.put("image", user.getHead());
		map.put("nickName", user.getUsername());
		map.put("sex", user.getSex());
		map.put("signature", user);
		return map;
	}
	
}
