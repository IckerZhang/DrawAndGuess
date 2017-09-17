package com.lyuke.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Lyuke
 * @Date 2017-09-17 10:18
 */
@Entity
@Table(name = "t_rooms")
public class Room {

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
	private boolean isActive;

	/**
	 * 是否加密
	 */
	@Column(name = "need_psd")
	private boolean needPsd;

	@OneToOne(cascade = CascadeType.REFRESH,targetEntity=User.class)
    @JoinColumn(name="leader_id",referencedColumnName="users_id")
	private User room_leader;

	/**
	 * 用户集合，单向一对多，room方为关系维护方
	 */
	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id") // 增加一个外键列来实现一对多的单向关联
	private List<User> users = new ArrayList<User>();

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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isNeedPsd() {
		return needPsd;
	}

	public void setNeedPsd(boolean needPsd) {
		this.needPsd = needPsd;
	}

	public User getRoom_leader() {
		return room_leader;
	}

	public void setRoom_leader(User room_leader) {
		this.room_leader = room_leader;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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
