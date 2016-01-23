package com.homedepot.test;

import library.Utility;

import org.testng.annotations.Test;

import com.homedepot.baseLibs.BasePage;

public class ProductTestPage extends BasePage {
	
	@Test
	public void productSelections(){
		homeDepotApps().homePage().clickSignIn();
		homeDepotApps().signInPage().UserSignIN("shchaklader@gmail.com", "rahul2016");
		homeDepotApps().homePage().clickKitchenLink();
		homeDepotApps().productPage().clickAppliancesLink();
		Utility.captureScreenShot(driver, "ApplicnePage");
		homeDepotApps().productPage().clickWashers();
		homeDepotApps().productPage().clickTopLoadWashers();
		//homeDepotApps().productPage().clickShortBy();
		homeDepotApps().productPage().shortBySelect();
		homeDepotApps().productPage().scrollPage();
	}

}
