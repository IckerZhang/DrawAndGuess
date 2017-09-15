package com.lyuke.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Lyuke
 * @Date 2017-09-16 01:25
 */
@Controller
public class IndexController {

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
	 * @return String
	 * 
	 *         注册
	 */
	@RequestMapping("/register")
	public String register(Model mode, @RequestParam("inputEmail") String name,
			@RequestParam("inputPassword") String password) {
		System.err.println(mode.toString()+name+password);
		return "redirect:/";
	}
}
