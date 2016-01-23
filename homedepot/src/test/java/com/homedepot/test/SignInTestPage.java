package com.homedepot.test;

import library.Utility;

import org.testng.annotations.Test;

import com.homedepot.baseLibs.BasePage;

public class SignInTestPage extends BasePage{
	
	/*@Test
	public void Reg_Test(){
		homeDepotApps().homePage().clickRegister();
		homeDepotApps().registerPage().FillOutRegisterForm("Shamim", "Chaklader", "11418", "email@gmail.com",
														  "12345", "12345");
	}*/
	
	@Test
	public void UserCanloginWithValidDetail(){
		homeDepotApps().homePage().clickSignIn();
		homeDepotApps().signInPage().verifySinginForm("My Account Sign In");
		Utility.captureScreenShot(driver, "singIn_form_verification");
		//homeDepotApps().signInPage().ScreenShoot();
		//homeDepotApps().signInPage().captureScreenShot(driver, "pic01");
		homeDepotApps().signInPage().resetPasswordLink().isDisplayed();
		homeDepotApps().signInPage().UserSignIN("shchaklader@gmail.com", "rahul2016");
		homeDepotApps().signInPage().verifyUserName("Hello Rahul,");
		Utility.captureScreenShot(driver, "user_name_verification");
		//homeDepotApps().signInPage().mouseHoverSignOut();
	}
	
	/*@Test(dependsOnMethods="UserCanloginWithValidDetail")
	public void UserCantnotloginWithInvalidDetail(){
		homeDepotApps().homePage().clickSignIn();
		homeDepotApps().signInPage().UserSignIN("shchaklader@gmail.com", "123654");
		homeDepotApps().signInPage().verifyLoginFail();
		*/
	
	

}
