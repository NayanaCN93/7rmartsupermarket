package com.obsqura.rmart_supermarket.testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart_supermarket.Utilities.ExelUtility;
import com.obsqura.rmart_supermarket.constant.Constant;
import com.obsqura.rmart_supermarket.pages.HomePage;
import com.obsqura.rmart_supermarket.pages.LoginPage;
import com.obsqura.rmart_supermarket.pages.ManageProductPage;

public class ManageProductPageTest extends Base {
	public LoginPage loginpage;
	public HomePage homepage;
	public ManageProductPage manageproduct;

	@Test
	public void verifyWhetherUserIsAbelToSearchProduct() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExelUtility.readName(1, 0, "Manageproductpage");
		String password = ExelUtility.readName(1, 1, "Manageproductpage");
		loginpage.enterUsernameAndPassword(username, password);
		homepage = loginpage.clicksignin();
		manageproduct = homepage.clickonproductinfo();
		String title = ExelUtility.readName(1, 2, "Manageproductpage");
		String pcode = ExelUtility.readName(1, 3, "Manageproductpage");
		String category = ExelUtility.readName(1, 4, "Manageproductpage");
		String subcategory = ExelUtility.readName(1, 5, "Manageproductpage");
		manageproduct.clickonsearch().enterproductTitleAndCode(title, pcode).selectcategory(category)
				.selectsubcategory(subcategory).clickonsearchbutton();
		boolean searchListTableHeader = manageproduct.isTableheaderAppears();
		Assert.assertTrue(searchListTableHeader,Constant.ERROEMESSAGEFORSEARCHISFAILED);
	}
}
