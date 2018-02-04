package com.rave.qa.testCases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rave.qa.base.TestBase;
import com.rave.qa.pages.ContactsPage;
import com.rave.qa.pages.HomePage;
import com.rave.qa.pages.LoginPage;
import com.rave.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName="Contacts";
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.swithToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	
	//@Test
	//public void trial(){
		//homePage.clickOnNewContactsLink();
		//contactsPage.createNewContacts("Mr.", "John", "Mon","abc");
	//}
	
	@DataProvider()
	public Object[][] getCRMTestData() throws InvalidFormatException{
		Object[][] data=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getCRMTestData")
	public void createCRMContacts(String title, String firstName, String lastName, String company){
		homePage.clickOnNewContactsLink();
		contactsPage.createNewContacts(title, firstName, lastName,company);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
