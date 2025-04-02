package com.obsqura.rmart_supermarket.pages;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.obsqura.rmart_supermarket.Utilities.FileuploadUtility;
import com.obsqura.rmart_supermarket.Utilities.PageUtility;
import com.obsqura.rmart_supermarket.Utilities.WaitUtility;
import com.obsqura.rmart_supermarket.constant.Constant;

public class CategoryPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newField;
	@FindBy(xpath = "//input[@placeholder='Enter the Category']")
	WebElement enterCategoryField;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement discountField;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFileField;
	@FindBy(xpath = "(//input[@value='no'])[2]")
	WebElement radiobuttonNo;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveFeild;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successalert;

	public CategoryPage clickonNew() {
		newField.click();
		return this;
	}

	public CategoryPage entercategrydetails(String categoryname) throws AWTException {
		enterCategoryField.sendKeys(categoryname);
		discountField.click();
		
		/*JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click;",chooseFileField);*/

		FileuploadUtility fileupload = new FileuploadUtility();
		fileupload.sendkeysforFileupload(chooseFileField, Constant.IMAGE);

		//fileupload.roboclassforFileupload(chooseFileField, Constant.IMAGE);
		pageutility.javascriptExcecuter(driver, radiobuttonNo);

		waitutility.elementTobeclikable(driver, radiobuttonNo);
		//radiobuttonNo.click();
		return this;
	}

	public CategoryPage clickonsave() {
		pageutility.javascriptExcecuter(driver,saveFeild);
		/*JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,15000)");*/
		waitutility.elementTobeclikable(driver, saveFeild);
		saveFeild.click();
		return this;
	}

	public boolean issuccessalertisdisplayed() {
		return successalert.isDisplayed();
	}

}
