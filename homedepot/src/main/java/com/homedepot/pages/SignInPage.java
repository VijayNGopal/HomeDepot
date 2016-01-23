package com.homedepot.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.selenium.controllLibs.ControllerPage;

public class SignInPage extends ControllerPage {
	private WebElement singInForm;
	private WebElement emailAddress;
	private WebElement passWord;
	private WebElement signinButton;
	private WebElement resetPasswordLink;
	private WebElement userName;
	private WebElement erroMsg;

	public SignInPage(WebDriver dirver) {super(dirver);}
	
	public WebElement signInForm(){
		singInForm = driver.findElement(By.xpath(".//*[@id='userLogin']//div/p[text()='My Account Sign In']"));
		return singInForm;
	}
	public WebElement emailAddress(){
		emailAddress= driver.findElement(By.xpath(".//*[@id='email_id']"));
		return emailAddress;
	}
	public WebElement passWord(){
		passWord = driver.findElement(By.xpath(".//*[@id='password']"));
		return passWord;
	}
	public WebElement signinButton(){
		signinButton = driver.findElement(By.xpath(".//*[@id='signIn']"));
		return signinButton;
	}
	public WebElement resetPasswordLink(){
		resetPasswordLink = driver.findElement(By.xpath("//*[@id='userLogin']//div/a[text()='Reset your password']"));
		System.out.println("Reset link has shown");
		return resetPasswordLink;
	}
	public WebElement userName(){
		userName = driver.findElement(By.xpath("//*[@id='navUserName']"));
		return userName;
	}
	public WebElement erroMsg(){
		erroMsg = driver.findElement(By.cssSelector(".signInError"));
		return erroMsg;
	}
	
	// Actions

	public void UserSignIN(String email, String pass){
		emailAddress().sendKeys(email);
		passWord().sendKeys(pass);
		signinButton().click();
		delayFor(3000);
	}

// Verification
	public boolean verifySinginForm(String headerText){
		String text=signInForm().getText();
		Assert.assertEquals(headerText,text );
		return true;
	}
	public boolean verifyUserName(String userName){
		String name = userName().getText();
		Assert.assertEquals(userName, name);
		return true;
	}
	public boolean verifyLoginFail() {
		if (erroMsg() != null) {
			String errorText = erroMsg().getText();
			Assert.assertEquals("Your sign in is incorrect. Please re-enter your Email Address and Password. ", errorText);
			return true;
		}
		    return false;
	}
	
	
	
	
	
}
