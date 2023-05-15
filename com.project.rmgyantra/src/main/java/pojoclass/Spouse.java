package pojoclass;

public class Spouse {

	//step1: Declare the variables globally
	String name;
	String age;
	int[] phno;
	
	//step2: create the constructor to initialise the variables
	public Spouse(String name, String age, int[] phno) {
		super();
		this.name = name;
		this.age = age;
		this.phno = phno;
	}
	
	//step3: Create the empty constructor in order to trigger for the serialisation and desrialisation
	public Spouse() {
		
	}
	
	
	//step4: Provide the getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int[] getPhno() {
		return phno;
	}

	public void setPhno(int[] phno) {
		this.phno = phno;
	}
	
	
	
}
