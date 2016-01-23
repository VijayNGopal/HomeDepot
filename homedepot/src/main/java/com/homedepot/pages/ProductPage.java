package com.homedepot.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.controllLibs.ControllerPage;

public class ProductPage extends ControllerPage{

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	private WebElement appliances;
	private WebElement washers;
	private WebElement topLoadWashers;
	private WebElement sortBy;
	
	public WebElement appliances(){
		appliances = driver.findElement(By.xpath("//*[@id='hfappContainer']/div[5]/div/div[1]/div/div[2]/div/div/ul/li[2]/a"));
		return appliances;
	}
	public WebElement washers(){
		washers = driver.findElement(By.xpath(".//*[@id='hfappContainer']/div[5]/div/div[2]/div/div[5]/div[1]/div/h3/a"));
		return washers;
	}
	public WebElement topLoadWashers(){
		topLoadWashers = driver.findElement(By.xpath(".//*[@id='hfappContainer']/div[5]/div/div[2]/div/div[5]/div[1]/div/h3/a"));
		return topLoadWashers;
	}
	public WebElement sortBy(){
		sortBy = driver.findElement(By.xpath("//*[@id='autoGen0']"));
		return sortBy;
	}
	
	// Actions
	public void clickAppliancesLink(){
		appliances().click();
	}
	public void clickWashers(){
		washers().click();
	}
	public void clickTopLoadWashers(){
		topLoadWashers().click();
	}
	
	public void clickShortBy(){
		sortBy().click();
		
	}
	/*public void selectShortBy(){
			List oSize = sortBy.getOptions();
			System.out.println("Total item:" + oSize.size());
			for(int i = 0; i<oSize.size(); i++)
				{
				  String value =  sortBy.getOptions().get(i).getText();
				  System.out.println(value);
				  if(value.equals("Price Low to High")){
				  sortBy.selectByVisibleText("Price Low to High");
				}
				}
	}*/

}
