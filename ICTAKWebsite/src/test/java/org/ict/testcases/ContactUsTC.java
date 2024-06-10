package org.ict.testcases;

import java.time.Duration;

import org.ict.base.TestBase;
import org.ict.pages.AdminLoginPage;
import org.ict.pages.ContactUsReg;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import constants.AutomationConstants;


public class ContactUsTC extends TestBase{
	ContactUsReg courserg; 

	@BeforeClass
	public void classSetup() {
		courserg = new ContactUsReg(driver);

	}

	/*---------TC-17---Enter valid information and click on Send Message button--------*/

	@Test(priority = 1)
	public void contactDetails() throws InterruptedException{

		String actrslt = courserg.contactForm("Sona","kpson@gmail.com","st","course details");
		Assert.assertEquals(actrslt, AutomationConstants.ExpectedAlrtMsq);
		System.out.println("Valid contact details: "+actrslt);
	}
	
	/*-------------Enter invalid email and click on Send Message button----*/

	@Test(priority = 2)
	public void invContactdetails() throws InterruptedException{
		driver.navigate().refresh();
		String inactrslt = courserg.contactForm("Test","test@gmaico","st","course details");
		Assert.assertNotEquals(inactrslt, AutomationConstants.ExpectedAlrtMsq_inv);
		System.out.println("Invalid contact details: "+inactrslt); 


	}

	/*---------------Empty Fields Validation ---------*/


	@Test(priority = 3) 
	//@AfterClass
	public void blkContactDetails() throws InterruptedException { 
		driver.navigate().refresh();
		Assert.assertFalse(courserg.blnkcontactform(" "," ","st","course details"));		
		System.out.println("Blank field validation.");

	}

}
