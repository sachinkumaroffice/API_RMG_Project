package Parameters;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import genericUtility.Java_Utility;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class FormParameter {

	@Test
	public void formPAram() {
		
		given().formParam("createdBy", "sachinkumar")
		.formParam("projectName", "SIS"+ new Java_Utility().getRanDomNumber())
		.formParam("status", "completed")
		.formParam("teamSize", 43)
		
		.when().post("http://rmgtestingserver:8084/addProject")
		.then().assertThat().time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS).log().all();
	}
}
