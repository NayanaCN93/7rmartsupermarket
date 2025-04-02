package com.obsqura.rmart_supermarket.testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart_supermarket.Utilities.ExelUtility;
import com.obsqura.rmart_supermarket.constant.Constant;
import com.obsqura.rmart_supermarket.pages.HomePage;
import com.obsqura.rmart_supermarket.pages.LoginPage;
import com.obsqura.rmart_supermarket.pages.ManageContactPage;

public class ManageContactPageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;
	public ManageContactPage managecontact;

	@Test
	public void verifyThatUserIsAbleToEditContactDEtails() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExelUtility.readName(1, 0, "Managecontactpage");
		String password = ExelUtility.readName(1, 1, "Managecontactpage");
		loginpage.enterUsernameAndPassword(username, password);
		homepage = loginpage.clicksignin();
		managecontact = homepage.clickoncontactinfo();

		String phone = ExelUtility.getId(1, 2, "Managecontactpage");
		String email = ExelUtility.readName(1, 3, "Managecontactpage");
		String address = ExelUtility.readName(1, 4, "Managecontactpage");
		String deltime = ExelUtility.getId(1, 5, "Managecontactpage");
		String dellimit = ExelUtility.getId(1, 6, "Managecontactpage");
		managecontact.clickedit().enterphonenumber(phone).enteremail(email).enteraddress(address)
				.enterdeliveryTime(deltime).enterdeliverylimit(dellimit).clickUpdate();
		boolean isedited = managecontact.issuccessalertdisplayed();
		Assert.assertTrue(isedited,Constant.ERRORMESSAGEEDITDATANOTALLOWED);
	}
}
