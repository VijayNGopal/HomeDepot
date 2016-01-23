package com.selenium.controllLibs;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ControllerPage {

	private static final TimeUnit SECONDS = null;
	protected WebDriver driver;
	public WebDriverWait wait;

	public ControllerPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,5);
	}

	public void mouseHoverSignOut() {
		WebElement element = driver.findElement(By.id("thdMyAccount"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.xpath("//*[@id='thdMyAccount']/ul//a[text()='Sign Out']"))
				           .click();
	}
	public void hoverItem(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

	public void delayFor(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
		}
	}
		
	public void shortBySelect(){
		Select shotBy = new Select(driver.findElement(By.id("autoGen0")));
		List<WebElement> oSize = shotBy.getOptions();
		System.out.println("Total item:" + oSize.size());
		for(int i = 0; i<oSize.size(); i++)
			{
			  String value =  shotBy.getOptions().get(i).getText();
			  System.out.println(value);
			  if(value.equals("Price Low to High")){
			  shotBy.selectByVisibleText("Price Low to High");
			}
			}
	}
	public void itMultiSelectable(){
		Select selMulti = new Select(driver.findElement(By.xpath(".//*[@id='autoGen0']")));
		if(selMulti.isMultiple()){
			System.out.println("Drop Down allow Multiple Selcction ");
		}
		else{
			System.out.println("Drop Down does not allow Multiple Selection");
		}
	}
	
	public void scrollPage(){
		delayFor(3000);
		WebElement  ele = driver.findElement(By.xpath(".//*[@id='products']/div[5]/form/div[2]/div[1]/div/a/img"));
		Coordinates coordenate = ((Locatable)ele).getCoordinates();
		coordenate.inViewPort();
	}
	

}
