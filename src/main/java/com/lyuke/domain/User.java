package com.lyuke.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lyuke
 * @Date 2017-03-26 06:00
 */
@Entity
@Table(name = "t_users")
public class User {
	@Id
	@Column(name="users_id")
	private String userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_psd")
	private String userPsd;
	
	@Column(name="is_official")
	private boolean isOfficial;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPsd() {
		return userPsd;
	}

	public void setUserPsd(String userPsd) {
		this.userPsd = userPsd;
	}

	public boolean isOfficial() {
		return isOfficial;
	}

	public void setOfficial(boolean isOfficial) {
		this.isOfficial = isOfficial;
	}
	
	
}
