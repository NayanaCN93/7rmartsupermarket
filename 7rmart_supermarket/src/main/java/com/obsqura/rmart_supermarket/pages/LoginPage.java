package com.obsqura.rmart_supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@placeholder='Username']") WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement password;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']") WebElement signinbutton;
	@FindBy(xpath="//p[text()='Sign in to start your session']") WebElement signintexttitle;
	
	
	
	public LoginPage enterUsernameAndPassword(String usernamefeild,String passwordfeild) {
		username.sendKeys(usernamefeild);
		password.sendKeys(passwordfeild);
		return this;
	}

	public HomePage clicksignin() {
		signinbutton.click();
		return new HomePage(driver);
	}
	public boolean isSigninTextAppears() {
		return signintexttitle.isDisplayed();
	}
}
