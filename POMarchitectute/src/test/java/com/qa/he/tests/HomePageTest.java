package com.qa.he.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.he.baseclass.TestBase;
import com.qa.he.pages.HomePage;
import com.qa.he.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage Loginpage;
	HomePage homepage;
	public HomePageTest() {
		super();
	}
	@BeforeSuite
	public void setup() {
		initialization();
		Loginpage= new LoginPage();
		homepage=Loginpage.login(props.getProperty("username"),props.getProperty("password"));
		
	}
	@Test
	public void verifyPageTitle() {
		String title=homepage.verifiPageTitle();
		Assert.assertEquals(title,"HireEagles");
	}
	@Test
	public void clickprofilelink() {
		homepage.Profilelink();
	}
	@Test
	public void edit(){
		homepage.editpersonalDetails();
		
	}
	
	
}
