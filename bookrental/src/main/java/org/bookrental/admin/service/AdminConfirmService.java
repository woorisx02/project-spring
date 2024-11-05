package org.bookrental.admin.service;

import org.bookrental.user.vo.MemberVO;

public interface AdminConfirmService {
	
	public MemberVO login(MemberVO mvo) throws Exception;

}
