package com.apec.pos.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.Dto.copy.MessageDto.MessageResponse;
import com.apec.pos.Dto.copy.MessageDto.MessageSendRequest;
import com.apec.pos.entity.MessageEntity;
import com.apec.pos.response.Response;
import com.apec.pos.service.MessageService;

@RestController
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@MessageMapping("/topic/send-mess")
	@SendTo("/public/send-mess")
	public ResponseEntity sendMessage(@Payload MessageSendRequest messageSendRequest) {
			return ResponseEntity.ok(new Response (true,"",messageService.addMessage(messageSendRequest)));
			
	}
}
