package com.obsqura.rmart_supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {

	public WebDriver driver;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-primary btncss'])[1]")
	WebElement clicEditButton;
	@FindBy(xpath = "//textarea[@placeholder='Enter the Address']")
	WebElement addressField;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailField;
	@FindBy(xpath = "(//input[@class='form-control'])[2]")
	WebElement phonenumberField;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement ubdatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertsuccess;

	public ManageFooterTextPage clickonedit() {
		clicEditButton.click();
		return this;
	}

	public ManageFooterTextPage editfooterdata(String address, String email, String phonenumber) {
		addressField.clear();
		addressField.sendKeys(address);
		emailField.clear();
		emailField.sendKeys(email);
		phonenumberField.clear();
		phonenumberField.sendKeys(phonenumber);
		return this;
	}

	public ManageFooterTextPage clickOnUbdate() {
		ubdatebutton.click();
		return this;

	}

	public boolean isAlertDisplayed() {
		return alertsuccess.isDisplayed();
	}
}