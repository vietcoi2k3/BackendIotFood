package com.apec.pos.controller.user;





import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;


import com.apec.pos.Dto.copy.RoomDto.AddRoomRequest;

import com.apec.pos.response.Response;
import com.apec.pos.service.RoomService;


 

@RestController
public class RoomController {
	
	@Autowired
	private RoomService roomService;

	@MessageMapping("/topic/add-room")
	@SendTo("/public/add-room")
	public ResponseEntity addUser(@Payload AddRoomRequest addRoomRequest,MessageHeaders headers ){
		System.out.println();
		return ResponseEntity.ok(new Response(true,"thêm phòng thành công",roomService.addRoom(addRoomRequest.getShipperId(), addRoomRequest.getUserId())));
	}
}
