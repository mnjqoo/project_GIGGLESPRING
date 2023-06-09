package com.giggler.giggle.controller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.giggler.giggle.dto.ListDTO;
import com.giggler.giggle.dto.UserDTO;
import com.giggler.giggle.service.ListService;

@CrossOrigin
@RestController
public class VueListController {
	private static final Logger logger = LoggerFactory.getLogger(VueListController.class);

	@Inject
	private ListService listService;
	
	//메인 피드 목록 VUE 
		@GetMapping("/main/mainhome/{user_no}")
		public List<ListDTO> allfeedList(@PathVariable String user_no) throws Exception {
			
			logger.info("allfeedList에서 user_no = " + user_no);
			
			System.out.println("user_no = " + user_no);
			
			List<ListDTO> allfeedList = listService.allfeedList(user_no);
			return allfeedList;
			}
		
		//검색 피드 목록 - feed용 VUE 
		@GetMapping("/main/search/{keyword}/userno/{user_no}")
		public List<ListDTO> searchfeedList(@PathVariable(value="keyword", required=false) String keyword, @PathVariable String user_no, Model model) throws Exception {
			
			logger.info("검색 피드 목록 - feed용 VUE");
			
			ListDTO listDTO = new ListDTO();
			model.addAttribute("keyword", keyword);
			listDTO.setKeyword(keyword);
			listDTO.setUser_no(Integer.valueOf(user_no));

			return listService.searchfeedList(listDTO);
			}		
		
	//검색 피드 목록 - user용 VUE 	-- post로 변경
		@PostMapping("/main/searchuser/{keyword}")
		public List<UserDTO> searchuserList(@PathVariable String keyword) throws Exception {
			logger.info("검색 피드 목록 - user용 VUE" + keyword);
			return listService.searchuserList(keyword);
			}
		
		
	//search - MyPage / NotMyPage 알아내기
		@PostMapping("/Gouserpage")
		public UserDTO Gouserpage(@RequestBody Map<String, String> param) throws Exception {
			
			logger.info("ListController에서 Gouserpage()실행....");
			logger.info("user_no = " + param.get("user_no"));
			
			int user_no = Integer.valueOf(param.get("user_no"));
			UserDTO UserDTO = listService.Gouserpage(user_no);
			return UserDTO;
			}
		
		
	//내가 쓴글 목록 VUE : user_no으로 알아내기
		@PostMapping("/myfeedList/{user_no}")
		public List<ListDTO> myfeedList(@PathVariable int user_no) throws Exception {
			
			logger.info("ListController에서 myfeedList()실행....");
			List<ListDTO> myfeedList = listService.myfeedList(user_no);
			return myfeedList;
			}
	
	//내가 좋아요한 글 목록 VUE
		@PostMapping("/mylikefeedList/{user_no}")
		public List<ListDTO> mylikefeedList(@PathVariable int user_no) throws Exception {
			
			logger.info("ListController에서 mylikefeedList()실행....");
			List<ListDTO> mylikefeedList = listService.mylikefeedList(user_no);
			return mylikefeedList;
			}
		
		
		//최근 검색어
		@PostMapping("/main/recentSearch")
		@ResponseBody
		public LinkedList<String> recentSearch(@RequestBody Map<String, String> keyword) throws Exception {
			
			logger.info("ListController에서 recentSearch()실행....");
			logger.info("keyword = " + keyword);
			
			Queue<String> recentSearch = new LinkedList<String>();
			
			String[] str = new String[5];
			
			
			// 검색 단어가 공백이면 저장하지 않음
			for(int i=0; i<keyword.size(); i++) {
				str[i] = keyword.get("keyword"+i);
				if(str[i] == "") {
					recentSearch.remove(str[i]);
				} else {					
					recentSearch.offer(str[i]);
				}
			}

			// 검색단어가 5개 이상이면 하나씩 지워준다.
			if(recentSearch.size() > 5) {
				recentSearch.remove();
			} else {
				System.out.println("검색어 저장");
			}
			
			System.out.println("(LinkedList<String>) recentSearch = " + (LinkedList<String>) recentSearch);
			
			return (LinkedList<String>) recentSearch;
		}
		
		// 특정 검색어 삭제하기
		@PostMapping("/deleteThisSearchWord")
		@ResponseBody
		public LinkedList<String> deleteThisSearchWord(@RequestBody Map<String, String> recentSearchList) throws Exception {
			
			
			logger.info("ListController에서 recentSearch()실행....");
			logger.info("삭제할 keyword = " + recentSearchList.get("num"));
			
			Queue<String> recentSearch = new LinkedList<String>();
			
			String[] str = new String[5];
			
			//클릭했을 때 넘어온 값과 같으면 삭제해준다.
			for(int i=0; i<recentSearchList.size(); i++) {
				str[i] = recentSearchList.get("keyword"+i);
				if(str[i] == recentSearchList.get("num")) {
					recentSearch.remove(str[i]);
				} else if(str[i] != recentSearchList.get("num") && str[i] != ""){					
					recentSearch.offer(str[i]);
				}
			}

			if(recentSearch.size() > 5) {
				recentSearch.remove();
			} else {
				System.out.println("검색어 저장");
			}
			
			// 값을 삭제해 준 후 리스트를 훑어 null값인 것은 삭제해주고 반환한다.
			for(int i=0; i<recentSearch.size(); i++) {
				str[i] = recentSearch.poll();
				if(str[i] == null || str[i] == "") {
					recentSearch.remove(str[i]);
				} else {
					recentSearch.offer(str[i]);
				}
			}
			
			System.out.println("(LinkedList<String>) recentSearch = " + (LinkedList<String>) recentSearch);
			
			return (LinkedList<String>) recentSearch;			
			
		}

		
		
		
	}// END - public class VueListController


