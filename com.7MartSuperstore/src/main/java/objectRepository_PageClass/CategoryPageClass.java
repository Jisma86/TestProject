package objectRepository_PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class CategoryPageClass {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass ew = new ExplicitWaitClass();

	public CategoryPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(xpath = "//i[@class=' fa fa-search']")
	WebElement search;

	@FindBy(xpath = "//input[@placeholder='Category']")
	WebElement categorySeachBox;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButton;

	@FindBy(xpath = "//h1[contains(text(),'List Categories')]")
	WebElement listCategoryText;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	WebElement productUnderListCategories;
	
	

	

	public String getTextOfListCategory() {
		return gl.getTextOfElement(listCategoryText);
	}

	public void searchCategory(String value) {

		gl.clickOnElement(search);
		gl.typeOnElement(categorySeachBox, value);
		gl.clickOnElement(searchButton);
		
	}
	
	public String getTextOfSearchedCategory() {
		return gl.getTextOfElement(productUnderListCategories);
	}
	
	
	
	
	

}
