package com.apec.pos.controller.user;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apec.pos.dto.RoomDto.AddRoomRequest;
import com.apec.pos.response.Response;
import com.apec.pos.service.RoomService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
@RequestMapping(value = "user")
@SecurityRequirement(name = "bearerAuth")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @MessageMapping("/topic/add-room")
    @SendTo("/public/add-room")
    public ResponseEntity addUser(@Payload AddRoomRequest addRoomRequest, MessageHeaders headers) {
        System.out.println();
        return ResponseEntity.ok(new Response(true, "thêm phòng thành công", roomService.addRoom(addRoomRequest.getShipperId(), addRoomRequest.getUserId())));
    }

    @Operation(summary = "lấy tất cả các phòng")
    @RequestMapping(method = RequestMethod.GET, value = "get-list-room")
    public ResponseEntity getListRoom() {
        return ResponseEntity.ok(new Response(true, "", roomService.getListRoomResponses()));
    }

    @RequestMapping(value = "get-chat-room", method = RequestMethod.GET)
    public ResponseEntity getRoom(@RequestParam Integer id) {
        return ResponseEntity.ok(new Response(true, "", roomService.getListRoomChat(id)));
    }
}
