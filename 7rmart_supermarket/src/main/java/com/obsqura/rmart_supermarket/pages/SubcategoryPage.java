package com.obsqura.rmart_supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.rmart_supermarket.Utilities.PageUtility;

public class SubcategoryPage {
	public WebDriver driver;
	PageUtility pageutility=new PageUtility();

	public SubcategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newField;
	@FindBy(xpath="//select[@id='cat_id']") WebElement selectCategory;
	@FindBy(xpath="//input[@id='subcategory']") WebElement entersubcategoryFeild;
	@FindBy(xpath="//input[@id='main_img']") WebElement choosefileField;
	@FindBy(xpath="//button[text()='Save']") WebElement saveField;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successalert;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement alreadyexistalert;
	public SubcategoryPage clickonnew() {
		 newField.click();
		 return this;
	}
	public SubcategoryPage enterSubcategoryDetails(String text,String subcategory) {
	pageutility.selectbyvisibleText(selectCategory,text);
	entersubcategoryFeild.sendKeys(subcategory);
	choosefileField.sendKeys("C:\\Users\\nayan\\OneDrive\\Desktop\\image of book\\longbook.jpg");
	
	return this;
	}
public SubcategoryPage clickonsave() {
	 saveField.click();
	 return this;
}
public boolean issuccessalertdisplayed() {
	return successalert.isDisplayed();
	
}
public boolean isexistalertisdisplayed() {
	return  alreadyexistalert.isDisplayed();
}

}

