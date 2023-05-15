package CRUDwithBDD;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class readSingleProject {

	@Test
	public void readProject() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		when().get("/projects/TY_PROJ_9531")
		.then().assertThat().time(Matchers.lessThan(3000L), TimeUnit.MILLISECONDS).statusCode(200).contentType(ContentType.JSON).log().all();
		
	}
}
