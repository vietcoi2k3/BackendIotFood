package com.apec.pos.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.entity.RoomChatEntity;
import com.apec.pos.service.RoomService;


@RestController
public class RoomController {
	
	@Autowired
	private RoomService roomService;

	@MessageMapping("/topic-add-room")
	@SendTo("/public-add-room")
	public RoomChatEntity addUser(@Payload Integer shiperId) {
		System.out.println(shiperId);
//		System.out.println(userId);
		return roomService.addRoom(shiperId,2);
	}
}
