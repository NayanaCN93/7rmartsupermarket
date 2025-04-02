package com.obsqura.rmart_supermarket.testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart_supermarket.Utilities.ExelUtility;
import com.obsqura.rmart_supermarket.Utilities.FakerUtility;
import com.obsqura.rmart_supermarket.Utilities.PageUtility;
import com.obsqura.rmart_supermarket.constant.Constant;
import com.obsqura.rmart_supermarket.pages.AdminUserPage;
import com.obsqura.rmart_supermarket.pages.HomePage;
import com.obsqura.rmart_supermarket.pages.LoginPage;

public class AdminuserTest extends Base{
	public LoginPage loginpage;
	public HomePage homepage;
	public AdminUserPage adminpage;
	FakerUtility faker=new FakerUtility();
  @Test
  public void verifyUserAbleToCreatNewAdminuser() throws Exception {
	  LoginPage loginpage=new LoginPage(driver);
	  String username=ExelUtility.readName(1, 0,"adminuserpage");
	  String password=ExelUtility.readName(1, 1,"adminuserpage");
	  loginpage.enterUsernameAndPassword(username,password);
	  homepage= loginpage.clicksignin();
	  adminpage=homepage.clickonmoreinfo();
	 // String name=ExelUtility.readName(1, 2, "adminuserpage");
	  String name=faker.getFakeFirstName();//create fake user ,for do not fail testcase when run it again
	  String pw=ExelUtility.readName(1, 3, "adminuserpage");
	  //String index=ExelUtility.getId(1, 4, "adminuserpage");
	  adminpage.clickonnew().enteruserInfo(name,pw,2).clickonsave();
	  boolean alertvalue=adminpage.checksuccesAlert();
	  Assert.assertTrue(alertvalue,Constant.ERRORMESSAGEFOREXCISTINGDATACREATED);
  }
  @Test
  	  public void verifyUserAbleToCreatExcistingAdminuser() throws Exception {
	  LoginPage loginpage=new LoginPage(driver);
	  String username=ExelUtility.readName(1, 0,"adminuserpage");
	  String password=ExelUtility.readName(1, 1,"adminuserpage");
	  loginpage.enterUsernameAndPassword(username,password);
	  homepage=loginpage.clicksignin();
	  adminpage=homepage.clickonmoreinfo();
	  String name=ExelUtility.readName(2, 2, "adminuserpage");
	  String pw=ExelUtility.readName(2, 3, "adminuserpage");
	  adminpage.clickonnew().enteruserInfo(name,pw,2).clickonsave();
	  boolean alertvalue=adminpage.checkdangerAlert();
	  Assert.assertTrue(alertvalue,Constant.ERRORMESSAGEIFEXCITINGCRETED);
  }
  @Test
  
  public void verifyThatAdminIsAbleToDeleteAUser() throws Exception {
	  LoginPage loginpage=new LoginPage(driver);
	  String username=ExelUtility.readName(1, 0,"adminuserpage");
	  String password=ExelUtility.readName(1, 1,"adminuserpage");
	  loginpage.enterUsernameAndPassword(username,password);
	  homepage=loginpage.clicksignin();
	  adminpage=homepage.clickonmoreinfo();
	  adminpage.clickdeletbutton();
	  boolean alert=adminpage.isdeletesuccessisShows();
	  Assert.assertTrue(alert,Constant.ERRORMESSAGEFORDELETIONISFAILED);
  }
  @Test
  
  public void verifyThatAdmincanSearchUser() throws IOException {
	  LoginPage loginpage=new LoginPage(driver);
	  String username=ExelUtility.readName(1, 0,"adminuserpage");
	  String password=ExelUtility.readName(1, 1,"adminuserpage");
	  loginpage.enterUsernameAndPassword(username,password);
	  homepage=loginpage.clicksignin();
	  adminpage=homepage.clickonmoreinfo();
	  String usernameforsearch=ExelUtility.readName(1, 5,"adminuserpage");
	  String usertype=ExelUtility.readName(1, 6,"adminuserpage");
	  adminpage.selectsearchAndEnterdataforsearch(usernameforsearch, usertype);
	  boolean searchresult=adminpage.issearchresultappers();
	  Assert.assertTrue(searchresult,"cannot search");
  }
  
}
