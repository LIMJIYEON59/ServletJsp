package kh.test.jdbckh.department.model.vo;

public class DepartmentVo {
//	"DEPARTMENT_NO"	VARCHAR2(10)		NOT NULL,
//	"DEPARTMENT_NAME"	VARCHAR2(20)		NOT NULL,
//	"CATEGORY"	VARCHAR2(20)		NULL,
//	"OPEN_YN"	CHAR(1)		NULL,
//	"CAPACITY"	NUMBER		NULL


	private String departmentNo;
	private String departmentName;
	private String Category;
	private String OpenYn;
	private int Capacity;
	@Override
	public String toString() {
		return "DepartmentVo [departmentNo=" + departmentNo + ", departmentName=" + departmentName + ", Category="
				+ Category + ", OpenYn=" + OpenYn + ", Capacity=" + Capacity + "]";
	}
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getOpenYn() {
		return OpenYn;
	}
	public void setOpenYn(String openYn) {
		OpenYn = openYn;
	}
	public int getCapacity() {
		return Capacity;
	}
	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
	
	
	
	
}