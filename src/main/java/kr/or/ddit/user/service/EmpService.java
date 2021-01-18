package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.model.UserVo;
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
	   public Map<String, Object> selectPagingEmp(PageVo vo) {
		   Map<String, Object> map = new HashMap<String, Object>();
		   List<EmpVo> empList = empDao.selectPagingEmp(vo);
		   
		   int empCnt = empDao.selectAllEmpCnt();
		   
		   map.put("empList", empList);
		   map.put("empCnt", empCnt);
		   
	      return map;
	   
	}

	@Override
	public int modifyEmp(EmpVo empVo) {
		return empDao.modifyEmp(empVo);
	}

	@Override
	public int registEmp(EmpVo empVo) {
		return empDao.registEmp(empVo);
	}
}
