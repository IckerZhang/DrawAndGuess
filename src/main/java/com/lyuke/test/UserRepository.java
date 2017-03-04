package com.lyuke.test;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lyuke
 * @Date 2017-03-04 01:52
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
