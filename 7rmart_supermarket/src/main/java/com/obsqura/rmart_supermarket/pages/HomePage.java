package com.obsqura.rmart_supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminicon;
	@FindBy(xpath = "//a[@class=\"dropdown-item\"][2]")
	WebElement logoutbutton;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement titletext;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]")
	WebElement adminuserinfo;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'])[2]")
	WebElement categoryinfo;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'])[2]")
	WebElement managenewsinfo;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'])[2]")
	WebElement subcategoryinfo;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'])[2]")
	WebElement footermoreinfo;
	public HomePage clickonadmin() {
		adminicon.click();
		return this;
	}

	public HomePage clicklogout() {
		logoutbutton.click();
		return this;
	}

	public boolean istitledisplayed() {
		return titletext.isDisplayed();
	}

	public AdminUserPage clickonmoreinfo() {
		adminuserinfo.click();
		return new AdminUserPage(driver);
	}

	public CategoryPage clickcatogorynmoreinfo() {
		categoryinfo.click();
		return new CategoryPage(driver);

	}

	public ManageNewsPage clickmanagenewsmoreinfo() {
		managenewsinfo.click();
		return new ManageNewsPage(driver);

	}

	public SubcategoryPage clickonsubcategoryinfo() {
		subcategoryinfo.click();
		return new SubcategoryPage(driver);
	}
	public ManageFooterTextPage clickfootermoreinfo() {
		footermoreinfo.click();
		return new ManageFooterTextPage(driver);
	}
}
