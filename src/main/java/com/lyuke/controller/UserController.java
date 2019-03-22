package com.lyuke.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyuke.domain.Room;
import com.lyuke.service.IRoomService;
import com.lyuke.service.IUserService;

/**
 * @author Lyuke
 * @Date 2017-09-16 01:25
 */
@Controller
public class UserController {
	@Autowired
	private IUserService userService;

	@Autowired
	private IRoomService roomService;

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
	 *         注册功能
	 */
	@RequestMapping("/register")
	public String register(Model mode, @RequestParam("inputEmail") String name,
			@RequestParam("inputPassword") String password) {
		userService.registerUser(name, password);
		return "redirect:/";
	}

	/**
	 * @param mode
	 * @param name
	 * @param password
	 * @return String
	 * 
	 *         用戶登陸
	 */
	@RequestMapping("/login")
	public String login(Model mode, @RequestParam("inputEmail") String name,
			@RequestParam("inputPassword") String password) {

		String result = userService.userLogin(name, password);
		if ("loginSuccess".equals(result)) {
			List<Room> list = roomService.getRooms();
			mode.addAttribute("roomList", list);
			return "index/index";
		} else
			return "redirect:/";
	}

	/**
	 * @return String
	 * 
	 *         回首页
	 */
	@RequestMapping("/home")
	public String home() {
		return "index/index";
	}
	
	public static void main(String[] args) {
		String s="1,2";
		String sl=Optional.ofNullable(StringUtils.split(s,","));
		System.out.println();
	}
}
