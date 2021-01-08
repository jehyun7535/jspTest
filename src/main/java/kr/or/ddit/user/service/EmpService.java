package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.respository.EmpDao;
import kr.or.ddit.user.respository.EmpDaoI;

public class EmpService implements EmpServiceI{
	
	private EmpDaoI empDao = new EmpDao();
	   
	   @Override
	   public List<EmpVo> selectAllEmp() {
	      return empDao.selectAllEmp();
	   }

	   @Override
	   public EmpVo selectEmp(int empno) {
	      return empDao.selectEmp(empno);
	   }

	   @Override
	   public List<EmpVo> selectPagingEmp(PageVo vo) {
	      return empDao.selectPagingEmp(vo);
	   
	}
}
