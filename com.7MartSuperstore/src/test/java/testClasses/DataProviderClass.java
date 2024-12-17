package testClasses;

import org.testng.annotations.Test;

import utilities.ExcelReadClass;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
  

  @DataProvider(name = "unsuccessfulLogin")
  public Object[][] dp() throws IOException {
    return new Object[][] {
      new Object[] { ExcelReadClass.getStringdata(0,1)  ,ExcelReadClass.getStringdata(0,3)  },
      new Object[] { ExcelReadClass.getStringdata(1,1), ExcelReadClass.getStringdata(0,1) },
      new Object[] { ExcelReadClass.getStringdata(1,2),  ExcelReadClass.getStringdata(1,2) },
    };
  }
  
  @DataProvider(name = "successfulLogin")
  public Object[][] dpLogin() throws IOException {
    return new Object[][] {
    	 new Object[] { ExcelReadClass.getStringdata(0,1)  ,ExcelReadClass.getStringdata(0,2)  },
      
    };
  }
}
