package threeLayerTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
import static io.restassured.RestAssured.*;

public class createProjectInUI_VerifyInDB_DeleteInAPI_Test {

	@Test
	public void cAPIdUI() throws Throwable {
		
		//Create Project in the Front End
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
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectName1);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Levant");
		WebElement dropDownOfProjectStatus = driver.findElement(By.xpath("//form[@action='#']//select[@name='status']"));
		Select select = new Select(dropDownOfProjectStatus);
		select.selectByValue("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		Thread.sleep(10000);
			WebElement ele = driver.findElement(By.xpath("//td[text()='"+projectName1+"']"));
			System.out.println(ele.getText());
		String projectID = driver.findElement(By.xpath("//td[text()='"+projectName1+"']/../td[1]")).getText();
		driver.quit();
		
		
		//Fetch the project from the database
				String actual_Project = projectName1;
				Connection con = null;
				try {
					Driver driver1 = new Driver();
					DriverManager.registerDriver(driver1);
					con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
					Statement state = con.createStatement();
					String query = "select * from project"; 
					ResultSet result = state.executeQuery(query);
					boolean flag = false;
					while (result.next()) {
						String existingProject = result.getString(4);
						//System.out.println(createdProject);
					if (actual_Project.equalsIgnoreCase(existingProject)) {
						flag= true;
				}
					}
					if (flag) {
						System.out.println("Project is existing here");
					} else {
						System.out.println("Project is not existing here");
					}
				}
					catch (Exception e) {
						e.printStackTrace();
				}
				finally {
					con.close();
				}
				
		//Delete the project in the Business layer
		baseURI = "http://rmgtestingserver";
		port = 8084;
		when().delete("/projects/"+projectID)
		.then().assertThat().statusCode(204).log().all();
		
		
	
	}
}
