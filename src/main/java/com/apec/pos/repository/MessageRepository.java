package com.apec.pos.repository;


import org.springframework.stereotype.Repository;

import com.apec.pos.entity.MessageEntity;

@Repository
public class MessageRepository extends BaseRepository<MessageEntity, Integer>{

	public MessageRepository() {
		super(MessageEntity.class);
	}

}
