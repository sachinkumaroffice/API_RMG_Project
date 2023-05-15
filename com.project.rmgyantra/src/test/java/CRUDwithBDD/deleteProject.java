package CRUDwithBDD;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class deleteProject {

	@Test
	public void deleteProject() {
		
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		when().delete("/projects/TY_PROJ_9531")
		.then().assertThat().time(Matchers.lessThan(3000L), TimeUnit.MILLISECONDS).statusCode(204).log().all();
	}
}
