package com.lyuke.service;

import com.lyuke.domain.User;

/**
 * @author Lyuke
 * @Date 2017-09-16 02:58
 */
public interface IUserService {
	/**
	 * @param name
	 * @param psd
	 * 
	 *            用户注册
	 */
	void registerUser(String name, String psd);
}
