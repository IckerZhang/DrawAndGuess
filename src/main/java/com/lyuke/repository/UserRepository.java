package com.lyuke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lyuke.domain.User;

/**
 * @author Lyuke
 * @Date 2017-09-16 02:40
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserId(String userid);
	
	List<User> findAll();
	
	void deleteByUserId(String userid);
	
	User findByUserNameAndUserPsd(String name, String psd);
}
