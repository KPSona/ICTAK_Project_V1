package org.ict.testcases;

import java.io.File;
import java.time.Duration;

import org.ict.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import constants.AutomationConstants;

import org.ict.pages.AdminLoginPage;
import org.ict.pages.CourseReg;
import org.ict.testcases.AdminLoginTC;

public class CourseRegTC extends TestBase{
	CourseReg courserg;   
	AdminLoginTC adLogin;
	AdminLoginPage adLgPage;
	@BeforeClass
	public void classSetup() {		
		courserg = new CourseReg(driver);
		adLgPage =new AdminLoginPage(driver);

	}


	/*--------TC 13 courses are displayed in the dropdown list.--------*/

	@Test(priority =1)
	public void checkDropdnList() throws InterruptedException {  
		String courseResult = courserg.checkDropdnLst();
		Assert.assertEquals(courseResult, AutomationConstants.CourseDropdn);
		System.out.println("Assertion completed"); 

	}	

	/* --------TC 13 Valid course Registration form--------*/

	@Test(priority =2)
	public void courseApply() throws InterruptedException
	{		
		String applResult=courserg.courseApplyBtn("Sona","kpson@gmail.com","123456789","300");
		Assert.assertEquals(applResult, AutomationConstants.courseApplyRslt);
		System.out.println("Course Registration completed."); 

	}

	/*--------TC 13 Invalid course Registration form.--------*/

	@Test(priority =3)
	public void invalidCourseApply() throws InterruptedException
	{

		String inApplResult=courserg.courseApplyBtn("Test","test@gmailco","54546","400");			
		Assert.assertNotEquals(inApplResult, AutomationConstants.invalidAplRlt);
		System.out.println("Invalid course registration."); 
	}

	/*--------TC 13 Search filed --------*/

	@Test(priority =4)
	public void searchValidCourse() {
		
		String searchResult =  courserg.searchCourse("Software Testing");

		String searchApplyRslt=courserg.courseApplyBtn("Sona","kpson@gmail.com","123456789","300");
		Assert.assertEquals(searchApplyRslt, AutomationConstants.courseApplyRslt);
		System.out.println(searchResult);
	}

	/*--------TC 13 Enter invalid search details--------*/

	@Test(priority =5)
	public void invalidSearch() {

		String insearchRslt =  courserg.invalidSearchCourse("123AZ");

		Assert.assertEquals(insearchRslt, AutomationConstants.inSrchResult);
		System.out.println("Invalid search"); 
	}


	/*-------- TC 15 Admin login and download excel.--------*/

	//@Test(priority =6)
	//@AfterMethod
	/*public void downloadExcel() throws InterruptedException {
		System.out.println("download excel");
		driver.navigate().refresh();		
		adLgPage.loginBtn();
		adLgPage.userName("superadmin");
		adLgPage.password("12345");
		adLgPage.sgnBtn();				
		courserg.adminExcelDownload();		
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

	}*/

}
