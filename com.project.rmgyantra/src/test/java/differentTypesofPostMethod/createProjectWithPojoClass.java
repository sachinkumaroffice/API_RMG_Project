package differentTypesofPostMethod;

import genericUtility.Java_Utility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import pojoclass.addProject;

public class createProjectWithPojoClass {

	
	public void pojoClass() {
		
		
		addProject pojo = new addProject("sachinkumar.Biradar", "SIS"+ new Java_Utility().getRanDomNumber(), "Completed", 23);
		baseURI = "http://rmgtestingserver";
		port = 8084;
		given().body(pojo).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS).log().all(); 
	}
}
