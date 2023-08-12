package com.apec.pos.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class RoomChatEntity extends BaseEntity{
	@OneToMany
	@JsonManagedReference(value = "mes-room")
	private List<MessageEntity> messageEntities;

	public List<MessageEntity> getMessageEntities() {
		return messageEntities;
	}

	public void setMessageEntities(List<MessageEntity> messageEntities) {
		this.messageEntities = messageEntities;
	}
	
	
}
