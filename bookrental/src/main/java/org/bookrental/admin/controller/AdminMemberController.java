package org.bookrental.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.bookrental.admin.service.AdminMemberServiceImpl;
import org.bookrental.user.vo.AddressVO;
import org.bookrental.user.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/member/*")
public class AdminMemberController {
	
	@Autowired
	private AdminMemberServiceImpl service;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	// 회원등록 화면 처리
	@GetMapping("/register")
	public void join() throws Exception {}
	
	// 아이디 중복 처리
	@PostMapping("/idcheck")
	@ResponseBody // Ajax로 반환값을 전달한다.
	public String idCheck(HttpServletRequest request) throws Exception {
		String user_id = request.getParameter("user_id");
		//System.out.println("========== Presentaion user_id : "+user_id);
		MemberVO mvo = service.idCheck(user_id);
		String result = null;
		
		if (mvo != null) result = "success";
		
		return result;
	}
	
	// 닉네임 중복 처리
	@PostMapping("/nickcheck")
	@ResponseBody
	public String nickCheck(HttpServletRequest request) throws Exception {
		String user_nickname = request.getParameter("user_nickname");
		//System.out.println("========== Presentaion user_nickname : "+user_nickname);
		MemberVO mvo = service.nickCheck(user_nickname);
		String result = null;
		
		if (mvo != null) result = "success";
		
		return result;
	}
	
	// 우편번호 찾기로 우편번호와 주소 목록 화면 처리
	@GetMapping("/reg-address")
	public void getAddrList() throws Exception {}
	
	// 우편번호 찾기로 우편번호와 주소 목록 데이터 처리
	@PostMapping("/reg-address")
	public void getAddrList(AddressVO addr, Model model) throws Exception {
		//System.out.println("========== Presentaion AddressVO : "+addr);
		List<AddressVO> addrList = service.getAddrList(addr);
		model.addAttribute("addrList", addrList);
	}
	
	// 회원등록 데이터 처리
	@PostMapping("/register")
	public String insertMember(MemberVO member, Model model) throws Exception {
		//System.out.println("========== Presentaion member name : "+member.getUser_zipcode());
		//System.out.println("========== Presentaion member name : "+member.getUser_address());
		String pwd = member.getUser_pwd();
		String encodePwd = bCryptPasswordEncoder.encode(pwd);
		member.setUser_pwd(encodePwd);
		//System.out.println("========== Presentaion member pwd : "+encodePwd);
		
		String url = null;
		int result = service.insertMember(member);
		model.addAttribute("member", member);
		
		if (result == 1) {
			url = "redirect:/admin/confirm/login";
		} else {
			url = "/admin/member/insertEx";
		}
		
		return url;
	}
	
	// 마이페이지 화면 처리
	@GetMapping("/mypage")
	public void mypage() throws Exception {}
	
	// 회원목록 화면 처리
	@GetMapping("/list")
	public void getMemberList() {}

}















