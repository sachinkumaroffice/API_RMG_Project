package serialisation;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoclass.Employee_Array;

public class EmployeeArray {

	@Test
	public void employeeArraySerialisation() throws Throwable {
		
		int[]phno= {1234,4567};
		Employee_Array emp = new Employee_Array("sachin", "ty", phno);
		ObjectMapper omap = new ObjectMapper();
		omap.writeValue(new File("./emp_array.json"), emp);
	}
}
