package Parameters;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class PathParameter {

	@Test
	public void pathParam() {
		
		given().pathParam("PID", "TY_PROJ_9874")
		.when().get("http://rmgtestingserver:8084/projects/{PID}")
		.then().assertThat().statusCode(200).time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS).contentType(ContentType.JSON).log().all();
	}
}
