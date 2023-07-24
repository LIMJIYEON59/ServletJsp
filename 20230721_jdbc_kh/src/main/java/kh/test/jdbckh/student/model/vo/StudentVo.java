package kh.test.jdbckh.student.model.vo;

import java.sql.Date;

public class StudentVo {
//	------------------ -------- ------------- 
//	STUDENT_NO         NOT NULL VARCHAR2(10)  
//	DEPARTMENT_NO      NOT NULL VARCHAR2(10)  
//	STUDENT_NAME       NOT NULL VARCHAR2(40)  
//	STUDENT_SSN                 VARCHAR2(14)  
//	STUDENT_ADDRESS             VARCHAR2(200) 
//	ENTRANCE_DATE               DATE          
//	ABSENCE_YN                  CHAR(1)       
//	COACH_PROFESSOR_NO          VARCHAR2(20)
	
	//자바:클래스 이름 빼고 다 소문자, 언더바 대신 카멜기법 
	private String studentNO;
	private String departmentNO;
	private String studentName;
	private String studentSsn;
	private String studentAddress;
	private Date entranceDate; //date라고 쓰고 java sql을 써야한다.
	private String absenceYn; //CHAR불편 걍 String 쓰삼
	private String coachProfessorNo;
	private String departmentName;
	@Override
	public String toString() {
		return "StudentVo [studentNO=" + studentNO + ", departmentNO=" + departmentNO + ", studentName=" + studentName
				+ ", studentSsn=" + studentSsn + ", studentAddress=" + studentAddress + ", entranceDate=" + entranceDate
				+ ", absenceYn=" + absenceYn + ", coachProfessorNo=" + coachProfessorNo + ", departmentName="
				+ departmentName + "]";
	}
	public String getStudentNO() {
		return studentNO;
	}
	public void setStudentNO(String studentNO) {
		this.studentNO = studentNO;
	}
	public String getDepartmentNO() {
		return departmentNO;
	}
	public void setDepartmentNO(String departmentNO) {
		this.departmentNO = departmentNO;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentSsn() {
		return studentSsn;
	}
	public void setStudentSsn(String studentSsn) {
		this.studentSsn = studentSsn;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public Date getEntranceDate() {
		return entranceDate;
	}
	public void setEntranceDate(Date entranceDate) {
		this.entranceDate = entranceDate;
	}
	public String getAbsenceYn() {
		return absenceYn;
	}
	public void setAbsenceYn(String absenceYn) {
		this.absenceYn = absenceYn;
	}
	public String getCoachProfessorNo() {
		return coachProfessorNo;
	}
	public void setCoachProfessorNo(String coachProfessorNo) {
		this.coachProfessorNo = coachProfessorNo;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
	
	
	
}