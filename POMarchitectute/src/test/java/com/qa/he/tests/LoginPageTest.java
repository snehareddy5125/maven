package com.qa.he.tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.he.baseclass.TestBase;
import com.qa.he.pages.HomePage;
import com.qa.he.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest() {
		super();
	}

	@BeforeSuite
	public void setup() {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginProps() {
		homepage = loginpage.login(props.getProperty("username"),props.getProperty("password"));
	}
	@Test(priority=2)
	public void getErrors() {
		String text=loginpage.gerErrorText();
		Assert.assertEquals(text, "Invalid Credentials");
		
	}
	@AfterSuite
	public void teardowm() {
		driver.quit();
	}
}
