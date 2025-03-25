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

import com.obsqura.rmart_supermarket.Utilities.PageUtility;
import com.obsqura.rmart_supermarket.Utilities.WaitUtility;

public class CategoryPage {
	public WebDriver driver;
PageUtility pageutility=new PageUtility();
WaitUtility waitutility=new WaitUtility();
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
	@FindBy(xpath = "(//input[@name='show_home'])[2]")
	WebElement radiobuttonNo;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveFeild;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement existalert;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successalert;
	public CategoryPage clickonNew() {
		newField.click();
		return this;
	}

	  
	public CategoryPage entercategrydetails(String categoryname) throws AWTException {
		enterCategoryField.sendKeys(categoryname);
		discountField.click();
		chooseFileField.sendKeys("C:\\Users\\nayan\\OneDrive\\Desktop\\image of book\\bookimage.png");
		pageutility.javascriptExcevuter(driver,radiobuttonNo);
		//pageutility.roboClass(driver, chooseFileField);
		
		waitutility.elementtobeclikable(driver,radiobuttonNo);
		radiobuttonNo.click();
		return this;
	}

	public CategoryPage clickonsave() {
		waitutility.visibilityo(driver,radiobuttonNo);
		saveFeild.click();
		return this;
	}
	public boolean isexistalertdisplayed() {
		return existalert.isDisplayed();
		 
	}
	public boolean issuccessalertisdisplayed() {
		return successalert.isDisplayed();
	}

}
