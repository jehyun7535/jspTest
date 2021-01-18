package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.model.UserVo;

public interface EmpServiceI {
	//전체 사원 정보 조회
	
	List<EmpVo> selectAllEmp();

	EmpVo selectEmp(int empno);
	
	//페이징처리
	Map<String, Object> selectPagingEmp(PageVo vo);
	
	int modifyEmp(EmpVo empVo);
	
	int registEmp(EmpVo empVo);
	
}
