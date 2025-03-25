package com.obsqura.rmart_supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.rmart_supermarket.Utilities.PageUtility;

public class AdminUserPage {
	public WebDriver driver;
	PageUtility pageutility=new PageUtility();
	
	public AdminUserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@class=\"btn btn-rounded btn-danger\"]") WebElement newField;
	@FindBy(xpath="//input[@id='username']") WebElement usersnameField;
    @FindBy(xpath="//input[@id='password']") WebElement passwordField;
    @FindBy(xpath="//select[@name='user_type']") WebElement usertypeField;
    @FindBy(xpath="//button[@name='Create']") WebElement saveField;
    @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement dangeralert;
    @FindBy(xpath="//div[@class=\"alert alert-success alert-dismissible\"]") WebElement successalert;
    
    
   
    public AdminUserPage clickonnew() {
    	newField.click();
    	return this;
    }
   public AdminUserPage enteruserInfo(String username,String password,int num) {
    	usersnameField.sendKeys(username);
    	passwordField.sendKeys(password);
    	pageutility.selectbyIndex(usertypeField, num);
    	return this;
    }
  /*  public AdminUserPage enteruserInfo(String username,String password,String value) {
    	usersnameField.sendKeys(username);
    	passwordField.sendKeys(password);
    	pageutility.selectbyValue(usertypeField,value);
    	return this;
    }
*/
    public AdminUserPage clickonsave() {
    	saveField.click();
    	return this;
    }
    public boolean checksuccesAlert() {
    	boolean alerttext=successalert.isDisplayed();
    	return alerttext;
    }
    public boolean checkdangerAlert() {
    	boolean alerttext=dangeralert.isDisplayed();
    	return alerttext;
    }
}  


