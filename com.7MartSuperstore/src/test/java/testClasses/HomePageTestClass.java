package testClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import objectRepository_PageClass.HomePageClass;
import objectRepository_PageClass.LoginPageClass;
import utilities.ExcelReadClass;

public class HomePageTestClass extends BaseClass{
	LoginPageClass lp ;
	HomePageClass hp;
  @Test(priority = 3,groups = {"functional"})
  public void verifyLogout() {
	  
	  lp = new LoginPageClass(driver);
	  hp = lp.login("admin", "admin");
	  lp = hp.logout();
	  String actualResult = lp.getTitleOfLoginPage();
	  System.out.println(actualResult);
	  Assert.assertTrue(actualResult.contains("Login"));
  }
  
  @Test(dataProvider = "successfulLogin",dataProviderClass = DataProviderClass.class,priority = 1)
  public void verifyTheCountOfAllTilesDisplayedOnHomePage(String uName,String pasWrd) throws IOException {
	  lp = new LoginPageClass(driver);
	  hp = lp.login(uName, pasWrd);
	  int actualResult = hp.countOfAllTiles();
	  int expectedResult = 11; 
	  System.out.println(actualResult);
	  Assert.assertEquals(actualResult,11);
}
 
  @Test(dataProvider = "successfulLogin",dataProviderClass = DataProviderClass.class,priority = 2)
  public void verifyAllTilesDisplayedOrNotOnHomePage(String uName,String pasWrd) {
	  lp = new LoginPageClass(driver);
	  hp = lp.login(uName, pasWrd);
	  List <WebElement> allTiles = hp.allTilesDisplayedOrNotOnHomePage();
	  for(WebElement tile :allTiles) {
		  System.out.println(tile.isDisplayed());
		  Assert.assertTrue(tile.isDisplayed(), "Not all tiless on Homepage are displayed");
	  }
}
}