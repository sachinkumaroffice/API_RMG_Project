package CRUDwithBDD;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.Java_Utility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class CreateProject {

	@Test
	public void createProject() {
		
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("createdBy", "Sachinkumar"+ new Java_Utility().getRanDomNumber());
		jsonObject.put("projectName", "Sales_Inventory_System"+ new Java_Utility().getRanDomNumber());
		jsonObject.put("status", "Compketed");
		jsonObject.put("teamSize", 67);
		
		given().body(jsonObject).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS).statusCode(201).contentType(ContentType.JSON).log().all();
		
		
	}
}
