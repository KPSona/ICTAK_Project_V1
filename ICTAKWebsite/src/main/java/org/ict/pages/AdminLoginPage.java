package org.ict.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
public class AdminLoginPage {
	WebDriver driver;
	public  AdminLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginBtn() {
		WebElement loginbtn = driver.findElement(By.xpath("//*[@class='btn btn-sm bg-gradient-info mb-0 me-1 mt-2 mt-md-0']"));
		System.out.println("loginhere");
		loginbtn.click();
	}
	
	public void userName(String usrname) {
		
		WebElement uname = driver.findElement(By.name("email"));
		//System.out.println("loginhere12");
		uname.sendKeys(usrname);
	}
	public void password(String passwd) {
		WebElement pw = driver.findElement(By.name("password"));
		pw.sendKeys(passwd);
	}
	
	public void inUserName(String usrname) {
		
		WebElement uname = driver.findElement(By.name("email"));
		//System.out.println("loginhere12");
		uname.sendKeys(usrname);
	}
	public void inPassword(String passwd) {
		WebElement pw = driver.findElement(By.name("password"));
		pw.sendKeys(passwd);
	}
	public void bUserName(String usrname) {
		
		WebElement uname = driver.findElement(By.name("email"));
		//System.out.println("loginhere12");
		uname.sendKeys(usrname);
	}
	public void bPassword(String passwd) {
		WebElement pw = driver.findElement(By.name("password"));
		pw.sendKeys(passwd);
	}
	
	public void sgnBtn() {
		WebElement sgbtn = driver.findElement(By.xpath("//*[@id='exampleModalForm']//child::button"));
		sgbtn.click();
	}
public  String getHome() {
		
		WebElement txt=driver.findElement(By.xpath("//*[@id='navbarBlur']//child::h4"));
		String actres=txt.getText();
		return actres;
		}

}
