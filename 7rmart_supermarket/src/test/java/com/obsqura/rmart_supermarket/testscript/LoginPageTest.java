package com.obsqura.rmart_supermarket.testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.rmart_supermarket.Utilities.ExelUtility;
import com.obsqura.rmart_supermarket.constant.Constant;
import com.obsqura.rmart_supermarket.pages.HomePage;
import com.obsqura.rmart_supermarket.pages.LoginPage;

public class LoginPageTest extends Base{
	public LoginPage loginpage;
	public HomePage homepage;
	
  @Test(groups="smoke")
  public void validUsernameAndPassword() throws Exception {
	  LoginPage loginpage=new LoginPage(driver);
		String username = ExelUtility.readName(1, 0, "Loginpage");
		String password = ExelUtility.readName(1, 1, "Loginpage");
		loginpage.enterUsernameAndPassword(username, password);
	  
	  homepage=loginpage.clicksignin();
	  
	  String expected="Dashboard | 7rmart supermarket";
	  String actual=driver.getTitle();
	  System.out.println(actual);
	  Assert.assertEquals(actual,expected,Constant.ERRORMESSAGEFORLOGIN);
  }
  @Test(groups="smoke")
  public void InvalidUsernameAndPassword() throws Exception {
	  LoginPage loginpage=new LoginPage(driver);
	  String username=ExelUtility.getId(2,0,"Loginpage");//getid is for numeric value
	  String password=ExelUtility.readName(2,1,"Loginpage");
	  loginpage.enterUsernameAndPassword(username,password);
	 homepage= loginpage.clicksignin();
	  
	  boolean textinthetop=loginpage.isSigninTextAppears();
	  Assert.assertTrue(textinthetop,Constant.ERRORMESSAGEWHILELOGINWITHINVALIDCREDENTIALS);
	
  }
  @Test
  @Parameters({"username","password"})
  public void ValidUsernameAndInvalidPassword(String username,String password) {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword(username,password);
	 homepage= loginpage.clicksignin();
	  
	  boolean textinthetop=loginpage.isSigninTextAppears();
      Assert.assertTrue(textinthetop,Constant.ERRORMESSAGEWHILELOGINWITHINVALIDCREDENTIALS);
  }
  @Test(dataProvider = "credentials")
   public void InvaliedUsernameAndValidPAssword(String username,String password) 
  {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword(username,password);
	  homepage=loginpage.clicksignin();
	 
	  boolean textinthetop=loginpage.isSigninTextAppears();
	  Assert.assertTrue(textinthetop,Constant.ERRORMESSAGEWHILELOGINWITHINVALIDCREDENTIALS);
  }

  @DataProvider(name="credentials")
  public Object[][] testdata(){
	  Object data[][]= {{"1","admin"},{"2","admin"},{"admin","admin"}};//one set credential given both valid for assertion check
	  return data;
  }
	  }
