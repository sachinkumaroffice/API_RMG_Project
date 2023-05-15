package practice;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class WriteResponseInJSONfile_Test {

	@Test
	public void responseBody() {
		
		 given()
		.when()
		.get("https://www.google.com/")
		.then().log().cookies().log().headers();
		
//		Headers headers = response.getHeaders();
//		for (Header header : headers) {
//			System.out.println(header);
//		}
		
//		String Date_value = response.getHeader("Date");
//		String Expires_value = response.getHeader("Expires");
//		String Content_value = response.getHeader("Cache-Control");
//		String Content_Type_value = response.getHeader("Content-Type");
//		String Content_Encoding_value = response.getHeader("Content-Encoding");
//		String Server_value = response.getHeader("Server");
//		
//		System.out.println(Date_value);
//		System.out.println(Expires_value);
//		System.out.println(Content_value);
//		System.out.println(Content_Type_value);
//		System.out.println(Content_Encoding_value);
//		System.out.println(Server_value);
		
		
		
	}
}
