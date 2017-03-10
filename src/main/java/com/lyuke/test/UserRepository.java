package com.lyuke.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lyuke
 * @Date 2017-03-04 01:52
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
