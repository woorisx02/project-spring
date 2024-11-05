package org.bookrental.admin.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.bookrental.user.vo.AddressVO;
import org.bookrental.user.vo.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public class AdminMemberPersistenceImpl implements AdminMemberPersistence {
	
	@Inject
	private SqlSession sql;
	
	private static String namespace = "org.admin.mappers.member";
	
	@Override
	public MemberVO idCheck(String user_id) throws Exception {
		//System.out.println("========== Repository user_id : "+user_id);
		return sql.selectOne(namespace + ".idcheck", user_id);
	}
	
	@Override
	public MemberVO nickCheck(String user_nickname) throws Exception {
		//System.out.println("========== Repository user_nickname : "+user_nickname);
		return sql.selectOne(namespace + ".nickcheck", user_nickname);
	}
	
	@Override
	public List<AddressVO> getAddrList(AddressVO addr) throws Exception {
		//System.out.println("========== Repository AddressVO : "+addr);
		return sql.selectList(namespace + ".address", addr);
	}

	@Override
	public int insertMember(MemberVO member) throws Exception {
		//System.out.println("========== Persistence member name : "+member.getUser_zipcode());
		//System.out.println("========== Persistence member name : "+member.getUser_address());
		return sql.insert(namespace + ".register", member);
	}

	

	

	

}















