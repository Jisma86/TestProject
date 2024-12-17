package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import objectRepository_PageClass.CategoryPageClass;
import objectRepository_PageClass.HomePageClass;
import objectRepository_PageClass.LoginPageClass;

public class CategoryPageTestClass extends BaseClass{
	LoginPageClass lp ;
	HomePageClass hp;
	CategoryPageClass cp;
	
  @Test(dataProvider = "successfulLogin",dataProviderClass = DataProviderClass.class,priority = 1,groups = {"functional"})
  public void verifyCategorypageisopenwhileclickingoncategory(String uName, String pasWord) {
	  lp= new LoginPageClass(driver);
	  hp = lp.login(uName, pasWord); 
	  cp =  hp.clickCategory();
	  String actualResult = cp.getTextOfListCategory(); 
	  Assert.assertTrue(actualResult.contains("List"));
  }
  
  @Test(dataProvider = "successfulLogin",dataProviderClass = DataProviderClass.class,priority = 2,groups = {"functional"})
  public void verifySearchCategory(String uName, String pasWord) {
	  lp= new LoginPageClass(driver);
	  hp = lp.login(uName,pasWord);
	  cp = hp.clickCategory();
	  cp.searchCategory("Vegetables");
	  String actualResult = cp.getTextOfSearchedCategory();
	  System.out.println(actualResult);
	  Assert.assertTrue(actualResult.contains("Vegetable"));
  }
  

  
}
