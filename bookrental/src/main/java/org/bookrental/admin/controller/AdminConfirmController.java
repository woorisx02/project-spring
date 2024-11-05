package org.bookrental.admin.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.bookrental.admin.service.AdminConfirmServiceImpl;
import org.bookrental.user.vo.MemberVO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/confirm/*")
public class AdminConfirmController {
	
	@Inject
	private AdminConfirmServiceImpl service;
	
	@Inject
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	// 로그인 화면 처리
	@GetMapping("/login")
	public void login() throws Exception {}
	
	// 로그인 데이터 처리
	@PostMapping("/login")
	public String login(MemberVO mvo, HttpSession session, RedirectAttributes rttr) throws Exception {
		// RedirectAttributes 객체는 Model 객체와 동일한 기능을 수행한다. 응답 결과(데이터)를 '일회성'으로 View에 전달한다.
		MemberVO dbMvo = service.login(mvo);
		//mvo 객체에는 user_id와 user_pwd의 값(사용자가 입력폼에 입력한 값)만 저장되어있다.
		//dbMvo 객체에는 사용자가 입력폼에 입력한 아이디값과 동일한 회원의 모든 정보를 데이터베이스에서 얻었다.
		String url = null;
		
		if (dbMvo != null) { //아이디 값이 데이터베이스에 있어 로그인에 성공하면
			//System.out.println("========== 사용자가 입력폼에 입력한 비밀번호 : "+mvo.getUser_pwd());
			//System.out.println("========== 암호화된 비밀번호 : "+dbMvo.getUser_pwd());
			boolean passMatch = bCryptPasswordEncoder.matches(mvo.getUser_pwd(), dbMvo.getUser_pwd());
			//matches()는 첫번째 파라미터값과 두번째 암호화된 파라미터값을 비교해서 같으면 true를 반환하다.
			if (passMatch) { //비밀번호 값이 데이터베이스에 있어 로그인에 성공하면
				session.setAttribute("member", dbMvo);
				//마이페이지에서 사용자의 모든 정보를 브라우저로 출력하므로 모든 정보를 저장하고 있는 객체를 세션에 저장한다.
				url = "redirect:/admin/member/mypage";
			} else { //비밀번호 값이 데이터베이스에 없어 로그인에 실패하면
				session.setAttribute("member", null);
				rttr.addFlashAttribute("user_pwd", false);
				url = "redirect:/admin/confirm/login";
			}
		} else { //아이디 값이 데이터베이스 없어 로그인 실패
			session.setAttribute("member", null);
			rttr.addFlashAttribute("user_id", false);
			url = "redirect:/admin/confirm/login";
		}
		
		return url;
	}
	
	// 로그아웃 처리
	@GetMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/admin";
	}
 
}



















