package com.rave.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.rave.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	//Identifying page factory objects
	//@FindBy(name="title")
	//WebElement title;
	
	@FindBy(id="first_name")
	WebElement firstName;
	//@FindBy(xpath="//input[@id='first_name' and name='first_name']")
	//WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement saveButton;
	
	//initializing Web elements
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void createNewContacts(String txt, String first, String last, String comp){
		Select sel=new Select(driver.findElement(By.xpath("//select[@name='title' and @class='select']")));
		sel.selectByVisibleText(txt);
		firstName.sendKeys(first);
		lastName.sendKeys(last);
		company.sendKeys(comp);
		saveButton.click();
	}
	
	

}
