package com.apec.pos.service.serviceInterface;

import com.apec.pos.Dto.copy.MessageDto.MessageResponse;
import com.apec.pos.Dto.copy.MessageDto.MessageSendRequest;

public interface MessageInterface {

	public MessageResponse addMessage(MessageSendRequest messageSendRequest);
}
