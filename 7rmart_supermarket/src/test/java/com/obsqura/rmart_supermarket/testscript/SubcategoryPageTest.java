package com.obsqura.rmart_supermarket.testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart_supermarket.Utilities.ExelUtility;
import com.obsqura.rmart_supermarket.Utilities.FakerUtility;
import com.obsqura.rmart_supermarket.constant.Constant;
import com.obsqura.rmart_supermarket.pages.HomePage;
import com.obsqura.rmart_supermarket.pages.LoginPage;
import com.obsqura.rmart_supermarket.pages.SubcategoryPage;

public class SubcategoryPageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;
	public SubcategoryPage subcategorypage;
	FakerUtility faker = new FakerUtility();

	@Test
	public void verifyThatUserIsAbleToCreateSubcategory() throws Exception {

		LoginPage loginpage = new LoginPage(driver);
		String username = ExelUtility.readName(1, 0, "subcategorypage");
		String password = ExelUtility.readName(1, 1, "subcategorypage");
		loginpage.enterUsernameAndPassword(username, password);
		homepage = loginpage.clicksignin();
		subcategorypage = homepage.clickonsubcategoryinfo();

		String category = ExelUtility.readName(1, 2, "subcategorypage");
		String subcategoryname = faker.getFakeCategoryName();// for get fake subcategory name ,in faker utility created
																// a method for fakecategory that is used here.
		//String subcategoryname = ExelUtility.readName(1, 3, "subcategorypage");
		subcategorypage.clickonnew().enterSubcategoryDetails(category, subcategoryname).clickonsave();
		boolean alert = subcategorypage.issuccessalertdisplayed();
		Assert.assertTrue(alert, Constant.ERRORMESSAGEFORNOTTOBECREATED);

	}

}