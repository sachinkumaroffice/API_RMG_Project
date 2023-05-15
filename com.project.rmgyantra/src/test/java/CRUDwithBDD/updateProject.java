package CRUDwithBDD;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.http.ContentType.*;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

public class updateProject {

	@Test
	public void updateProject() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("createdBy", "Sachinkumar Biaradar197");
		jsonObject.put("projectName", "Sales_Inventory_System640");
		jsonObject.put("status", "Reopened");
		jsonObject.put("teamSize", 10);
		
		given().body(jsonObject).contentType(ContentType.JSON)
		.when().put("/projects/TY_PROJ_9531")
		.then().assertThat().time(Matchers.lessThan(3000L), TimeUnit.MILLISECONDS ).statusCode(200).contentType(ContentType.JSON).log().all();
	}
}
