package com.iConnectConsulting.util;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtil {

	public static void input(WebDriver driver, String s, WebElement element) {
		element.clear();
		element.sendKeys(s);
	}

	public static void click(WebDriver driver, WebElement element) {
		element.click();

	}

	public static void waitForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void verifyIfElementExists(WebDriver driver, WebElement element) {
		boolean ifDisplayed = element.isDisplayed();
		org.testng.Assert.assertTrue(ifDisplayed);
	}

	public static int randNumber(int maxNumber) {
		Random rand = new Random();
		int randomNumber = rand.nextInt(maxNumber);
		return randomNumber;
	}

	public static void getElementVisible(WebDriver driver, WebElement element) throws Exception {
		element.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			element.sendKeys(Keys.PAGE_UP);
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}

	}

	public static void clickHiddenElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static List<WebElement> createListOfElements(WebDriver driver, List<WebElement> elements) {
		List<WebElement> listOfElements = elements;
		return listOfElements;
	}
}