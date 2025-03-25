package com.obsqura.rmart_supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newField;
	@FindBy(xpath = "//textarea[@placeholder='Enter the news']")
	WebElement textarea;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveField;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successalert;

	public ManageNewsPage clickonnewfield() {
		newField.click();
		return this;
	}

	public ManageNewsPage enterNews(String news) {
		textarea.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickonSave() {
		saveField.click();
		return this;
	}

	public boolean isAlertsuccessisdisplayed() {
		return successalert.isDisplayed();

	}

}
