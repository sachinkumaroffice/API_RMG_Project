package pojoclass;

public class EmployeeWithObject {

	//step1: Declare the variables globally
	String ename;
	String id;
	int[] phoneNumber;
	Spouse spouse;
	
	//step2: create the constructor to initialise the variables
	public EmployeeWithObject(String ename, String id, int[] phoneNumber, Spouse spouse) {
		super();
		this.ename = ename;
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.spouse = spouse;
	}
	
	//step3: create an empty constructor in order to trigger for serialisation and the deserialisation
	public EmployeeWithObject() {
		
	}

	//step4: provide the getters and the setters
	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int[] getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int[] phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Spouse getSpouse() {
		return spouse;
	}

	public void setSpouse(Spouse spouse) {
		this.spouse = spouse;
	}
	
	
}
