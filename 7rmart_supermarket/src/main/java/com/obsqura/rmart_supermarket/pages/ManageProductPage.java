package com.obsqura.rmart_supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obsqura.rmart_supermarket.Utilities.PageUtility;

public class ManageProductPage {
	private WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchArea;
	@FindBy(xpath = "//input[@placeholder='Title']")
	WebElement titleField;
	@FindBy(xpath = "//input[@placeholder='Product Code']")
	WebElement productcode;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement selectcategory;
	@FindBy(xpath = "(//select[@data-live-search='true'])[2]")
	WebElement selectSubcategory;
	@FindBy(xpath = "//button[@name=\"Search\"]")
	WebElement clicksearchButton;
	@FindBy(xpath = "//table/thead/tr")
	WebElement tableHeaderOfProductlist;

	public ManageProductPage clickonsearch() {
		searchArea.click();
		return this;
	}

	public ManageProductPage enterproductTitleAndCode(String title, String code) {
		titleField.sendKeys(title);
		productcode.sendKeys(code);
		return this;
	}

	public ManageProductPage selectcategory(String text) {
		selectcategory.click();
		pageutility.selectbyvisibleText(selectcategory, text);
		return this;
	}

	public ManageProductPage selectsubcategory(String text) {
		selectSubcategory.click();
		pageutility.selectbyvisibleText(selectSubcategory, text);
		return this;
	}

	public ManageProductPage clickonsearchbutton() {
		clicksearchButton.click();
		return this;

	}

	public boolean isTableheaderAppears() {
		return tableHeaderOfProductlist.isDisplayed();
	}

}
