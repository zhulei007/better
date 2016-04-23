package com.better.service.Impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.better.dao.IMTokenBeanMapper;
import com.better.entity.IMTokenBean;
import com.better.entity.UserBean;
import com.better.service.IMTokenService;
import com.better.service.UserService;
import com.better.util.im.CheckSumBuilder;

@Service("imTokenService")
public class IMTokenServiceImpl implements IMTokenService {
	@Autowired
	private UserService userService;
	@Autowired
	private IMTokenBeanMapper imTokenBeanMapper;

	/**
	 * 新用户获取token,必须要有用户的id也是accid（云信id）
	 * 
	 * @param phoneNo
	 * @return
	 */
	public String getNewToken(String phoneNo) {
		String token = null;
		UserBean userBean = new UserBean();
		userBean.setMobile(phoneNo);
		UserBean user = userService.queryUser(userBean);

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(YUNXIN_CREATE_URL);

		String nonce = "18263890668";
		String curTime = String.valueOf((new Date()).getTime() / 1000L);
		String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, nonce,
				curTime);

		// 设置请求的header
		httpPost.addHeader("AppKey", APP_KEY);
		httpPost.addHeader("Nonce", nonce);
		httpPost.addHeader("CurTime", curTime);
		httpPost.addHeader("CheckSum", checkSum);
		httpPost.addHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=utf-8");

		// 设置请求的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("accid", user.getUid().toString()));
		nvps.add(new BasicNameValuePair("name", user.getUsername()));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			// 执行请求
			HttpResponse response = httpClient.execute(httpPost);
			// {"desc":"already register","code":414}
			String result = EntityUtils.toString(response.getEntity(), "utf-8");
			JSONObject object = JSON.parseObject(result);
			if (object.getShort("code") == 414) {
				token = getRefleshToken(user);
			} else {
				token = object.getJSONObject("info").getString("token");
			}
			IMTokenBean imTokenBean = new IMTokenBean();
			// 将token保存到数据库
			imTokenBean.setUserId(user.getUid());
			imTokenBean.setToken(token);
			imTokenBeanMapper.insertSelective(imTokenBean);
			return token;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return token;
	}

	/**
	 * 更新并获取用户Token
	 * 
	 * @param userBean
	 * @return
	 */
	private String getRefleshToken(UserBean userBean) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(YUNXIN_REFRESH_URL);

		String nonce = "18263890668";
		String curTime = String.valueOf((new Date()).getTime() / 1000L);
		String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, nonce,
				curTime);

		// 设置请求的header
		httpPost.addHeader("AppKey", APP_KEY);
		httpPost.addHeader("Nonce", nonce);
		httpPost.addHeader("CurTime", curTime);
		httpPost.addHeader("CheckSum", checkSum);
		httpPost.addHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=utf-8");

		// 设置请求的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("accid", userBean.getUid().toString()));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			// 执行请求
			HttpResponse response = httpClient.execute(httpPost);
			// {"desc":"already register","code":414}
			String result = EntityUtils.toString(response.getEntity(), "utf-8");
			JSONObject object = JSON.parseObject(result);
			String token = object.getJSONObject("info").getString("token");
			return token;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
