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
	public void registerUser(String name, String psd);

	/**
	 * @param name
	 * @param psd
	 * @return String
	 * 
	 *         用户登陆
	 * 
	 */
	public String userLogin(String name, String psd);
}
