package com.selenium.controllLibs;

import org.openqa.selenium.WebDriver;

import com.homedepot.pages.CartPage;
import com.homedepot.pages.CheckOutPage;
import com.homedepot.pages.HomePage;
import com.homedepot.pages.ProductPage;
import com.homedepot.pages.RegisterPage;
import com.homedepot.pages.SignInPage;

public class HomeDepotApps extends ControllerPage{
	private RegisterPage registePage;
	private HomePage homePage;
	private SignInPage signInPage;
	private ProductPage productPage;
	private CartPage cartPage;
	private CheckOutPage checkOutPage;

	public HomeDepotApps(WebDriver dirver) {super(dirver);}
	
	public RegisterPage registerPage(){
		if(registePage == null){
			registePage = new RegisterPage(driver);
		}
		return registePage;
	}
	public HomePage homePage(){
		if(homePage ==null){
		 homePage = new HomePage(driver);
		}
		return homePage;
	}
	public SignInPage signInPage(){
		if(signInPage == null ){
			signInPage = new SignInPage(driver);
		}
		return signInPage;
	}
	public ProductPage productPage(){
		if(productPage == null){
			productPage = new ProductPage(driver);	
		}
		return productPage;
	}
	public CartPage cartPage(){
		if(cartPage == null){
			cartPage = new CartPage(driver);
		}
		return cartPage;
	}
	
	public CheckOutPage checkOutPage(){
		if(checkOutPage == null){
			checkOutPage = new CheckOutPage(driver);	
		}
		return checkOutPage;
	}
	
	
}
