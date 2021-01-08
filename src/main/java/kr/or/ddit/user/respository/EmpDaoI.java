package kr.or.ddit.user.respository;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.EmpVo;

public interface EmpDaoI {
	
	//전체 사용자 정보 조회
	
	List<EmpVo> selectAllEmp();

	//userid에 해당하는 사용자 한명의 정보 조회
	EmpVo selectEmp(int empno);
	
	//페이징처리
	List<EmpVo> selectPagingEmp(PageVo vo);
}
