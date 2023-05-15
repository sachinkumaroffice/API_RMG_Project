package validation;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
public class Header_Validation {
	@Test
	public void hraderValidation() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		String expected_statusLine = "HTTP/1.1 200 ";
		String expected_Vary = "Access-Control-Request-Headers";
		String expected_contentType = "application/json";
		String expected_pragma = "no-cache";
		String expected_Connection = "keep-alive";
		
		Response response = when().get("/projects/TY_PROJ_20533");
		ResponseBody body = response.body();
		System.out.println(body.asPrettyString());
		
		Headers headers = response.getHeaders();
		System.out.println(headers);
		
		String statusLine = response.statusLine();
		Assert.assertEquals(statusLine, expected_statusLine);
		String actual_Vary = response.getHeader("Vary");
		Assert.assertEquals(actual_Vary, expected_Vary);
		String actual_contentType = response.getHeader("Content-Type");
		Assert.assertEquals(actual_contentType, expected_contentType);
		String actual_pragma = response.getHeader("Pragma");
		Assert.assertEquals(actual_pragma, expected_pragma);
		String actual_Connection = response.getHeader("Connection");
		Assert.assertEquals(actual_Connection, expected_Connection);
	}
}
