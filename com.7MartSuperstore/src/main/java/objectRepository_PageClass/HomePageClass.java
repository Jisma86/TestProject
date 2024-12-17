package objectRepository_PageClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class HomePageClass {
	WebDriver driver;
	GeneralUtilities gl =  new GeneralUtilities();
	ExplicitWaitClass ew = new ExplicitWaitClass();
	
	public HomePageClass(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
        
	}
	
	@FindBy(xpath="//a[text()=' Admin']")
	WebElement adminName;
	
	@FindBy(xpath ="//a[@data-toggle='dropdown']")
	WebElement admin;
	
	@FindBy(xpath= "//li[@class='nav-item dropdown show']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logOut;
	
	@FindBy(xpath="//div[contains(@class,'col-lg')]")
	List <WebElement> allTiles;
	
	@FindBy(xpath = "(//p[text()='Category'])[1]")
	WebElement category;
	
	@FindBy(xpath="(//p[text()='Manage Product'])[1]")
    WebElement manageProduct;
	
	public String getTextOfAdminName() {
		return gl.getTextOfElement(adminName);
	}
	
    
	public LoginPageClass logout() {
		gl.clickOnElement(admin);
		gl.clickOnElement(logOut);
		return new LoginPageClass(driver); //navigate back to login page
	}
	
	public int countOfAllTiles() {
		return gl.getCountOfElements(allTiles);
	}
	

	  public List<WebElement> allTilesDisplayedOrNotOnHomePage() {
	        return allTiles;
	    }
	  
	  public CategoryPageClass clickCategory() {
			gl.clickOnElement(category);
			return new CategoryPageClass(driver);

		}
	  
	  public ManageproductPageClass clickingonManageProduct() {
			gl.clickOnElement(manageProduct);
			return new ManageproductPageClass(driver);
		}
}
