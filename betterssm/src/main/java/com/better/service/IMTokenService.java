package com.better.service;

import org.springframework.stereotype.Service;

@Service
public interface IMTokenService {
	static final String YUNXIN_CREATE_URL = "https://api.netease.im/nimserver/user/create.action";
	static final String YUNXIN_REFRESH_URL = "https://api.netease.im/nimserver/user/refreshToken.action";
	static final String APP_KEY = "470db2cb2e4243d4769b82c654be241d";
	static final String APP_SECRET = "1e9e8cbc73f6";
	/**
	 * 用户手机号获取token
	 * @param phoneNo
	 * @return
	 */
	public String getNewToken(String phoneNo);
}
