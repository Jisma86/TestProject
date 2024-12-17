package testClasses;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenShot;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	WebDriver driver;
	ScreenShot ss ;
	static Properties  p;
	
	public static void readProperty() throws IOException {
		 p = new Properties();
		 FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
	     p.load(file);	
	}
  
  @BeforeMethod(groups = {"tearup"})
  public void beforeMethod() throws IOException {
	  
	  readProperty();
	  
	  
	  WebDriverManager.chromedriver().setup();
	  driver= new ChromeDriver();
	  driver.get(p.getProperty("url"));
	  driver.manage().window().maximize();
	  driver.navigate().refresh();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod(groups = {"teardown"})
  public void afterMethod(ITestResult itr) throws IOException {
	  
	 
	  if (itr.getStatus()==ITestResult.FAILURE)
	  {
		  ss = new ScreenShot();
		  ss.takeScreenshotOfFailedTC(driver, itr.getName());
	  }
	  
	  driver.quit();
  } 
  
  
  @BeforeSuite(alwaysRun = true)
  public void createExtentReport() {
      extentReport.ExtentManager.createInstance();
      System.out.println("Extent Report initialized successfully.");
  }
}
