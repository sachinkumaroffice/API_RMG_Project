package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import genericUtility.Excel_Utility;
import genericUtility.Java_Utility;

public class RMGYantra_CreateProject_Page {

	@FindBy (name = "projectName")
	private WebElement projectNameTF;
	
	@FindBy (name = "createdBy")
	private WebElement projectManagerTF;
	
	@FindBy(xpath = "//form[@action='#']//select[@name='status']")
	private WebElement projectStatusDD;
	
	@FindBy (xpath = "//input[@value='Add Project']")
	private WebElement addProjectButton;
	
	@FindBy(xpath = "//form[@action='#']//input[@value='Cancel']")
	private WebElement cancelButton;
	
	public RMGYantra_CreateProject_Page (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProjectNameTF() {
		return projectNameTF;
	}

	public WebElement getProjectManagerTF() {
		return projectManagerTF;
	}

	public WebElement getProjectStatusDD() {
		return projectStatusDD;
	}

	public WebElement getAddProjectButton() {
		return addProjectButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}
	
	//Business Library
	public void createdStatusProject(Excel_Utility eu, Java_Utility ju) throws Throwable {
		String projectName = eu.readDataFromExcelFile("rmgyantra", 3, 0);
		System.out.println(projectName);
		projectNameTF.sendKeys(projectName);
		projectManagerTF.sendKeys(eu.readDataFromExcelFile("rmgyantra", 3, 1));
		Select select = new Select(projectStatusDD);
		select.selectByValue(eu.readDataFromExcelFile("rmgyantra", 3, 2));
		addProjectButton.click();
	}
	
	public void inProgressStatusProject(Excel_Utility eu, Java_Utility ju) throws Throwable {
		projectNameTF.sendKeys(eu.readDataFromExcelFile("rmgyantra", 2, 0)+ju.getRanDomNumber());
		projectManagerTF.sendKeys(eu.readDataFromExcelFile("rmgyantra", 2, 1));
		Select select = new Select(projectStatusDD);
		select.selectByValue(eu.readDataFromExcelFile("rmgyantra", 2, 2));
		addProjectButton.click();
	}
	
	public void completedStatusProject(Excel_Utility eu, Java_Utility ju) throws Throwable {
		projectNameTF.sendKeys(eu.readDataFromExcelFile("rmgyantra", 3, 0)+ju.getRanDomNumber());
		projectManagerTF.sendKeys(eu.readDataFromExcelFile("rmgyantra", 3, 1));
		Select select = new Select(projectStatusDD);
		select.selectByValue(eu.readDataFromExcelFile("rmgyantra", 3, 2));
		addProjectButton.click();
	}
	
}
