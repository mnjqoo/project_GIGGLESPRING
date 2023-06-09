package com.giggler.giggle.dao;

import java.util.List;

import com.giggler.giggle.dto.ChatRoomDTO;
import com.giggler.giggle.dto.MessageDTO;

public interface ChatDAO {

	public void createRoom(ChatRoomDTO dto)throws Exception;
	public ChatRoomDTO isRoom(ChatRoomDTO dto)throws Exception;
	public void insertMessage(MessageDTO vo)throws Exception;
	public String getProfile(String str)throws Exception;
	public String getName(String str)throws Exception;
	public List<MessageDTO> getMessageList(String str)throws Exception;
	public List<ChatRoomDTO> getRoomList(String str)throws Exception;
	public MessageDTO getRecentMessage(String str)throws Exception;
	//public String isGetMessageList(String str)throws Exception;
	
	public List<ChatRoomDTO> getRoomListTutor(String str)throws Exception;
	public void updateReadTime(String user_nick)throws Exception;
	
	public int getUnReadCount(String user_nick)throws Exception;
	
	public int getAllCount(String str);
	
}
