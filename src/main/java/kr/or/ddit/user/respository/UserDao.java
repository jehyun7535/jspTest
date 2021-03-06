package kr.or.ddit.user.respository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoI{

	@Override
	public List<UserVo> selectAllUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		// select : 리턴되는 값의 복수 유무를 판단
		//		    1. 단건 : 일반객체를 반환(UserVo) selectOne()
		//		    2. 여러건 : List<UserVo> selectList()
		//insert, update, delete : insert, update, delete
		
		// 메소드 이름과 실행할 sql id를 동일하게 맞추자(유지보수-다른 개발자의 가독성)
		
		List<UserVo> userList = sqlSession.selectList("users.selectAllUser");
		
		//사용할 자원 반환
		sqlSession.close();
		
		return userList;
	}

	@Override
	public UserVo selectUser(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
				
		UserVo user = sqlSession.selectOne("users.selectUser", userid);
		
		return user;
	}
	
	@Override
	public List<UserVo> selectPagingUser(PageVo vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
				
		List<UserVo> userList = sqlSession.selectList("users.selectPagingUser", vo);
		
		//사용할 자원 반환
		sqlSession.close();
		
		return userList;
	}

	@Override
	public int selectAllUserCnt() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int userCnt = sqlSession.selectOne("users.selectAllUserCnt");
		
		sqlSession.close();
		return userCnt;
	}

	@Override
	public int modifyUser(UserVo userVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int updateCnt = sqlSession.update("users.modifyUser", userVo);

		if(updateCnt == 1) {
		sqlSession.commit();
		}
		else{
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return updateCnt;
	}

	@Override
	public int registUser(UserVo userVo) {
	SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int registCnt = sqlSession.insert("users.registUser", userVo);

		if(registCnt == 1) {
		sqlSession.commit();
		}
		else{
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return registCnt;
	}

	@Override
	public int deleteUser(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int deleteCnt = sqlSession.delete("users.deleteUser", userid);

		if(deleteCnt == 1) {
			sqlSession.commit();
		}
		else{
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return deleteCnt;
	}
	
}



