package practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

public class UploadImageInPetstore_Test {

	@Test
	public void image() {
		
		baseURI = "https://petstore.swagger.io/v2";
		
		File file = new File("C:/Users/USER/Downloads/PET1.jpg");
		given()
		.pathParam("petID", 87)
		.multiPart("file", file)
		.contentType("multipart/form-data")
		.when()
		.post("/pet/{petID}/uploadImage")
		
		.then().assertThat().statusCode(200).log().all();
//		
				
		
	}
}
