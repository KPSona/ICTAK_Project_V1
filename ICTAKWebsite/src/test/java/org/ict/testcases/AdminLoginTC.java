package org.ict.testcases;

import org.ict.base.TestBase;
import org.ict.pages.AdminLoginPage;
import org.ict.pages.DashBoardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.AutomationConstants;


public class AdminLoginTC extends TestBase {
	AdminLoginPage adminloginpage=null;
	DashBoardPage dashboardPage=null;
	@Test (priority = 3)
	public void validAdLogin() throws InterruptedException {
		adminloginpage= new AdminLoginPage(driver);
		//dashboardPage = new DashBoardPage(driver);
		adminloginpage.loginBtn();
		adminloginpage.userName(prop.getProperty("username"));
		adminloginpage.password(prop.getProperty("password"));
		adminloginpage.sgnBtn();
		String actualResult = adminloginpage.getHome();		
		Assert.assertEquals(actualResult, AutomationConstants.ExpectedHome);
		System.out.println("valid");
		Thread.sleep(50000);
		
		
	}
	@Test (priority = 2)
	public void invalidAdLogin() {
		adminloginpage= new AdminLoginPage(driver);
		//dashboardPage = new DashBoardPage(driver);
		adminloginpage.loginBtn();
		adminloginpage.inUserName(prop.getProperty("inusername"));
		adminloginpage.inPassword(prop.getProperty("inpassword"));
		adminloginpage.sgnBtn();
		
		
	}
	@Test (priority = 1)
	public void blankAdLogin() {
		adminloginpage= new AdminLoginPage(driver);
		//dashboardPage = new DashBoardPage(driver);
		adminloginpage.loginBtn();
		adminloginpage.bUserName(prop.getProperty("busername"));
		adminloginpage.bPassword(prop.getProperty("bpassword"));
		adminloginpage.sgnBtn();
		
		
	}
	

}

