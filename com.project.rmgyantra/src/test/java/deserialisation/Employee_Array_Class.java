package deserialisation;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoclass.Employee_Array;

public class Employee_Array_Class {

	@Test
	public void employeeArrayDeserialisation() throws Throwable {
		ObjectMapper omap = new ObjectMapper();
		Employee_Array data = omap.readValue(new File("./emp_array.json"), Employee_Array.class);
		System.out.println(data.getEid());
		System.out.println(data.getEname());
		System.out.println(data.getPh()[1]);
		
	}
}
