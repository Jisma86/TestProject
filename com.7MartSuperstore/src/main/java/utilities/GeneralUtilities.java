package utilities;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public String getCurrentUrlOfThePage(WebDriver driver) {

		return driver.getCurrentUrl();
	}

	public String getTitleOfThePage(WebDriver driver) {  

		return driver.getTitle();
	}

	public void clickOnElement(WebElement element) {
		element.click();

	}

	public void clearElement(WebElement element) {
		element.clear();

	}

	public void typeOnElement(WebElement element, String value) {
		element.sendKeys(value);

	}

	public String getTextOfElement(WebElement element) {
		return element.getText();
	}
	
	public String getAttributeOfElement(WebElement element,String value) {
		return element.getAttribute(value);
		
	}
	
	public int getCountOfElements(List <WebElement> element) {
		return element.size();
		
	}

	public void scrollToFindAnElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public void jsExecutorClickOnElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public String getTextOfAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}


	public void selectByIndexDropDown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public boolean isMultiple(WebElement element) {
		Select select = new Select(element);
		return select.isMultiple();
	}
	
	public void selectByVisibleTextDropDown(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	public void selectByValueDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	public boolean isElementselected(WebElement element) {
		return element.isSelected();
	}
	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}
	
	 public void submitElement(WebElement element) {
		 element.submit();
	 }
 
	
	public void pressEnterKey(WebDriver driver) {
		Actions a = new Actions(driver);
		a.keyDown(Keys.ENTER).build().perform();
	}

}
