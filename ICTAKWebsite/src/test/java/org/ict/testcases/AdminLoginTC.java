package org.ict.testcases;

import java.io.File;
import java.time.Duration;

import org.ict.base.TestBase;
import org.ict.pages.AdminLoginPage;
import org.ict.pages.CourseReg;
import org.ict.pages.DashBoardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import constants.AutomationConstants;


public class AdminLoginTC extends TestBase {
	AdminLoginPage adminloginpage;	
	CourseReg courserg;
	String actualResult = "";
	String signinbtn = "";

	@BeforeClass
	public void classSetup() {
		adminloginpage = new AdminLoginPage(driver);		
		courserg = new CourseReg(driver);
		adminloginpage =new AdminLoginPage(driver);

	}

	/*--------TC 14 Enter valid login credentials--------*/

	@Test(priority = 3)	
	public void validAdLogin() throws InterruptedException {
		driver.navigate().refresh();		
		adminloginpage.loginBtn();
//		adminloginpage.userName(prop.getProperty("username"));
//		adminloginpage.password(prop.getProperty("password"));
		adminloginpage.userName("superadmin");
		adminloginpage.password("12345");
		adminloginpage.sgnBtn();
		actualResult = adminloginpage.getDashbord();		
		Assert.assertEquals(actualResult, AutomationConstants.ExpectedHome);	
		System.out.println(actualResult+": Valid Login completed"); 
		downloadExcel();
	}
	
	/*--------TC 14 Enter invalid login credentials--------*/

	@Test(priority = 1)
	public void invalidAdLogin() {
		driver.navigate().refresh();	
		adminloginpage.loginBtn();
		//		adminloginpage.inUserName(prop.getProperty("inusername"));
		//		adminloginpage.inPassword(prop.getProperty("inpassword"));
		adminloginpage.inUserName("superadmin");
		adminloginpage.inPassword("123");

		adminloginpage.sgnBtn();
		actualResult = adminloginpage.alertMessage();		
		Assert.assertEquals(actualResult, AutomationConstants.ExpectedErrMsg);
		System.out.println(actualResult+": Invalid Login completed"); 

	}
	/*--------TC 14 Empty Fields Validation --------*/

	@Test(priority = 2)
	public void blankAdLogin() {
		driver.navigate().refresh();		
		adminloginpage.loginBtn();
		//adminloginpage.bUserName(prop.getProperty("busername"));
		//adminloginpage.bPassword(prop.getProperty("bpassword"));

		adminloginpage.bUserName(" ");
		adminloginpage.bPassword(" ");
		adminloginpage.sgnBtn();		
		signinbtn = adminloginpage.blankFldAlert();
		Assert.assertEquals(signinbtn, AutomationConstants.ExpectedDisabled);
		System.out.println(signinbtn+": Blank field login completed"); 
	}
	
	public void downloadExcel() throws InterruptedException {
		System.out.println("download excel");
		driver.navigate().refresh();				
		adminloginpage.adminExcelDownload();		
		String downloadDir = System.getProperty("user.home") + "\\Downloads";
		String expectedFileName = "ExcelSheet.xlsx";
		File downloadedFile = new File(downloadDir + "/" + expectedFileName);
		int waitTime = 30; 
		int elapsedTime = 0;
		while (!downloadedFile.exists() && elapsedTime < waitTime) {
			Thread.sleep(1000);
			elapsedTime++;
		}

		if (downloadedFile.exists()) {
			System.out.println("File downloaded successfully: " + downloadedFile.getAbsolutePath());
		} else {
			System.out.println("Failed to download the file within the specified time.");
		}
		Assert.assertTrue(downloadedFile.exists(), "The file was  downloaded successfully.");

	}


}

