package validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GET {

	@Test
	public void get() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		Response response = when().get("/projects/TY_PROJ_20533");
		
		ResponseBody responseBody = response.getBody();
		ResponseBody peek = responseBody.peek();
		//System.out.println(peek);
		//System.out.println(responseBody);  ---- It will Print the address of the object
		String body = responseBody.asPrettyString();
		System.out.println(body);
		
		ResponseBody responseBody1 = response.body();
		System.out.println(responseBody1);
	}
}
