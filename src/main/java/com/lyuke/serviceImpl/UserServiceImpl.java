package com.lyuke.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyuke.domain.User;
import com.lyuke.repository.UserRepository;
import com.lyuke.service.IUserService;
import com.lyuke.util.StringUtil;

/**
 * @author Lyuke
 * @Date 2017-09-16 02:58
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void registerUser(String name, String psd) {
		User user = new User();
		String uid = StringUtil.getTouristID();
		user.setUserId(uid);
		user.setUserNickname(uid);
		user.setUserName(name);
		user.setUserPsd(psd);
		user.setOfficial(true);
		userRepository.save(user);
	}

	@Override
	public String userLogin(String name, String psd) {
		User user = userRepository.findByUserNameAndUserPsd(name, psd);
		if(user==null){
			return "loginError";
		}else{
			return "loginSuccess";
		}
	}

}
