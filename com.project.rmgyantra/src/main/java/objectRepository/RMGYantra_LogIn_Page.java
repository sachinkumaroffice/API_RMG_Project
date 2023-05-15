package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.File_Utility;
import genericUtility.IPathConstants;
import genericUtility.WebDriver_Utility;

public class RMGYantra_LogIn_Page {

	
	@FindBy(id = "usernmae")
	private WebElement userNameTF;
	
	@FindBy (id = "inputPassword")
	private WebElement passwordTF;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement signInButton;
	
	@FindBy (xpath = "//button[.='Create Account']")
	private WebElement createAccountButton;
	
	
	public RMGYantra_LogIn_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getUserNameTF() {
		return userNameTF;
	}


	public WebElement getPasswordTF() {
		return passwordTF;
	}


	public WebElement getSignInButton() {
		return signInButton;
	}


	public WebElement getCreateAccountButton() {
		return createAccountButton;
	}
	
	
	//Business Library
	public void loginToRMG(WebDriver driver, WebDriver_Utility wu) throws Throwable {
		wu.visibilityOfElement(userNameTF, driver);
		userNameTF.sendKeys(IPathConstants.Username);
		passwordTF.sendKeys(IPathConstants.password);
		signInButton.click();
	}


	public void loginToRMG(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
}
