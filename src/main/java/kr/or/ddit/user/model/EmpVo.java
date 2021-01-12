package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmpVo {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	public EmpVo() {
		
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public String getHiredate_fmt() {
		//hiredate 필드가 null 이면 "" 문자열 반환
		//hiredate 필드가 null이 아니면 SimpleDateFormat을
		//생성하여 yyyy.mm.dd 포맷의 문자열로 변환하여 리턴
		if(this.hiredate == null) {
			return "";		
		}
		else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			return sdf.format(this.hiredate);
			
			//return new SimpleDateFormat("YYYY.MM.dd").format(this.hiredate);
		}
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
}
