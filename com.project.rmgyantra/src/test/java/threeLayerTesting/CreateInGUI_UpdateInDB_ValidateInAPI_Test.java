package threeLayerTesting;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import genericUtility.Java_Utility;

public class CreateInGUI_UpdateInDB_ValidateInAPI_Test {

	@Test
	public void guiDBAPI() throws SQLException, Throwable {
		
		//Create Project in presentation layer
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("http://rmgtestingserver:8084");
				driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
				driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Projects"))));
				driver.findElement(By.linkText("Projects")).click();
				driver.findElement(By.xpath("//span[text()='Create Project']")).click();
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='projectName']"))));
				String projectName1 = "SIS"+new Java_Utility().getRanDomNumber();
				System.out.println(projectName1);
				driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectName1);
				//driver.findElement(By.xpath("//input[@name='teamSize']")).sendKeys("20");
				driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("parakram");
				WebElement dropDownOfProjectStatus = driver.findElement(By.xpath("//form[@action='#']//select[@name='status']"));
				Select select = new Select(dropDownOfProjectStatus);
				select.selectByValue("Created");
				driver.findElement(By.xpath("//input[@value='Add Project']")).click();
				Thread.sleep(10000);
				WebElement ele = driver.findElement(By.xpath("//td[text()='"+projectName1+"']"));
				System.out.println(ele.getText());
			    String projectID = driver.findElement(By.xpath("//td[text()='"+projectName1+"']/../td[1]")).getText();
				System.out.println("Project created in GUI successfully");
				driver.quit();
				
				
				//Update the project from the database
				String actual_Project = projectName1;
				Connection con = null;
				int result = 0;
				try {
					Driver driver1 = new Driver();
					DriverManager.registerDriver(driver1);
					con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
					Statement state = con.createStatement();
					String query = "update project set created_By = 'tyss' where project_Name = '"+actual_Project+"';";
					 result = state.executeUpdate(query);
					boolean flag = false;
					if (result == 1) {
						flag = true;
					} 
					if (flag) {
						System.out.println("Project has been updated successfully in Database");
					} else {
						System.out.println("Project has not been updated successfully");
					}
				}
					catch (Exception e) {
						e.printStackTrace();
				}
				finally {
					con.close();
				}
				
				
				//Validate in Business layer
				baseURI = "http://rmgtestingserver";
				port = 8084;
				given()
				.when()
				.get("/projects/"+projectID+"")
				.then().assertThat().statusCode(200).log().all();
				
				System.out.println("project has been validated successfully upon the verification");
				
	}
}
