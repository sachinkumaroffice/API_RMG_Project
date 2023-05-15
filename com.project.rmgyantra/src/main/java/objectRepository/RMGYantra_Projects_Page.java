package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriver_Utility;

public class RMGYantra_Projects_Page {

	
	@FindBy (xpath = "//span[.='Create Project']")
	private WebElement createProjectLink;
	
	
	public RMGYantra_Projects_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getCreateProjectLink() {
		return createProjectLink;
	}
	
	//Business library
	public void clickOnCreateProject(WebDriver_Utility wu, WebDriver driver) {
		wu.elementToBeClickable(driver, createProjectLink);
		createProjectLink.click();
	}
}
