package objectRepository_PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class LoginPageClass {
	
	WebDriver driver;
	GeneralUtilities gl =  new GeneralUtilities();
	ExplicitWaitClass ew = new ExplicitWaitClass();
	
	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);  
	}
	
	@FindBy(xpath = "//b[text()='7rmart supermarket']") 
	WebElement heading_7rmartsupermarket;
	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;
	@FindBy(xpath= "//input[@name='password']")
	WebElement passWord;
	@FindBy(xpath ="//button[text()='Sign In']")
	WebElement signIn;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement invalidUsername_Password;
	@FindBy(id="remember")
	WebElement rememberMeCheckbox;
	
	public String getTextOf7rmartSupermarketHeading() {
		ew.visibiltyOf(driver, heading_7rmartsupermarket);
		return gl.getTextOfElement(heading_7rmartsupermarket);
	}

	public String getCurrentUrlOfThePage() {
		return gl.getCurrentUrlOfThePage(driver);
	}
	
	public HomePageClass login(String uname,String pwd) {
		gl.typeOnElement(userName,uname);
		gl.typeOnElement(passWord, pwd);
		gl.clickOnElement(signIn);
		return new HomePageClass(driver);    //navigate to HomePageClass
	}
	
	public String getTitleOfLoginPage() {
		return gl.getTitleOfThePage(driver);
	}
	
	public String getTextOfInavlidUsername() {
		
		ew.presenceOfElementLocatedWaitXpath(driver,"//div[@class='alert alert-danger alert-dismissible']");
	
		return invalidUsername_Password.getText();
	}
	
	public boolean isRememebrMeCheckboxSelected() {
		return gl.isElementselected(rememberMeCheckbox);
	}
	
	public void clickonRememberMeCheckbox() {
	
		gl.jsExecutorClickOnElement(driver, rememberMeCheckbox);
		
	}
}
