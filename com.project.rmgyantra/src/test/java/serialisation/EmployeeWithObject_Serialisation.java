package serialisation;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoclass.EmployeeWithObject;
import pojoclass.Spouse;

public class EmployeeWithObject_Serialisation {

	@Test
	public void employeeWithObjectSeri() throws Throwable {
		int[] phno = {76543, 12345};
		Spouse spouse = new Spouse("Anonymous", "xyz123", phno);
		int[] phoneNumber = {1234, 4321};
		EmployeeWithObject emp = new EmployeeWithObject("Sachinkumar.Biradar", "tr290", phoneNumber, spouse);
		ObjectMapper omap = new ObjectMapper();
		omap.writeValue(new File("./emp_with_object.json"), emp);
	}
}
