package org.ict.pages;

import java.time.Duration;
import java.util.List;

import org.ict.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CourseReg extends TestBase{
	WebDriver driver;
	WebDriverWait wait;
	public  CourseReg(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(40));
	}

	@FindBy(id="dropdownMenuBlocks")
	WebElement courses;	
	@FindBy(xpath ="//*[@id='navigation']//li[3]/ul/div[1]/li[2]/a//h6")
	WebElement dropdnlist;
	@FindBy(xpath = "//button[contains(text(),'Apply Now')]")
	WebElement applyBtn;
	@FindBy(name = "name")
	WebElement regName;
	@FindBy(xpath = "//input[@type='email' and @name='email']")
	WebElement regEmail;
	@FindBy(name ="phoneno" )
	WebElement regPhno;
	@FindBy(name = "courseAmount")
	WebElement regAmt;
	@FindBy(xpath="//button[contains(text(),'Register')]")
	WebElement register;
	@FindBy(id="listSearch")
	WebElement listSearch;		
	@FindBy(xpath = "//button[text()=' Search ' and @class= 'btn bg-gradient-dark w-100 mb-0']")
	WebElement searchBtn;
	@FindBy(xpath = "//section[@class='py-5 bg-gray-100']/div/div[2]/div[1]/div/div/div[2]/div/a/button")
	WebElement knowMoreBtn;
	@FindBy(id="listSearch")
	WebElement inlistSearch;	
	// @FindBy(xpath = "//div[@class='text-center ng-star-inserted']/h5")
	@FindBy(xpath = "//section[@class='py-5 bg-gray-100']/div/div[2]/div/h5")
	WebElement serachInRslt;
	@FindBy(xpath ="//a[contains(@href, '/adminpage/registered-users')]")
	WebElement dashbrdCoursereg;
	@FindBy(xpath = "//button[@class='btn bg-gradient-primary btn-sm mb-0']")
	WebElement downloadbtn;


	public String checkDropdnLst() {
		courses.click();	
		wait.until(ExpectedConditions.textToBePresentInElement(dropdnlist, dropdnlist.getText()));
		String courseReslt=dropdnlist.getText();
		dropdnlist.click();		
		return courseReslt;
	}

	public String courseApplyBtn(String rgName, String rgEmail,  String mobNo, String amt) {
		courses.click();		
		Actions actions = new Actions(driver);
		actions.moveToElement(dropdnlist).click().perform();	
		wait.until(ExpectedConditions.elementToBeClickable(applyBtn));
		applyBtn.click(); 
		regName.sendKeys(rgName);
		regEmail.sendKeys(rgEmail); 
		regPhno.sendKeys(mobNo);
		regAmt.clear();
		regAmt.sendKeys(amt);
		wait.until(ExpectedConditions.elementToBeClickable(register));
		register.click();
		String popupmsg= driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return popupmsg;

	}

	public String searchCourse(String courseName) {
		courses.click();		
		listSearch.sendKeys(courseName);		
		Actions actions = new Actions(driver);
		actions.moveToElement(searchBtn).click().perform();
		actions.moveToElement(knowMoreBtn).click().perform();
		String searchRslt = "success"; 
		return searchRslt;

	}
	
	public String invalidSearchCourse(String cName) {
		courses.click();	
		String searchResult;
		wait.until(ExpectedConditions.visibilityOf(inlistSearch));
		inlistSearch.sendKeys(cName);			 
		Actions actions = new Actions(driver);
		actions.moveToElement(searchBtn).click().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");		 
		searchResult=serachInRslt.getText();
		return searchResult;	 
	}


	/*
	 * public void adminExcelDownload() {
	 * 
	 * wait.until(ExpectedConditions.visibilityOf(dashbrdCoursereg)); Actions
	 * actions = new Actions(driver);
	 * actions.moveToElement(dashbrdCoursereg).click().perform();
	 * downloadbtn.click();
	 * 
	 * 
	 * }
	 */



}
