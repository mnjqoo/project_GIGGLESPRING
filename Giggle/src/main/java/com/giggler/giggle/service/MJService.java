package com.giggler.giggle.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.giggler.giggle.dao.MJDAO;
import com.giggler.giggle.dto.AlarmDTO;
import com.giggler.giggle.dto.ChatRoomDTO;
import com.giggler.giggle.dto.MessageDTO;
import com.giggler.giggle.dto.UserDTO;

@Service("mjService")
public class MJService {
	
	@Inject
	MJDAO mjDAO;
	
	//이메일 중복 확인하기===========================================
	public int emailCheck(String user_email) throws Exception {
		System.out.println("MjService의 emailCheck()");
		
		return mjDAO.emailCheck(user_email);
	}
	
	//닉네임 중복 확인하기========================================================
	public int nickCheck(String user_nick) throws Exception {
		System.out.println("MjService의 nickCheck()");
		
		return mjDAO.nickCheck(user_nick);
	}		
	
	//회원 정보로 회원 등록하기====================================================
	public int userRegister(UserDTO userDTO) throws Exception {
		System.out.println("MjService의 회원가입 처리 시작");
		
		return mjDAO.userRegister(userDTO);
	}

	//이메일을 가지고 UserDTO 객체 가져오기==========================================
	public UserDTO getUserDTOByEmail(String email) throws Exception {
		System.out.println("MjService의 getUserDTOByEmail()");
		
		return mjDAO.getUserDTOByEmail(email);
	}
	
	//네이버 로그인 토큰 확인=========================================================
	public UserDTO naverLogin(String naver_token) throws Exception {
		System.out.println("MjService의 naverLogin()");
		
		return mjDAO.naverLogin(naver_token);
	}
	
	//비밀번호 일치 여부 확인하기=====================================================
	public int checkPwd(UserDTO userDTO) throws Exception {
		System.out.println("MjService의 checkPwd()");
		
		return mjDAO.checkPwd(userDTO);		
	}
	
	//비밀번호 변경하기==========================================================
	public int chagePwd(UserDTO userDTO) throws Exception {
		System.out.println("MjService의 chagePwd()");
		
		return mjDAO.chagePwd(userDTO);			
	}
	
	//회원 탈퇴하기 ====================================================================
	public int unregister(int user_no) throws Exception {
		System.out.println("MjService의 unregister()");
		
		return mjDAO.unregister(user_no);		
	}
	
	//회원 번호에 해당하는 알람 리스트 가져오기======================================
	public List<AlarmDTO> getAlarmListByUserNo (int user_no) throws Exception {
		System.out.println("MjService의 getAlarmListByUserNo()");
		
		return mjDAO.getAlarmListByUserNo(user_no);
	}
	
	//회원번호에 해당하는 알람 유무 상태를 가져온다=================================
	public String getUserAlarmYN(int user_no) throws Exception {
		System.out.println("MjService의 getUserAlarmYN()");
		
		return mjDAO.getUserAlarmYN(user_no);			
	}
	
	//회원번호에 해당하는 알람 유무 상태를 바꿔준다.===================================
	public int updateUserAlarmYN(int user_no) throws Exception {
		System.out.println("MjService의 updateUserAlarmYN()");
		
		return mjDAO.updateUserAlarmYN(user_no);			
	}
		
	//알람 번호에 해당하는 데이터 삭제하기======================================
	public int deleteAlarm(int alarm_no) throws Exception {
		System.out.println("MjService의 deleteAlarm()");
		
		return mjDAO.deleteAlarm(alarm_no);		
	}
	
	//회원 번호에 해당하는 채팅방 리스트 가져오기===================================
	public List<ChatRoomDTO> getChatRoomListByUserNo(int user_no) throws Exception {
		System.out.println("MjService의 getChatRoomListByUserNo()");
		
		return mjDAO.getChatRoomListByUserNo(user_no);		
	}
	
	//회원번호에 해당하는 메세지 유무 상태를 가져온다=================================
	public String getUserMessageYN(int user_no) throws Exception {
		System.out.println("MjService의 getUserMessageYN()");
		
		return mjDAO.getUserMessageYN(user_no);			
	}
	
	//회원번호에 해당하는 메세지 유무 상태를 바꿔준다.===================================
	public int updateUserMessageYN(int user_no) throws Exception {
		System.out.println("MjService의 updateUserMessageYN()");
		
		return mjDAO.updateUserMessageYN(user_no);			
	}
	
	//키워드로 유저 리스트 구하기=================================================
	public List<UserDTO> searchUser(Map<String, Object> map) throws Exception {
		System.out.println("MjService의 searchUser()");
		
		//상대방이 나를 차단했거나, 내가 차단한 사람의 정보는 빼준다.
		
		return mjDAO.searchUser(map);
	}
	
	//두개의 유저 번호로 채팅방 정보 가져오기=======================================
	public ChatRoomDTO getChatRoom(ChatRoomDTO chatRoomDTO) throws Exception {
		System.out.println("MjService의 getChatRoom()");
		
		return mjDAO.getChatRoom(chatRoomDTO);
	}
	
	//채팅방 번호에 해당하는 메세지 리스트 가져오기==================================
	public List<MessageDTO> getMessageList(MessageDTO messageDTO) throws Exception {
		System.out.println("MjService의 getMessageList()");
		
		return mjDAO.getMessageList(messageDTO);		
	}
	
	//채팅방에 메세지 추가하기=======================================================
	public int addMessage(MessageDTO messageDTO) throws Exception {
		System.out.println("MjService의 addMessage()");
		
		return mjDAO.addMessage(messageDTO);		
	}

	//채팅방 나가기================================================================
	public int deleteChatRoom(ChatRoomDTO chatRoomDTO) throws Exception {
		System.out.println("MjService의 addMessage()");
		
		return mjDAO.deleteChatRoom(chatRoomDTO);		
	}
}
