package kr.or.ddit.user.respository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.user.model.EmpVo;

public class EmpDao implements EmpDaoI{

	@Override
	public List<EmpVo> selectAllEmp() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<EmpVo> empList = sqlSession.selectList("emps.selectAllEmp");
		
		sqlSession.close();
		
		return empList;
	}

	@Override
	public EmpVo selectEmp(int empno) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		EmpVo emp = sqlSession.selectOne("emps.selectEmp", empno);
		
		return emp;
	}

	@Override
	public List<EmpVo> selectPagingEmp(PageVo vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<EmpVo> empList = sqlSession.selectList("emps.selectPagingEmp", vo);
		
		//사용할 자원 반환
		sqlSession.close();
		
		return empList;
	}

	@Override
	public int selectAllEmpCnt() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int empCnt = sqlSession.selectOne("emps.selectAllEmpCnt");
		
		sqlSession.close();
		return empCnt;
	}

	@Override
	public int modifyEmp(EmpVo empVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int updateCnt = sqlSession.update("emps.modifyEmp", empVo);
		
		if(updateCnt==1) {
			sqlSession.commit();
		}
		else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return updateCnt;
	}

	@Override
	public int registEmp(EmpVo empVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int regisCnt = sqlSession.update("emps.registEmp", empVo);
		
		if(regisCnt==1) {
			sqlSession.commit();
		}
		else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return regisCnt;
	}
	
}
