package com.lyuke.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Lyuke
 * @Date 2017-09-17 10:18
 */
@Entity
@Table(name = "t_rooms")
public class Room {
	@Transient
	private int MAX_USERS = 10;

	@Transient
	private int userCount = 0;
	/**
	 * 房间号
	 */
	@Id
	@Column(name = "room_id")
	private int roomId;

	/**
	 * 0 准备中 1游戏中
	 */
	@Column(name = "game_state")
	private int gameState;

	/**
	 * 房间是否激活，激活表示有人，未激活表示无人
	 */
	@Column(name = "is_active")
	private int isActive;

	/**
	 * 是否加密
	 */
	@Column(name = "need_psd")
	private int needPsd;

	/**
	 * 用户集合，单向一对多，room方为关系维护方
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,targetEntity=User.class)
	@JoinColumn(name="room_id")
	private Set<User> userSet;

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getGameState() {
		return gameState;
	}

	public void setGameState(int gameState) {
		this.gameState = gameState;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getNeedPsd() {
		return needPsd;
	}

	public void setNeedPsd(int needPsd) {
		this.needPsd = needPsd;
	}

	public Set<User> getUsers() {
		return userSet;
	}

	public void setUsers(Set<User> userSet) {
		this.userSet = userSet;
	}

	public int getMAX_USERS() {
		return MAX_USERS;
	}

	public int getUserCount() {
		if(userSet==null)
			return 0;
		else
			return userSet.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + roomId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (roomId != other.roomId)
			return false;
		return true;
	}
}
