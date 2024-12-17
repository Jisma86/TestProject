package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import objectRepository_PageClass.CategoryPageClass;
import objectRepository_PageClass.HomePageClass;
import objectRepository_PageClass.LoginPageClass;
import objectRepository_PageClass.ManageproductPageClass;
import utilities.ExcelReadClass;

public class ManageProductPageTestClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;
	ManageproductPageClass mp;
  
	  @Test(dataProvider = "successfulLogin",dataProviderClass = DataProviderClass.class,groups = {"functional"})
	  public void verifyManageProductpageisopenwhileclickingonManageProduct(String uName,String pasWrd) throws IOException {
		  lp= new LoginPageClass(driver);
		  hp = lp.login(uName, pasWrd);
		  mp = hp.clickingonManageProduct();
		  String actualResult = mp.getTextOfListProduct();
		  System.out.println(actualResult);
		  Assert.assertEquals(actualResult, ExcelReadClass.getStringdata(3,0));
		  //Assert.assertNotNull(actualResult);
	  }
	  
	  @Test(dataProvider = "successfulLogin",dataProviderClass = DataProviderClass.class,groups = {"functional"})
	  public void verifysearchprduct(String uName,String pasWrd) throws IOException {
		  lp= new LoginPageClass(driver);
		  hp = lp.login(uName, pasWrd);
		  mp = hp.clickingonManageProduct();
		  mp.searchProduct(ExcelReadClass.getIntegerdata(4, 1));
		  String actualResult = mp.getTextOfSearchedProductName();
		  System.out.println(actualResult);
		  Assert.assertTrue(actualResult.contains(ExcelReadClass.getStringdata(4,0)));
	  }
	  @Test(dataProvider = "successfulLogin",dataProviderClass = DataProviderClass.class)
	  public void verifyTheTitleTextboxIsEmptyByDefault(String uName,String pasWrd) {
		  lp = new LoginPageClass(driver);
		  hp = lp.login(uName, pasWrd);
		  mp = hp.clickingonManageProduct();
		  mp.clickOnSearchButton();
		  String actualResult = mp.getValueOfPlaceholderAttribute("placeholder");
		  System.out.println(actualResult);
		 // Assert.assertNull(actualResult);
	  }
	  
	  @Test(dataProvider = "successfulLogin",dataProviderClass = DataProviderClass.class)
	  public void verifyToEnterTitlesIntoTitleTextbox(String uName,String pasWrd) throws IOException {
		  lp = new LoginPageClass(driver);
		  hp = lp.login(uName,pasWrd);
		  mp = hp.clickingonManageProduct();
		  mp.clickOnSearchButton();
		  mp.typeOnSearchTextbox(ExcelReadClass.getStringdata(2,1));
		  String actualResult = mp.getValueOfPlaceholderAttribute("value");
		  System.out.println(actualResult);
		  Assert.assertEquals(actualResult, ExcelReadClass.getStringdata(2,1),"mismatch");
		  
	  }
	    
}
