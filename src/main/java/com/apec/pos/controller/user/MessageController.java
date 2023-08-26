package com.apec.pos.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.Dto.MessageDto.MessageResponse;
import com.apec.pos.Dto.MessageDto.MessageSendRequest;
import com.apec.pos.entity.MessageEntity;
import com.apec.pos.response.Response;
import com.apec.pos.service.MessageService;

@RestController
@RequestMapping(value = "user")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@MessageMapping("/topic/send-mess")
	@SendTo("/public/send-mess")
	public ResponseEntity sendMessage(@Payload MessageSendRequest messageSendRequest) {
			return ResponseEntity.ok(new Response (true,"",messageService.addMessage(messageSendRequest)));
	}
	
	
}
