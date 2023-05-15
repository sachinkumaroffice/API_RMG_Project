package differentTypesofPostMethod;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class createProjectByJSONFile {

	@Test
	public void jsonFile() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		File file = new File("./JSONFile.json");
		given().body(file).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS).statusCode(201).contentType(ContentType.JSON).log().all();
	}
}
