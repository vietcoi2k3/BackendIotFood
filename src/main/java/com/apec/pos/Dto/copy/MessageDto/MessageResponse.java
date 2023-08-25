package com.apec.pos.Dto.copy.MessageDto;

import java.util.Date;

public class MessageResponse {
	
	private Integer id;
	private String content;
	private Integer userId;
	private Integer roomId;
	private Date createAt;
	
	
	public MessageResponse() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public MessageResponse(Integer id, String content, Integer userId, Integer roomId, Date createAt) {
		super();
		this.id = id;
		this.content = content;
		this.userId = userId;
		this.roomId = roomId;
		this.createAt = createAt;
	}
	
	
}
