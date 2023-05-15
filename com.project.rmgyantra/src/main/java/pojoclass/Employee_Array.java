package pojoclass;

public class Employee_Array {

	//Step01: Create variables globally
	String ename;
	String eid;
	int[] ph;
	
	//Step02: Create a constructor to initialise the variables
	public Employee_Array(String ename, String eid, int[] ph) {
		super();
		this.ename = ename;
		this.eid = eid;
		this.ph = ph;
	}
	
	//step03: create the empty constructor to trigger for the serialisation and desrialisation
	public Employee_Array() {
		
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public int[] getPh() {
		return ph;
	}

	public void setPh(int[] ph) {
		this.ph = ph;
	}
	
	
}
