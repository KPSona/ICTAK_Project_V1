package org.ict.pages;

import java.time.Duration;

import org.ict.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsReg extends TestBase{
	WebDriver driver;

	public  ContactUsReg(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@href,'LandingPage/contactus')]")
	WebElement contactBtn;
	@FindBy(name = "name")
	WebElement contName;
	@FindBy(xpath="//input[@type='email' and @name='email']")
	WebElement contEmail;
	@FindBy(name = "coursename")
	WebElement contCoursename;
	@FindBy(id = "message")
	WebElement contMsg;
	@FindBy(xpath = "//button[contains(text(),'Send Message')]")
	WebElement sendMasBtn;

	public String contactForm(String name, String email, String course, String msg) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));		
		contactBtn.click();
		String alrtmsg ="";
		contName.sendKeys(name);
		contEmail.sendKeys(email);
		contCoursename.sendKeys(course);
		contMsg.sendKeys(msg);		

		if(sendMasBtn.isEnabled()) {
			Actions actions = new Actions(driver);
			actions.moveToElement(sendMasBtn).click().perform();
			alrtmsg= driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();

		}
		return alrtmsg;

	}
	
	public boolean blnkcontactform(String name, String email, String course, String msg) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(contactBtn));
		contactBtn.click();
		contName.sendKeys(name);
		contEmail.sendKeys(email);
		contCoursename.sendKeys(course);
		contMsg.sendKeys(msg);
		return sendMasBtn.isEnabled();		

	}
}
