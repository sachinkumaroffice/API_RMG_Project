package differentTypesofPostMethod;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.Java_Utility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class createProjectWithJSONObject {
	
		@Test
		public void jsonObject() {
	
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("createdBy", "sachinkumar.biradar");
			jsonObject.put("projectName", "SIS"+ new Java_Utility().getRanDomNumber());
			jsonObject.put("status", "TO-DO");
			jsonObject.put("teamSize", 80);
			
			baseURI = "http://rmgtestingserver";
			port = 8084;
			given().body(jsonObject).contentType(ContentType.JSON)
			.when().post("/addProject")
			.then().assertThat().statusCode(201).time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS).contentType(ContentType.JSON).log().all();
}
}
