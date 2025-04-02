package com.obsqura.rmart_supermarket.testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart_supermarket.Utilities.ExelUtility;
import com.obsqura.rmart_supermarket.constant.Constant;
import com.obsqura.rmart_supermarket.pages.HomePage;
import com.obsqura.rmart_supermarket.pages.LoginPage;
import com.obsqura.rmart_supermarket.pages.ManageFooterTextPage;

public class ManageFooterTextPageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;
	public ManageFooterTextPage footertextpage;

	@Test
	public void verifyWhetherUserAbleToEditFooterdata() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExelUtility.readName(1, 0, "Managefooterpage");
		String password = ExelUtility.readName(1, 1, "Managefooterpage");
		loginpage.enterUsernameAndPassword(username, password);

		homepage = loginpage.clicksignin();
		footertextpage = homepage.clickfootermoreinfo();
		footertextpage.clickonedit();
		String address = ExelUtility.readName(1, 2, "Managefooterpage");

		String email = ExelUtility.readName(1, 3, "Managefooterpage");
		String phonenumber = ExelUtility.getId(1, 4, "Managefooterpage");

		footertextpage.editfooterdata(address, email," 897898654").clickOnUbdate();
		boolean alert = footertextpage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.ERRORMESSAGEEDITDATANOTALLOWED);
	}
}
