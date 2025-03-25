package com.obsqura.rmart_supermarket.testscript;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart_supermarket.constant.Constant;
import com.obsqura.rmart_supermarket.pages.CategoryPage;
import com.obsqura.rmart_supermarket.pages.HomePage;
import com.obsqura.rmart_supermarket.pages.LoginPage;

public class CategoryPageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;
	public CategoryPage categorypage;
  @Test
  public void verifythatUserCanCreateNewCategory() throws AWTException {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin","admin");
	  homepage=loginpage.clicksignin();
	  categorypage=homepage.clickcatogorynmoreinfo();
	  categorypage.clickonNew().entercategrydetails("Book").clickonsave();
	 // boolean alert=categorypage.isexistalertdisplayed();
	//  Assert.assertTrue(alert,"existing category again created");
	  boolean alert2=categorypage.issuccessalertisdisplayed();
	  Assert.assertTrue(alert2,Constant.ERRORMESSAGEFOREXCISTINGDATACREATED);
	  
  }
}   
