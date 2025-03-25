package com.obsqura.rmart_supermarket.testscript;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.rmart_supermarket.constant.Constant;
import com.obsqura.rmart_supermarket.pages.HomePage;
import com.obsqura.rmart_supermarket.pages.LoginPage;

public class LoginPageTest extends Base{
	public HomePage homepage;
	
  @Test
  public void validUsernameAndPassword() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin","admin");
	  homepage=loginpage.clicksignin();
	  
	  String actual="Dashboard | 7rmart supermarket";
	  String expected=driver.getTitle();
	  Assert.assertEquals(actual,expected,Constant.ERRORMESSAGEFORLOGIN);
  }
  @Test
  public void InvalidUsernameAndPassword() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("123","admin2");
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
