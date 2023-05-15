package serialisation;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoclass.Employee;

public class EmployeeDeserialisation {

	@Test
		public void employeeDesn() throws Throwable {
			
			ObjectMapper omap = new ObjectMapper();
			Employee data = omap.readValue(new File("./emp.json"), Employee.class);
			System.out.println(data.getEname());
			System.out.println(data.getPhoneNo());
			System.out.println(data.getAge());
		}
	}

 
