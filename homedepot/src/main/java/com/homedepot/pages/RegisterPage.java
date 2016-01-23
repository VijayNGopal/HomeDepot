package com.homedepot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.selenium.controllLibs.ControllerPage;

public class RegisterPage extends ControllerPage {

	public RegisterPage(WebDriver dirver) {super(dirver);}
	
	private WebElement fName;
	private WebElement lName;
	private WebElement zip;
	private WebElement email;
	private WebElement password;
	private WebElement confoPassword;
	private WebElement regButton;
	private WebElement rgPage;
	
	
	
	public WebElement fName(){
		driver.findElement(By.cssSelector("#dualSignIn-firstName"));
		return fName;
	}
	public WebElement lName(){
		driver.findElement(By.xpath(".//*[@id='dualSignIn-lastName']"));
		return lName;
	}
	
	public WebElement zip(){
		driver.findElement(By.xpath(".//*[@id='dualSignIn-zipcode']"));
		return zip;
	}
	public WebElement email(){
		driver.findElement(By.xpath(".//*[@id='dualSignIn-registrationEmail']"));
		return email;
	}
	public WebElement password(){
		driver.findElement(By.xpath(".//*[@id='dualSignIn-registrationPassword']"));
		return password;
	}
	
	
	public WebElement confoPassword(){
		driver.findElement(By.xpath(".//*[@id='dualSignIn-confirmPassword']"));
		return confoPassword;
	}
	
	public WebElement RegButton(){
		driver.findElement(By.xpath(".//*[@id='dualSignIn-Register']"));
		return regButton;
	}
	
	
	
	// Action 
	
	public void FillOutRegisterForm(String f_Name, String l_Name, String zipCode, String emailAddress, 
							String passWord, String conformPassWord){
		fName().sendKeys(f_Name);
		lName().sendKeys(l_Name);
		zip().sendKeys(zipCode);
		email().sendKeys(emailAddress);
		password().sendKeys(passWord);
		confoPassword().sendKeys(conformPassWord);
		RegButton().click();
	}
	
	/*public void VerifyRegisterPage(){
	rgPage = driver.findElement(By.xpath("//*[@id='tab_register']//following::div//p[text()='My Account Registration']"));
	Assert.assertEquals(rgPage, "My Account Registration");	
	}*/
	
	
	
	

}
