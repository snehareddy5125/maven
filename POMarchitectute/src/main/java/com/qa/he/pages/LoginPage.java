package com.qa.he.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.he.baseclass.TestBase;

public class LoginPage extends TestBase{
	//Page Factory/ObjectRepo
	@FindBy(xpath="/html/body/div/div/div/div[1]/div/a[3]")
	WebElement loginbtn;
	@FindBy(id="loginEmail")
	WebElement username;
	@FindBy(xpath="//*[@id=\"app\"]/div/div/div[2]/form/div[1]/div[2]/input")
	WebElement password;
	@FindBy(xpath="//*[@id=\"app\"]/div/div/div[2]/form/div[2]/button")
	WebElement submit;
	@FindBy(xpath="//*[@id=\"app\"]/div/div/div[2]/form/div[1]/p[1]")
	WebElement text;
	//initializing page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	//actions
	
	public HomePage login(String name,String pass)  {
		loginbtn.click();
		username.sendKeys(name);
		password.sendKeys(pass);
		submit.click();
		return new HomePage();
	}
	public String gerErrorText() {
		return text.getText();
	}
	
}
