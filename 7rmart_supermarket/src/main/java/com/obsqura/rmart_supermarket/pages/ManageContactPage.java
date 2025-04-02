package com.obsqura.rmart_supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.rmart_supermarket.Utilities.PageUtility;
import com.obsqura.rmart_supermarket.Utilities.WaitUtility;

public class ManageContactPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();
	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fas fa-edit']")
	WebElement editactionField;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneField;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailField;
	@FindBy(xpath = "//textarea[@placeholder='Enter the Address']")
	WebElement addressField;
	@FindBy(xpath = "//textarea[@placeholder='Enter Delivery Time']")
	WebElement deliverytimeField;
	@FindBy(xpath = "//input[@id='del_limit']")
	WebElement deliverylimit;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlert;

	public ManageContactPage clickedit() {
		editactionField.click();
		return this;
	}

	public ManageContactPage enterphonenumber(String phone) {
		phoneField.clear();
		phoneField.sendKeys(phone);
		return this;
	}

	public ManageContactPage enteremail(String email) {
		emailField.clear();
		emailField.sendKeys(email);
		return this;
	}

	public ManageContactPage enteraddress(String address) {
		addressField.clear();
		addressField.sendKeys(address);
		return this;

	}

	public ManageContactPage enterdeliveryTime(String time) {
		deliverytimeField.clear();
		deliverytimeField.sendKeys(time);
		return this;
	}

	public ManageContactPage enterdeliverylimit(String limit) {
		deliverylimit.clear();
		deliverylimit.sendKeys(limit);
		return this;
	}

	public ManageContactPage clickUpdate() {
		pageutility.javascriptExcecuter(driver, updatebutton);
		waitutility.elementTobeclikable(driver, updatebutton);
		updatebutton.click();
		return this;
	}

	public boolean issuccessalertdisplayed() {
		return successAlert.isDisplayed();

	}
}
