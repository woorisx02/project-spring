package org.bookrental.admin.service;

import javax.inject.Inject;

import org.bookrental.admin.persistence.AdminConfirmPersistenceImpl;
import org.bookrental.user.vo.MemberVO;
import org.springframework.stereotype.Service;

@Service
public class AdminConfirmServiceImpl implements AdminConfirmService {
	
	@Inject
	private AdminConfirmPersistenceImpl persistence;

	@Override
	public MemberVO login(MemberVO mvo)  throws Exception{
		return persistence.login(mvo);
	}

}















