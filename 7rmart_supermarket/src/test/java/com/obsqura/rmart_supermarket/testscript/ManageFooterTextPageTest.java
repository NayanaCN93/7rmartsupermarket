package com.obsqura.rmart_supermarket.testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart_supermarket.constant.Constant;
import com.obsqura.rmart_supermarket.pages.HomePage;
import com.obsqura.rmart_supermarket.pages.LoginPage;
import com.obsqura.rmart_supermarket.pages.ManageFooterTextPage;

public class ManageFooterTextPageTest extends Base{
	public LoginPage loginpage;
	public HomePage homepage;
	public ManageFooterTextPage footertextpage;
  @Test
  public void verifyWhetherUserAbleToEditFooterdata () {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin","admin");
	  homepage=loginpage.clicksignin();
	  footertextpage=homepage.clickfootermoreinfo();
	  footertextpage.clickonedit();
	  footertextpage.editfooterdata("Sreyes traders,kochi","sreyes@gmail.com","9876459010").clickOnUbdate();
	  boolean alert=footertextpage.isAlertDisplayed();
	  Assert.assertTrue(alert,Constant.ERRORMESSAGEEDITDATANOTALLOWED);
  }
}
