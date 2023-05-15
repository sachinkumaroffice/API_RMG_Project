package genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.RMGYantra_Home_Page;
import objectRepository.RMGYantra_LogIn_Page;

public class BaseClass {

		public Database_Utility dLib = new Database_Utility();
		public RestAssuredLibrary rLib=new RestAssuredLibrary();
		public WebDriver_Utility wLib = new WebDriver_Utility();
		public File_Utility fLib = new File_Utility();
		public Java_Utility jLib = new Java_Utility();
		public Excel_Utility eLib = new Excel_Utility();
		
		
		
		public WebDriver driver;
	
		@BeforeSuite
	public void connectDB() throws Throwable {
		dLib.connectToDB();
		System.out.println("Connected to Database Successfully");
	}
		@BeforeClass
		public void launchBrowser() {
			 driver = new ChromeDriver();
			wLib.maximizeBrowserWindow(driver);
			wLib.implicitlyWait(driver, 10);
			driver.get(IPathConstants.URL);
		}
		
		
		@BeforeMethod
		public void login() throws Throwable {
			RMGYantra_LogIn_Page loginPage = new RMGYantra_LogIn_Page(driver);
			loginPage.loginToRMG(driver, wLib);
		}
		
		@AfterMethod
		public void logout() {
			RMGYantra_Home_Page homePage = new RMGYantra_Home_Page(driver);
			homePage.logOut(wLib, driver);
		}
	
		@AfterClass
		public void closeBrowser() {
			driver.quit();
		}
		
		@AfterSuite
	public void disconnectFromDB() throws Throwable {
		dLib.disconnectFromDB();
		System.out.println("Disconnected from database successfully");
	}
}
