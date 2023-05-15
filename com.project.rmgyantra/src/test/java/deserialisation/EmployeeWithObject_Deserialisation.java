package deserialisation;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoclass.EmployeeWithObject;

public class EmployeeWithObject_Deserialisation {

	@Test
	public void employeeWithObjectDesrn() throws Throwable {
		ObjectMapper omap = new ObjectMapper();
		EmployeeWithObject data = omap.readValue(new File("./emp_with_object.json"), EmployeeWithObject.class);
		System.out.println("Employee name is = "+data.getEname());
		System.out.println("Employee id is = "+data.getId());
		System.out.println("Employee primary phone number is = "+data.getPhoneNumber()[0]);
		System.out.println("Spouse name is = "+data.getSpouse().getName());
		System.out.println("Spouse age is = "+ data.getSpouse().getAge());
		System.out.println("spuse phone number is = " + data.getSpouse().getPhno()[0]);
	}
}
