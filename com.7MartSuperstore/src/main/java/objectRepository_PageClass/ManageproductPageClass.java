package objectRepository_PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class ManageproductPageClass {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass ew = new ExplicitWaitClass();

	public ManageproductPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()='List Products']")
	WebElement listProducts;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	
	@FindBy(xpath="//input[@name='cd']")
	WebElement productCode;
	
	@FindBy(xpath="//button[@name='Search']")
	WebElement searchRedButton;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	WebElement searchedProductName;
	
	@FindBy(xpath="//input[@name='un']")
	WebElement titleOfTextbox;
	
	public String getTextOfListProduct() {
		return gl.getTextOfElement(listProducts);
	}
	

	public void searchProduct(String value) {
		gl.clickOnElement(searchButton);
		gl.typeOnElement(productCode, value);
		gl.clickOnElement(searchRedButton);
		
	}
	public String getTextOfSearchedProductName() {
		return gl.getTextOfElement(searchedProductName);
	}
	
	public void clickOnSearchButton() {
		gl.clickOnElement(searchButton);
	}
	
	public void typeOnSearchTextbox(String value) {
		gl.typeOnElement(titleOfTextbox, value);
	}
	
	public String getValueOfPlaceholderAttribute(String value) {
		return gl.getAttributeOfElement(titleOfTextbox,value);
	}
	
	public void typeTextOnTitle(String value) {
		gl.typeOnElement(titleOfTextbox, value);
	}

}
