package org.bookrental.admin.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.bookrental.user.vo.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public class AdminConfirmPersistenceImpl implements AdminConfirmPersistence {
	
	@Inject
	private SqlSession sql; // 데이터베이스 연결+쿼리 수행
	
	private static String namespace = "org.admin.mappers.confirm";

	@Override
	public MemberVO login(MemberVO mvo)  throws Exception{
		return sql.selectOne(namespace+".login", mvo);
	}

}














