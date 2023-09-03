package com.apec.pos.service.serviceInterface;

import com.apec.pos.Dto.MessageDto.MessageResponse;
import com.apec.pos.Dto.MessageDto.MessageSendRequest;

public interface MessageInterface {

    public MessageResponse addMessage(MessageSendRequest messageSendRequest);
}
