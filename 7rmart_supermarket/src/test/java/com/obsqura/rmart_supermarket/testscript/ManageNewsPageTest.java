package com.obsqura.rmart_supermarket.testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart_supermarket.constant.Constant;
import com.obsqura.rmart_supermarket.pages.HomePage;
import com.obsqura.rmart_supermarket.pages.LoginPage;
import com.obsqura.rmart_supermarket.pages.ManageNewsPage;

public class ManageNewsPageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;
	public ManageNewsPage managenews;

	@Test
	public void verifyThatUserIsAbleToCreateNews() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameAndPassword("admin", "admin");
		homepage = loginpage.clicksignin();
		managenews = homepage.clickmanagenewsmoreinfo();
		managenews.clickonnewfield().enterNews("Books have 30% discout").clickonSave();
		boolean alert = managenews.isAlertsuccessisdisplayed();
		Assert.assertTrue(alert,Constant.ERRORMESSAGEFORNOTTOBECREATED);
	}
}
