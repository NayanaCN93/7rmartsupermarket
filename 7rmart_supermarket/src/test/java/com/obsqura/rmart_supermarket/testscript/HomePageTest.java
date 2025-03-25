package com.obsqura.rmart_supermarket.testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart_supermarket.constant.Constant;
import com.obsqura.rmart_supermarket.pages.HomePage;
import com.obsqura.rmart_supermarket.pages.LoginPage;

public class HomePageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;
  @Test
  public void verifyAdminCanLogout () {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin","admin");
	  homepage=loginpage.clicksignin();
	  homepage.clickonadmin().clicklogout();
	
	  boolean istitletext= homepage.istitledisplayed();
	  Assert.assertTrue(istitletext,Constant.ERRORMESSAGEFORLOGOUTFAILED);  
	  
	  }
	  
  }
 
