 package differentTypesofPostMethod;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class createProjectWithExternalFile {

	
	@Test
	public void project() {
		File file = new File("C:/Users/USER/Desktop/json_object.json");
		baseURI = "http://rmgtestingserver";
		port = 8084;
		given().body(file).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS).contentType(ContentType.JSON).log().all();
	}
}
