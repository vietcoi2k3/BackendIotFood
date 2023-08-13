package com.apec.pos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MessageEntity extends BaseEntity{

	@Column
	private String content;
	
	@Column(name = "accountEntityId")
	private Integer accountEntityId;
	
	@Column(name = "roomChatEntityId")
	private Integer roomChatEntityId;

	@ManyToOne
	@JoinColumn(name = "accountEntityId",updatable = false,insertable = false)
	@JsonBackReference(value = "account-mess")
	private AccountEntity accountEntity;
	
	@ManyToOne
	@JoinColumn(name = "roomChatEntityId",updatable = false,insertable = false)
	@JsonBackReference(value = "mes-room")
	private RoomChatEntity roomChatEntity;
	
	public MessageEntity(String createBy, String modifiedBy, String content, AccountEntity accountEntity) {
		super(createBy, modifiedBy);
		this.content = content;
		this.accountEntity = accountEntity;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
