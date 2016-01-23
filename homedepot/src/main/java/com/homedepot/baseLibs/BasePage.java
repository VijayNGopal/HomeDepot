package com.homedepot.baseLibs;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.homedepot.utilLibs.ScreenShot;
import com.selenium.controllLibs.HomeDepotApps;

public class BasePage{
	protected WebDriver driver;
	private HomeDepotApps homeDepotApps;
	private ScreenShot screenShot;
	//private String browserName;
	
	@Parameters({"browser"})
	@BeforeMethod
	//public void BrowserSetUp(){
	public void BrowserSetUp(@Optional("ff")String browserName) throws Exception{
		if(browserName.contentEquals("ff")){
			File profileDirectory = new File(System.getProperty("user.dir") + "/profile/");
			FirefoxProfile profile = new FirefoxProfile(profileDirectory);
			driver = new FirefoxDriver(profile);
		}
		else if(browserName.contentEquals("ch")) {
			File chromeDriverFile = new File(System.getProperty("user.dir") +  "/driver/32/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", chromeDriverFile.getAbsolutePath());
			driver = new ChromeDriver();
		}
		
		else if(browserName.contentEquals("ie")){
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setJavascriptEnabled(true);
			capabilities.setBrowserName("internet explorer");
			capabilities.setCapability("requireWindowFocus",true);
			//capabilities.setCapability("platform", "WIN8.0");
			//capabilities.setCapability("version", "10");

			//File driverFile = new File("C:/MyDevelopments/EclipseRepository/SeleniumWebDriver05/drivers/IEDriverServer.exe");
			File driverFile = new File(System.getProperty("user.dir") +  "/driver/32/IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", driverFile.getAbsolutePath());
			driver = new InternetExplorerDriver(capabilities);
		}
		
		
	/*	if(browserName.equalsIgnoreCase("firefox"))
		{
		 File profileDirectory = new File(System.getProperty("user.dir")+ "/profile/");
		 FirefoxProfile profile = new FirefoxProfile(profileDirectory);
		 driver = new FirefoxDriver(profile);	
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
		 System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
		 System.setProperty("webdriver.ie.driver", "C:\\drivers\\IEDriverServer.exe");
		 driver = new InternetExplorerDriver();
		}*/
		driver =new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.get("www.homedepot.com/");
		
	
		
	}
	
	@AfterMethod
	public void ShutdownBrowser(){
		//driver.close();
		//driver.quit();
	}
	
	public HomeDepotApps homeDepotApps(){
		if(homeDepotApps == null ){
			homeDepotApps = new HomeDepotApps(driver);
		}
		return homeDepotApps;
		}
	public ScreenShot screenShot(){
		if(screenShot == null){
			screenShot = new ScreenShot(driver);
		}
		return screenShot;
	}
	
	/*
			// We could use any driver for our tests...
			DesiredCapabilities capabilities = new DesiredCapabilities();

			// ... but only if it supports javascript
			capabilities.setJavascriptEnabled(true);

			// Get a handle to the driver. This will throw an exception
			// if a matching driver cannot be located
			WebDriver driver = new RemoteWebDriver(capabilities);

			// Query the driver to find out more information
			Capabilities actualCapabilities = ((RemoteWebDriver) driver).getCapabilities();
	*/
	
	/*ProfilesIni allProfiles = new ProfilesIni();
	FirefoxProfile myProfile = allProfiles.getProfile("default");
	myProfile.setAcceptUntrustedCertificates(true);
	myProfile.setAssumeUntrustedCertificateIssuer(true);
	driver = new FirefoxDriver(myProfile);*/
	
	}
	
	
	
	
	
	
	


