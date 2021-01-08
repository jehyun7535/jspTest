package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.respository.EmpDao;
import kr.or.ddit.user.respository.EmpDaoI;
import kr.or.ddit.user.service.EmpService;
import kr.or.ddit.user.service.EmpServiceI;

public class EmpDaoTest {
	
	@Test
	public void selectAllEmpTest() {
		/*** Given ***/
		EmpDaoI empDao = new EmpDao();

		/*** When ***/
		List<EmpVo> empList = empDao.selectAllEmp();

		/*** Then ***/
		assertEquals(16, empList.size());
	}
	
	@Test
	public void selectEmpTest() {
		/***Given***/
		EmpDaoI empDao = new EmpDao();
		int empno = 7369;

		/***When***/
		EmpVo user = empDao.selectEmp(empno);
		
		/***Then***/
		assertNotNull(user);
		assertEquals("SMITH", user.getEname());
		
	}
	
	//사용자 아이디가 존재하지 않을 때, 특정 사용자 조회
	@Test
	public void selectEmpNotExsistTest() {
		/***Given***/
		EmpServiceI empService = new EmpService();
		int empno = 7369;

		/***When***/
		EmpVo user = empService.selectEmp(empno);
		
		/***Then***/
		assertNotNull(user);

	}
	
	//사용자 페이징 조회 테스트
	@Test
	public void selectPagingUserTest() {
		/***Given***/
		EmpDaoI empDao = new EmpDao();
		PageVo vo = new PageVo(2, 5);
		
		/***When***/
		List<EmpVo> empList = empDao.selectPagingEmp(vo);
		
		/***Then***/
		assertEquals(5, empList.size());
	}
	
}
