package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerToken_Delete {

	@Test
	public void delete() {
		baseURI = "https://api.github.com";
		String owner = "sachinkumaroffice";
		String user = "RestAssuredTesting610 ";
		
		given()
		.auth()
		.oauth2("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")
		
		.when()
		.delete("/repos/"+owner+"/"+user)
		
		.then().assertThat().statusCode(204).log().all();
	}
}
