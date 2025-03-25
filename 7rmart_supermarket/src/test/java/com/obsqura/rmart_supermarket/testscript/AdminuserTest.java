package com.obsqura.rmart_supermarket.testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart_supermarket.Utilities.PageUtility;
import com.obsqura.rmart_supermarket.constant.Constant;
import com.obsqura.rmart_supermarket.pages.AdminUserPage;
import com.obsqura.rmart_supermarket.pages.HomePage;
import com.obsqura.rmart_supermarket.pages.LoginPage;

public class AdminuserTest extends Base{
	
	public LoginPage loginpage;
	public HomePage homepage;
	public AdminUserPage adminpage;
  @Test
  public void verifyUserAbleToCreatNewAdminuser() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin","admin");
	  homepage= loginpage.clicksignin();
	  adminpage=homepage.clickonmoreinfo();
	  adminpage.clickonnew().enteruserInfo("nayana99","ishaan",2).clickonsave();
	//adminpage.clickonnew().enteruserInfo("nayana100","ishaan","staff").clickonsave();
	  
	  boolean alertvalue=adminpage.checksuccesAlert();
	  Assert.assertTrue(alertvalue,Constant.ERRORMESSAGEFOREXCISTINGDATACREATED);
  }
  @Test
  
  public void verifyUserAbleToCreatExcistingAdminuser() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin","admin");
	  homepage=loginpage.clicksignin();
	  adminpage=homepage.clickonmoreinfo();
	  adminpage.clickonnew().enteruserInfo("nayana93","ishaan",2).clickonsave();
	 
	  
	  boolean alertvalue=adminpage.checkdangerAlert();
	  Assert.assertTrue(alertvalue,Constant.ERRORMESSAGEIFEXCITINGCRETED);
  }
  
}
