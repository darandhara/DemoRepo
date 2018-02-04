package com.rave.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rave.qa.base.TestBase;
import com.rave.qa.pages.ContactsPage;
import com.rave.qa.pages.HomePage;
import com.rave.qa.pages.LoginPage;
import com.rave.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"CRMPRO","Page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		testUtil.swithToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void clickOnContactsLinkTest(){
		testUtil.swithToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	
	//@Test(priority=4)
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
