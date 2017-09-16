package com.lyuke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyuke.service.IUserService;

/**
 * @author Lyuke
 * @Date 2017-09-16 01:25
 */
@Controller
public class UserController {
	@Autowired
	private IUserService userService;

	/**
	 * @return String
	 * 
	 *         首页
	 */
	@RequestMapping("/")
	public String loginHtml() {
		return "index/login";
	}

	/**
	 * @return String
	 * 
	 *         转到注册页面
	 */
	@RequestMapping("/goRegister")
	public String goRegisterHtml() {
		return "index/register";
	}

	/**
	 * @param mode
	 * @param name
	 * @param password
	 * @return String
	 * 
	 *        注册功能
	 */
	@RequestMapping("/register")
	public String register(Model mode, @RequestParam("inputEmail") String name,
			@RequestParam("inputPassword") String password) {
		userService.registerUser(name, password);
		return "redirect:/";
	}
}
