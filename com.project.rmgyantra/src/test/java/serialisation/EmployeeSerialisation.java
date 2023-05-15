package serialisation;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoclass.Employee;

public class EmployeeSerialisation {

	@Test
	public void employee() throws Throwable {
		ObjectMapper omap = new ObjectMapper();
		Employee emp = new Employee("Thomas_Shelby", 12345, 26);
		omap.writeValue(new File("./emp.json"), emp);
	}
}
