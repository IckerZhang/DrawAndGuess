package com.lyuke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lyuke.domain.Room;

/**
 * @author Lyuke
 * @Date 2017-09-23 05:26
 */
public interface RoomRepository extends JpaRepository<Room, Long> {
	Room findByRoomId(int roomid);
	
	List<Room> findAll();
}
