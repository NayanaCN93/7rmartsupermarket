package com.obsqura.rmart_supermarket.testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart_supermarket.Utilities.ExelUtility;
import com.obsqura.rmart_supermarket.Utilities.FakerUtility;
import com.obsqura.rmart_supermarket.constant.Constant;
import com.obsqura.rmart_supermarket.pages.CategoryPage;
import com.obsqura.rmart_supermarket.pages.HomePage;
import com.obsqura.rmart_supermarket.pages.LoginPage;

public class CategoryPageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;
	public CategoryPage categorypage;
	FakerUtility faker=new FakerUtility();

	@Test(retryAnalyzer = com.obsqura.rmart_supermarket.retry.Retry.class)
	public void verifythatUserCanCreateNewCategory() throws AWTException, Exception {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExelUtility.readName(1, 0, "Categorypage");
		String password = ExelUtility.readName(1, 1, "Categorypage");
		loginpage.enterUsernameAndPassword(username, password);

		homepage = loginpage.clicksignin();
		categorypage = homepage.clickcatogorynmoreinfo();
		  String category=faker.getFakeCategoryName();
		//String category = ExelUtility.readName(1, 2, "Categorypage");
		categorypage.clickonNew().entercategrydetails(category).clickonsave();
		
		boolean alert2 = categorypage.issuccessalertisdisplayed();
		Assert.assertTrue(alert2, Constant.ERRORMESSAGEFOREXCISTINGDATACREATED);

	}
}
