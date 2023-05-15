package pojoclass;

public class Employee {

	//Step:1 Create variables globally
	String ename;
	long phoneNo;
	int age;
	
	//Step2: Create Constructor to initialise the variables
	public Employee(String ename, long phoneNo, int age) {
		super();
		this.ename = ename;
		this.phoneNo = phoneNo;
		this.age = age;
	}
	
	//Step3: Create Empty Constructor, to trigger the execution of serialisation and deserialisation
	public Employee()
	{
		
	}
	
	//Step4: Provide getters and Setters
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
