package com.qa.he.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.he.baseclass.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//*[@id=\"app\"]/div/div/div[1]/div[2]/a[2]/p")
	WebElement profilebtn;
	@FindBy(xpath="//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div/img")
	WebElement edit1;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String verifiPageTitle() {
		return driver.getTitle();
	}
	public ProfilePage Profilelink() {
		profilebtn.click();
		return new ProfilePage();
	}
	public void editpersonalDetails() {
		edit1.click();
	}
}