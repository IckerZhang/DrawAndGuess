package com.lyuke.test;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Lyuke
 * @Date 2017-03-03 10:28
 * 
 * demo
 */

@Controller
public class HelloController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/hello")
	public String say(Map<String,Object> map){
		map.put("hello","hello thymeleaf,bootstrap");
		return "login/login";
	}
	
	@RequestMapping("/userlist")
	public ModelAndView userList(){
		ModelAndView m = new ModelAndView();
		List<User> userlist = userRepository.findAll();
		User user = new User();
		user.setAddress(null);
		user.setName("测试");
		user.setPassword("11111");
		user.setAge(12);
		//userRepository.save(user);
		m.addObject("list", userlist);
		m.setViewName("demo/list");
		return m;
		
	}
}
