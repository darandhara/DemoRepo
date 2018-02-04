package com.rave.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rave.qa.base.TestBase;


public class LoginPage extends TestBase{
	
	//Page Factory - OR
	//@FindBy(id="login:usernameDecorate:username")
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//button[contains(text(), 'Sign Up')]")
	WebElement SignupBtn;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement crmLogo;
	
	//Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String  pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		//LoginBtn.click();
		//return new HomePage();
		Actions actions = new Actions(driver);
		actions.moveToElement(LoginBtn).click().perform();
		return new HomePage();
		
	}
	

}
