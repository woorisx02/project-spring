package org.bookrental.admin.persistence;

import java.util.List;

import org.bookrental.user.vo.AddressVO;
import org.bookrental.user.vo.MemberVO;

public interface AdminMemberPersistence {
	
	public MemberVO idCheck(String user_id) throws Exception;
	
	public MemberVO nickCheck(String user_nickname) throws Exception;
	
	public List<AddressVO> getAddrList(AddressVO addr) throws Exception;
	
	public int insertMember(MemberVO member) throws Exception;

}
