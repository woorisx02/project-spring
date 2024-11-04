package org.bookrental.admin.service;

import java.util.List;

import org.bookrental.admin.persistence.AdminMemberPersistenceImpl;
import org.bookrental.user.vo.AddressVO;
import org.bookrental.user.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminMemberServiceImpl implements AdminMemberService {
	
	@Autowired
	private AdminMemberPersistenceImpl persistence;
	
	@Override
	public MemberVO idCheck(String user_id) {
		//System.out.println("========== Service user_id : "+user_id);
		return persistence.idCheck(user_id);
	}
	
	@Override
	public MemberVO nickCheck(String user_nickname) {
		//System.out.println("========== Service user_nickname : "+user_nickname);
		return persistence.nickCheck(user_nickname);
	}
	
	@Override
	public List<AddressVO> getAddrList(AddressVO addr) {
		//System.out.println("========== Service AddressVO : "+addr);
		return persistence.getAddrList(addr);
	}

	@Override
	public int insertMember(MemberVO member) {
		//System.out.println("========== Service member name : "+member.getUser_name());
		return persistence.insertMember(member);
	}

	

	

}















