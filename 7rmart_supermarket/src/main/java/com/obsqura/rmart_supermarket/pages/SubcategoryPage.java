package com.obsqura.rmart_supermarket.pages;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.rmart_supermarket.Utilities.FileuploadUtility;
import com.obsqura.rmart_supermarket.Utilities.PageUtility;
import com.obsqura.rmart_supermarket.Utilities.WaitUtility;
import com.obsqura.rmart_supermarket.constant.Constant;

public class SubcategoryPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();
	

	public SubcategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newField;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement selectCategory;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement entersubcategoryFeild;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choosefileField;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveField;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successalert;

	public SubcategoryPage clickonnew() {
		newField.click();
		return this;
	}

	public SubcategoryPage enterSubcategoryDetails(String text, String subcategory) throws Exception {
		pageutility.selectbyvisibleText(selectCategory, text);
		entersubcategoryFeild.sendKeys(subcategory);
		waitutility.elementTobeclikable(driver, choosefileField);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click;", choosefileField);
		
		//FileuploadUtility fileuploadutility = new FileuploadUtility();
		//fileuploadutility.roboclassforFileupload(choosefileField, Constant.IMAGE2);

		// choosefileField.sendKeys(Constant.IMAGE2);
		//fileuploadutility.sendkeysforFileupload(choosefileField, Constant.IMAGE2);

		return this;
	}

	public SubcategoryPage clickonsave() {
		pageutility.javascriptExcecuter(driver, saveField);
		waitutility.elementTobeclikable(driver, saveField);
		saveField.click();
		return this;
	}

	public boolean issuccessalertdisplayed() {
		return successalert.isDisplayed();

	}

}
