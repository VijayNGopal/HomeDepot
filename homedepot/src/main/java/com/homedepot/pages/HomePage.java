package com.homedepot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.controllLibs.ControllerPage;

public class HomePage extends ControllerPage{

	public HomePage(WebDriver dirver) {super(dirver);}
	
	private WebElement register;
	private WebElement signIn;
	private WebElement kitchen;
	
	
	public WebElement register(){
		register=driver.findElement(By.xpath("//*[@id='accountInfo']/a[text()='Register']"));
		return register;
	}
	public WebElement signIn(){
		signIn= driver.findElement(By.xpath("//*[@id='accountInfo']/a[2]"));
		return signIn;
	}
	
	public WebElement kitchen(){
		kitchen = driver.findElement(By.xpath(".//*[@id='main-nav-dropdown']/li[10]/a"));
		return kitchen;
	}
	// Action Method
	
	public void clickRegister(){
		register().click();
	}
	
	public void clickSignIn(){
		signIn().click();
	}
	public void clickKitchenLink(){
		kitchen().click();
		delayFor(2000);
	}
}
