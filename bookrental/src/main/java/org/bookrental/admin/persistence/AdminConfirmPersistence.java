package org.bookrental.admin.persistence;

import org.bookrental.user.vo.MemberVO;

public interface AdminConfirmPersistence {
	
	public MemberVO login(MemberVO mvo) throws Exception;

}
