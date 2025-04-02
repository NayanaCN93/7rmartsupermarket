package com.obsqura.rmart_supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.rmart_supermarket.Utilities.PageUtility;

public class AdminUserPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class=\"btn btn-rounded btn-danger\"]")
	WebElement newField;
	@FindBy(xpath = "//input[@id='username']")
	WebElement usersnameField;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;
	@FindBy(xpath = "//select[@name='user_type']")
	WebElement usertypeField;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveField;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement dangeralert;
	@FindBy(xpath = "//div[@class=\"alert alert-success alert-dismissible\"]")
	WebElement successalert;
	@FindBy(xpath="(//i[@class=\'fas fa-trash-alt\'])[1]") WebElement deleteFirstUserintheList;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement deletesuccessalert;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement searchuser;
	@FindBy(xpath="(//input[@class='form-control'])[1]") WebElement usernameforsearch;
	@FindBy(xpath="(//select[@class=\"form-control\"])[1]")WebElement usertypeFeildforserach;
	@FindBy(xpath="//button[@name='Search']")WebElement clickSearchAfterdata;
	@FindBy(xpath="//td[text()='Nayana93']")WebElement searchresult;
	public AdminUserPage clickonnew() {
		newField.click();
		return this;
	}

	public AdminUserPage enteruserInfo(String username, String password, int num) {
		usersnameField.sendKeys(username);
		passwordField.sendKeys(password);
		pageutility.selectbyIndex(usertypeField, num);
		return this;
	}

	public AdminUserPage clickonsave() {
		saveField.click();
		return this;
	}
	public AdminUserPage clickdeletbutton() {
		deleteFirstUserintheList.click();
		driver.switchTo().alert().accept();
		return this;
	}
public boolean isdeletesuccessisShows() {
	return  deletesuccessalert.isDisplayed();
	
}
public AdminUserPage selectsearchAndEnterdataforsearch(String username,String usertype) {
	 searchuser.click();
	 usernameforsearch.sendKeys(username);
	 pageutility.selectbyvisibleText( usertypeFeildforserach, usertype);
	 
	 clickSearchAfterdata.click();
	 return this;
}
public boolean issearchresultappers() {
	return searchresult.isDisplayed();
	
}
	public boolean checksuccesAlert() {
		boolean alerttext = successalert.isDisplayed();
		return alerttext;
	}

	public boolean checkdangerAlert() {
		boolean alerttext = dangeralert.isDisplayed();
		return alerttext;
	}

		
	}

