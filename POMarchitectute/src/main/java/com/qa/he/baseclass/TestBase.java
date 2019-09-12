package com.qa.he.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.he.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties props;

	public TestBase() {
		try {
			props=new Properties();
			FileInputStream ip = new FileInputStream("D:\\POMarchitectute\\src\\main\\java\\com"+"\\qa\\config\\config.properties");
			props.load(ip);;
		}
		catch(FileNotFoundException e){
			e.printStackTrace();

		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = props.getProperty("browser");
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")){
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.get(props.getProperty("url"));
	}

}
