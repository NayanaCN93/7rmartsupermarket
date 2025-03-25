package com.obsqura.rmart_supermarket.testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart_supermarket.constant.Constant;
import com.obsqura.rmart_supermarket.pages.HomePage;
import com.obsqura.rmart_supermarket.pages.LoginPage;
import com.obsqura.rmart_supermarket.pages.SubcategoryPage;

public class SubcategoryPageTest extends Base {
public	LoginPage loginpage;
public HomePage homepage;
public SubcategoryPage subcategorypage;
  @Test
  public void verifyThatUserIsAbleToCreateSubcategory() {
	  
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin", "admin");
		homepage = loginpage.clicksignin();
		subcategorypage=homepage.clickonsubcategoryinfo();
		subcategorypage.clickonnew().enterSubcategoryDetails("Bag","longpage2").clickonsave();
		boolean alert=subcategorypage.issuccessalertdisplayed();
		Assert.assertTrue(alert,Constant.ERRORMESSAGEFORNOTTOBECREATED);
		//boolean alert2=subcategorypage.isexistalertisdisplayed();
		//Assert.assertTrue(alert2,"existing categroy again created");
  }
	  
  
}