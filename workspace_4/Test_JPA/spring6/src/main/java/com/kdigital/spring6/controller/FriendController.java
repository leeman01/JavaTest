package com.kdigital.spring6.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kdigital.spring6.FriendService;
import com.kdigital.spring6.dto.Friend;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
/*
 *  화면을 요청
 */
@Controller
@Slf4j
@RequiredArgsConstructor 
// 생성자 주입방식 이다 , setter annotation 주입방식이 있다 => 내가 객체를 생성하지않겟다 /
// 객체를 생성해버리면 클래스가 묶여 클래스의 연쇄적인 영향을 미칠 수 있다
public class FriendController {
	final FriendService service ; // 주입(injection)받음 == > IoC
	// Bean(Spring이 관리하는 ) 객체를 주입받음
	@GetMapping("/insertFriend")
	public String insertFriend(Model model) {
		model.addAttribute("friend",new Friend()); //(Error 처리를 위해) 아무것도 없는 빈 데이터로 넣음=비어있는 객체의 데이터를 추가
		return "insertFriend" ;
	}
	/**
	 * 저장을 요청
	 * @param friend
	 * @return
	 */
	// 아래에잇는 걸 에노테이션이라고 하는데  에노테이션은 같은 클래스에 있으면 호출 x  클라이언트나 html에서 요청하는 걸 받음
	@PostMapping("/insertFriend") // 저장을 할때 설정한 오류가 발생하면? => 이거를 미리 알아채도록 만들어줌 @valid
	// 데이터를 받앗을 때 잘못된걸 알려주는 바인딩 작업이 필요하다
	public String insertFriend(
			@Valid 
			@ModelAttribute Friend friend,
			BindingResult bindingResult
			) {
		// 저장할 수 있도록 service에 데이터를 넘김
		log.info("friend 객체 {} ",friend.toString());
		log.info("bindingResult: {}" ,bindingResult);
		service.insert(friend);
		if(bindingResult.hasErrors()) {
			log.info("validation 시 오류 발생");
			return "insertFriend";
		}
		return "redirect:/" ; // index로 가는 요청을 함  => 브라우저한테 / 요청을 하도록 함 ! (redirect 방식)
	}
	
	@GetMapping("/listFriend")
	public String listFriend(Model model) {
		List<Friend> list = service.list();
		model.addAttribute("list",list);
		return "listFriend";
	}
	/**
	 * 파라미터로 전송받은 fseq값을 이용해 DB에서 데이터를 삭제하도록 전달함
	 * @param fseq
	 * @return
	 */
	@GetMapping("/deleteOne")
	public String dleteFriend(@RequestParam(name="fseq") Integer fseq) {
		log.info("전달된번호==> {}" , fseq);
		
		service.deleteOne(fseq) ;
		
		return ("redirect:/listFriend") ; // redirect는 get 요청 !!
	}
	/**
	 * 데이터를 수정하기 전 수정할 데이터를 DB에서 조회하는 기능
	 * @param fseq
	 * @return
	 */
	@GetMapping("/updateOne")
	public String updateFriend(@RequestParam(name="fseq") Integer fseq,
			Model model) {
		Friend friend = service.SelectOne(fseq);
		model.addAttribute("friend",friend);
		return "updateFriend" ; // 여기서 뭔가 이상하니까 잠만 둬보자
	}
	/**
	 * 전달받은 정보를 수정하기 휘한 요청(DM 까지 전달해야함)
	 * @param fseq
	 * @param model
	 * @return
	 */
	@PostMapping("/updateOne")
	public String updateFriend(
			@ModelAttribute Friend friend) {
		service.updateOne(friend) ; 

		return "redirect:/listFriend" ; // 브라우저에게 목록을 다시 요청하도록 지시 !!
	}


}
