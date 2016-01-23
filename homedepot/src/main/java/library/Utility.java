package library;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class Utility {
	
	//private SpecializedScreenRecorder screenRecorder;
	static WebDriver driver;
	
	public static void captureScreenShot(WebDriver driver, String screenShotName){
		  try{
				TakesScreenshot ts = (TakesScreenshot)driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source,new File("./varification/"+screenShotName+".png"));	
				System.out.println("Screen Shot taken");
				}
				  catch(Exception e){
				  System.out.println("This an exception" + e.getMessage());
				}
			}


	/*protected void startRecording(final String methodName) throws Exception {

		String fileSeparator = System.getProperty("file.separator");
		String useDir = System.getProperty("user.dir");
		String timeString = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String fileNameStartWith = methodName; // this.getClass().getSimpleName();
		String canonicalName = this.getClass().getCanonicalName();

		String hierarchy = Joiner.on(fileSeparator).join(
						   Splitter.on('.').split(canonicalName));

		File path = new File(useDir + fileSeparator + "target" + fileSeparator
				+ "videos" + fileSeparator + timeString + fileSeparator
				+ hierarchy + fileSeparator);

		if (!path.exists()) {
			path.mkdir();
		}

		this.screenRecorder = new SpecializedScreenRecorder(path, fileNameStartWith);
		this.screenRecorder.start();
	}

	protected void stopRecording() throws Exception {
		this.screenRecorder.stop();
	}*/
	
	
	
}
