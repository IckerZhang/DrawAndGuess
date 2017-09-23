package com.lyuke.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyuke.domain.Room;
import com.lyuke.repository.RoomRepository;
import com.lyuke.service.IRoomService;

/**
 * @author Lyuke
 * @Date 2017-09-23 05:32
 */
@Service
@Transactional
public class RoomServiceImpl implements IRoomService {
	@Autowired
	private RoomRepository roomRepo;

	@Override
	public List<Room> getRooms() {
		List<Room> list = new ArrayList<>();
		list = roomRepo.findAll();
		return list;
	}

}
