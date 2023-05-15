package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriver_Utility;

public class RMGYantra_Home_Page {

	@FindBy(xpath = "//a[text()='Projects']")
	private WebElement projectsButton;
	
	@FindBy (linkText = "Users")
	private WebElement usersButton;
	
	@FindBy(linkText = "Settings")
	private WebElement settingsButton;
	
	@FindBy(linkText = "Logout")
	private WebElement logOutButton;
	
	public RMGYantra_Home_Page (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProjectsButton() {
		return projectsButton;
	}

	public WebElement getUsersButton() {
		return usersButton;
	}

	public WebElement getSettingsButton() {
		return settingsButton;
	}

	public WebElement getLogOutButton() {
		return logOutButton;
	}
	
	//Business Library
	public void clickOnProjects(WebDriver_Utility wu, WebDriver driver) {
		wu.elementToBeClickable(driver, projectsButton);
		projectsButton.click();
	}
	
	public void logOut(WebDriver_Utility wu, WebDriver driver) {
		wu.elementToBeClickable(driver, logOutButton);
		logOutButton.click();
	}
	
}
