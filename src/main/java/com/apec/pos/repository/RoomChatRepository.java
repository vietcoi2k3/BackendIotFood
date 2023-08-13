package com.apec.pos.repository;

import org.springframework.stereotype.Repository;

import com.apec.pos.entity.RoomChatEntity;

@Repository
public class RoomChatRepository extends BaseRepository<RoomChatEntity, Integer>{

	public RoomChatRepository() {
		super(RoomChatEntity.class);
		// TODO Auto-generated constructor stub
	}

}
