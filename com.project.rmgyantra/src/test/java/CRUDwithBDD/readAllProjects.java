package CRUDwithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class readAllProjects {

	@Test
	public void readProjects() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		when().get("/projects")
		.then().assertThat().time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS).statusCode(200).contentType(ContentType.JSON).log().all();
	}
}
