package com.obsqura.rmart_supermarket.testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart_supermarket.Utilities.ExelUtility;
import com.obsqura.rmart_supermarket.constant.Constant;
import com.obsqura.rmart_supermarket.pages.HomePage;
import com.obsqura.rmart_supermarket.pages.LoginPage;

public class HomePageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;

	@Test
	public void verifyAdminCanLogout() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExelUtility.readName(1, 0, "Homepage");
		String password = ExelUtility.readName(1, 1, "Homepage");
		loginpage.enterUsernameAndPassword(username, password);
		homepage = loginpage.clicksignin();
		homepage.clickonadmin().clicklogout();

		boolean istitletext = homepage.istitledisplayed();
		Assert.assertTrue(istitletext, Constant.ERRORMESSAGEFORLOGOUTFAILED);

	}

}
