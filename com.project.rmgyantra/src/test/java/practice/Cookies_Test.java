package practice;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Map;
import java.util.Set;

public class Cookies_Test {

	@Test
	public void getCookies() {
		
		Response response = given()
		.when()
		.get("https://www.google.com/");
		
		Map<String, String> cookies = response.getCookies();
//		System.out.println(cookies);
		
		Set<String> keys = cookies.keySet();
		System.out.println(keys);
		
		for (String key : keys) {
			System.out.println("Value of "+ key +" is = "+(response.getCookie(key)));
		}
		
	}
}
