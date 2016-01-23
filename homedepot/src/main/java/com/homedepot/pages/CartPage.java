package com.homedepot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.selenium.controllLibs.ControllerPage;

public class CartPage extends ControllerPage {

	public CartPage(WebDriver dirver) {
		super(dirver);
	}
	
	private WebElement lgElectronics; 
	private WebElement pirceCheck;
	
	public WebElement lgElectronics(){
		lgElectronics = driver.findElement(By.xpath(".//*[@id='products']/div[5]/form/div[2]/div[1]/div/a/img"));
		return lgElectronics;
	}
	public WebElement pirceCheck(){
		pirceCheck = driver.findElement(By.xpath(".//*[@id='ajaxPrice']"));
		Assert.assertEquals(pirceCheck,"$549.00");
		return pirceCheck;
	}
	
	// Action
	public void clickLGelectronics(){
		lgElectronics().click();
	}
	
	
	
	
	

}
		