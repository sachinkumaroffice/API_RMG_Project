package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.Excel_Utility;
import genericUtility.File_Utility;
import genericUtility.IPathConstants;
import genericUtility.Java_Utility;
import genericUtility.WebDriver_Utility;
import objectRepository.RMGYantra_Home_Page;
import objectRepository.RMGYantra_LogIn_Page;
import objectRepository.RMGYantra_Projects_Page;

public class createProject {
	WebDriver driver;

	@Test
	public void create() throws Throwable {
		Excel_Utility eu = new Excel_Utility();
		File_Utility fu = new File_Utility();
		Java_Utility ju = new Java_Utility();
		WebDriver_Utility wu = new WebDriver_Utility();
		driver = new ChromeDriver();
		driver.get(IPathConstants.URL);
		wu.maximizeBrowserWindow(driver);
		RMGYantra_LogIn_Page logIn = new RMGYantra_LogIn_Page(driver);
		logIn.loginToRMG(driver, wu, fu);
		RMGYantra_Home_Page homePage = new RMGYantra_Home_Page(driver);
		homePage.clickOnProjects(wu, driver);
		RMGYantra_Projects_Page projectsPage = new RMGYantra_Projects_Page(driver);
		projectsPage.clickOnCreateProject(wu, driver);
	}
}
