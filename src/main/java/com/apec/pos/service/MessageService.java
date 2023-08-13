package com.apec.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apec.pos.entity.MessageEntity;
import com.apec.pos.repository.MessageRepository;

@Service
public class MessageService extends BaseService<MessageRepository, MessageEntity, Integer>{

	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	MessageRepository getRepository() {
		return messageRepository;
	}
}
