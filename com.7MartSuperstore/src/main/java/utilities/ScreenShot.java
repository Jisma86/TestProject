package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class ScreenShot {
	
	
	public void takeScreenshotOfFailedTC(WebDriver driver,String name) throws IOException {
		
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File scrshotFile = scrShot.getScreenshotAs(OutputType.FILE);
		
		String dest = System.getProperty("user.dir") + "//Test_Evidence";
		File f1 = new File(dest);
		if (!f1.exists()) {
			f1.mkdirs();  //to create a test evidence folder if that folder not exists
		}
		
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		
		String path_screenshotFile = System.getProperty("user.dir") + "//Test_Evidence//" + name + timeStamp + ".png";
		
		File fileDestination = new File(path_screenshotFile);
		FileHandler.copy(scrshotFile,fileDestination);
		
	}

}
