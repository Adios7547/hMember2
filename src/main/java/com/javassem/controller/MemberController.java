package com.javassem.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.dao.MemberDAO;
import com.javassem.domain.MemberVO;
import com.javassem.service.MemberService;


@Controller
@RequestMapping("/user")
public class MemberController {
	
	@RequestMapping("/{step}.do")
	public String viewPage(@PathVariable String step) {
		return "/user/"+step;
	}
	
	
	@Autowired
	private MemberService memberService;
	
	//*******************
	// ajax는 뷰페이지를 변경하지 않음
	@RequestMapping(value = "idcheck.do", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String idcheck(MemberVO vo) {

		String result = "사용가능한 아이디입니다";
		
		MemberVO remem= memberService.idCheck_Login(vo);
		
		if(remem != null) {
			result = "중복된 아이디 있습니다";		
			}

		return result;
	}

	
	
//	@RequestMapping("userJoin.do")
//	public void userJoin() {
//		
//	}
//	
//	@RequestMapping("userLogin.do")
//	public void userLogin() {
//		
//	}
	
	

	
}
