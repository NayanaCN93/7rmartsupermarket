package com.obsqura.rmart_supermarket.Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public WebDriver driver;

	public void selectbyIndex(WebElement element, int num) {
		Select select = new Select(element);
		select.selectByIndex(num);
	}

	public void selectbyvisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectbyValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);

	}

	public void javascriptExcevuter(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,150000)");
	}

	public void actionclass(WebElement dragable1, WebElement dragable2) {
		Actions action = new Actions(driver);
		action.moveToElement(dragable2);
		action.doubleClick(dragable1).perform();
		action.dragAndDrop(dragable1, dragable2).build().perform();
	}
	public void roboClass(WebDriver driver,WebElement element) throws AWTException {
		StringSelection selection=new StringSelection("C:\\Users\\nayan\\OneDrive\\Desktop\\image of book\\bookimage.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
		Robot robo=new Robot();
		robo.delay(2000);
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		
	}
}
