package com.homedepot.utilLibs;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.selenium.controllLibs.ControllerPage;

public class ScreenShot  extends ControllerPage {
	public ScreenShot(WebDriver driver) {
		super(driver);
		
	}

	public static void captureScreenShot(WebDriver driver, String screenShotName){
		  try{
				TakesScreenshot ts = (TakesScreenshot)driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source,new File("./ScreenShot/"+screenShotName+".png"));	
				System.out.println("Screen Shot taken");
				}
				  catch(Exception e)
		  		{
				  System.out.println("This an exception" + e.getMessage());
				}
			}

		// Taking ScreenShot ONLY for Failed Tests

		  public void testFail(ITestResult result){
		  
		    if(ITestResult.FAILURE ==result.getStatus())
		    {
		    	ScreenShot.captureScreenShot(driver,result.getName());   // getName is testcasename(testFail) and 
		      													         // ScreenShot is my static class AND captureScreenShot method name; 	
		    }
		  
		  }
	

}
