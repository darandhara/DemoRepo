package com.rave.qa.testCases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.rave.qa.base.TestBase;
import com.rave.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	Logger log=Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		log.info("Here is the information log of log4j---------->>>>>>>>>Yes");
		log.warn("Here is the warning log of log4j---------->>>>>>>>>Yes");
		log.error("Here is the Error log of log4j---------->>>>>>>>>Yes");
		log.fatal("Here is the fatal log of log4j---------->>>>>>>>>Yes");
		loginPage =new LoginPage();
	}
	
	//@Test(priority=1)
	public void LoginPageTitleTest() {
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		log.info("Here is the information log of log4j---------->>>>>>>>>Yes");
		log.warn("Here is the warning log of log4j---------->>>>>>>>>Yes");
		log.error("Here is the Error log of log4j---------->>>>>>>>>Yes");
		log.fatal("Here is the fatal log of log4j---------->>>>>>>>>Yes");
	}
	
	
	//@Test(priority=2)
	public void crmLogoImageTest() {
		boolean flag=loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	//@Test(priority=3)
	@Test
	public void loginTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
