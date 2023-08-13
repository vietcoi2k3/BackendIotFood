package com.apec.pos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apec.pos.entity.AccountEntity;
import com.apec.pos.entity.RoomChatEntity;
import com.apec.pos.repository.RoomChatRepository;

import io.swagger.v3.oas.annotations.servers.Server;

@Service
public class RoomService extends BaseService<RoomChatRepository, RoomChatEntity, Integer>{
	
	@Autowired
	private RoomChatRepository roomChatRepository;

	@Override
	RoomChatRepository getRepository() {
		return roomChatRepository;
	}

	public RoomChatEntity getRoomChat(Integer id) {
		return roomChatRepository.findOne(id);
	}
	
	public RoomChatEntity addRoom(Integer shipperId,Integer userId) {
		RoomChatEntity roomChatEntity = new RoomChatEntity();
		roomChatEntity.setShipperId(shipperId);
		roomChatEntity.setUserId(userId);
		
		return	roomChatRepository.insert(roomChatEntity);
	}
}
