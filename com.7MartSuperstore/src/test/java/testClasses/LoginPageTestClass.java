package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import objectRepository_PageClass.HomePageClass;
import objectRepository_PageClass.LoginPageClass;
import utilities.ExcelReadClass;
import utilities.GeneralUtilities;

public class LoginPageTestClass extends BaseClass {
	
	LoginPageClass lp ;
	HomePageClass hp;
	
  @Test(priority = 1,groups = {"functional"})
  public void verifyTheUrlOpensCorrectPageOrNot() throws IOException {
	  lp = new LoginPageClass(driver);
	  String actualUrl = lp.getCurrentUrlOfThePage();
	  String expectedUrl = ExcelReadClass.getStringdata(0,0);;
	  Assert.assertEquals(actualUrl, expectedUrl,"incorrect url");
  }
  @Test(priority = 2)
  public void verify7rmartsupermarketHeadingDisplayedOrNotLoginPage() throws IOException {
	  lp = new LoginPageClass(driver);
	  String actualHeading = lp.getTextOf7rmartSupermarketHeading();
	  String expectedHeading = ExcelReadClass.getStringdata(1,0);
	  Assert.assertEquals(actualHeading, expectedHeading,"Heading not matching");
	  
  }
  
  @Test(dataProvider = "successfulLogin",dataProviderClass = DataProviderClass.class,priority = 6,groups = {"functional"})
  public void verifySuccessfulLogin(String uName, String pasWord) throws IOException {
	  lp = new LoginPageClass(driver);
	  hp = lp.login(uName,pasWord);
	  String expectedResult = ExcelReadClass.getStringdata(2,0);
	  Assert.assertEquals(hp.getTextOfAdminName(), expectedResult,"Login is not suceessful");
	  
  }
  
  @Test(dataProvider = "unsuccessfulLogin",dataProviderClass = DataProviderClass.class,priority = 3,groups = {"functional"})
  public void verifyUnsuccessfulLogin(String uName, String pasWord) {
	  lp = new LoginPageClass(driver);
	  lp.login(uName, pasWord);
	  String actualResult = lp.getTextOfInavlidUsername();
	  System.out.println(actualResult);
	  Assert.assertTrue(actualResult.contains("Invalid Username/Password"));
  }
  
  @Test(priority = 4)
  public void verifyTheRememberMeCheckboxSelectedOrNotByDefault() {
	  lp= new LoginPageClass(driver);
	  Boolean actualResult = lp.isRememebrMeCheckboxSelected();
	  Assert.assertFalse(actualResult, "Remember me checkbox selected by default");
  }
  @Test(priority = 5)
  public void verifyTheRememberMeCheckboxSelectedOrNotAfterSelecting(){
	  lp= new LoginPageClass(driver);
	  lp.clickonRememberMeCheckbox();
	  Boolean actualResult = lp.isRememebrMeCheckboxSelected();
	  System.out.println(actualResult);
	  Assert.assertTrue(actualResult, "remember Me check box not selected after clicking");
  }
}
