package differentTypesofPostMethod;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import genericUtility.Java_Utility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class craeteProjectWithHashMap {

	@Test
	public void hashMap() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		HashMap hashMap = new HashMap();
		hashMap.put("createdBy", "sachinkumar.biradar");
		hashMap.put("projectName", "SIS"+ new Java_Utility().getRanDomNumber());
		hashMap.put("status", "In-Progress");
		hashMap.put("teamSize", 87);
		
		given().body(hashMap).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS).log().all();
	}
}
