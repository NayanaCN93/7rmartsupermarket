package com.obsqura.rmart_supermarket.testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart_supermarket.Utilities.ExelUtility;
import com.obsqura.rmart_supermarket.constant.Constant;
import com.obsqura.rmart_supermarket.pages.HomePage;
import com.obsqura.rmart_supermarket.pages.LoginPage;
import com.obsqura.rmart_supermarket.pages.ManageNewsPage;

public class ManageNewsPageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;
	public ManageNewsPage managenews;

	@Test
	public void verifyThatUserIsAbleToCreateNews() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExelUtility.readName(1, 0, "managenews");
		String password = ExelUtility.readName(1, 1, "managenews");
		loginpage.enterUsernameAndPassword(username, password);

		homepage = loginpage.clicksignin();
		managenews = homepage.clickmanagenewsmoreinfo();
		String news = ExelUtility.readName(1, 2, "managenews");
		managenews.clickonnewfield().enterNews(news).clickonSave();
		boolean alert = managenews.isAlertsuccessisdisplayed();
		Assert.assertTrue(alert, Constant.ERRORMESSAGEFORNOTTOBECREATED);
	}
}
