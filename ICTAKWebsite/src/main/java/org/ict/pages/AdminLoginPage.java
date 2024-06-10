package org.ict.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bsh.Console;

import org.openqa.selenium.support.FindBy;
public class AdminLoginPage {
	WebDriver driver;
	WebDriverWait wait;
	public  AdminLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	}

	@FindBy(xpath = "//div[@id='navigation']/ul/li[7]/a")
	//@FindBy(xpath = "//div[@id='navigation']//a[text()='Login'")	
	WebElement loginbtn;
	@FindBy(name = "email")
	WebElement uname;
	@FindBy(name = "password")
	WebElement pw;
	@FindBy(xpath ="//*[@id='exampleModalForm']//child::button" )
	WebElement sgbtn;
	@FindBy(xpath = "//*[@id='navbarBlur']//child::h4")
	WebElement txt;
	@FindBy(id = "swal2-title")
	WebElement errMsg;	
	@FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
	//@FindBy(xpath = "//button[contains(@class='confirm')]")
	WebElement okBtn;
	@FindBy(xpath ="//a[contains(@href, '/adminpage/registered-users')]")
	WebElement dashbrdCoursereg;
	@FindBy(xpath = "//button[@class='btn bg-gradient-primary btn-sm mb-0']")
	WebElement downloadbtn;

	public void loginBtn() {		
		System.out.println("login btn");
		wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
		loginbtn.click();
	}

	public void userName(String usrname) {;
	uname.sendKeys(usrname);
	}


	public void password(String passwd) {

		pw.sendKeys(passwd);
	}
	public void inUserName(String usrname) {		
		uname.sendKeys(usrname);
	}

	public void inPassword(String passwd) {

		pw.sendKeys(passwd);

	}	
	public void bUserName(String usrname) {			

		uname.sendKeys(usrname);
	}
	public void bPassword(String passwd) {		
		pw.sendKeys(passwd);
	}
	public void sgnBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(sgbtn));
		if(sgbtn.isEnabled()) {
			sgbtn.click();
		}
		else {
			alertMessage();
		}
	}
	
	public String alertMessage() {
		
		wait.until(ExpectedConditions.textToBePresentInElement(errMsg, errMsg.getText()));
		String adminLognRslt = errMsg.getText();	
		okBtn.click();
		return adminLognRslt;			

	}
	public String blankFldAlert() {
		String blkFldbtn = " ";
		if(sgbtn.isEnabled()) 			
			blkFldbtn="false";
		return blkFldbtn;

	}
	public  String getDashbord() {
		wait.until(ExpectedConditions.textToBePresentInElement(txt, txt.getText()));
		String actres=txt.getText();
		return actres;
	}
	
	public void adminExcelDownload() {

		 wait.until(ExpectedConditions.visibilityOf(dashbrdCoursereg));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(dashbrdCoursereg).click().perform();		
		 downloadbtn.click();
		

	 }

}
