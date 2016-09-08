package com.iConnectConsulting.util;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtil {

	public static void input(WebDriver driver, String s, By locator) {
		WebElement inputField = driver.findElement(locator);
		inputField.clear();
		inputField.sendKeys(s);
	}

	public static void click(WebDriver driver, By locator) {
		WebElement clickableElement = driver.findElement(locator);
		clickableElement.click();

	}

	public static void waitForElementVisible(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void verifyIfElementExists(WebDriver driver, By locator) {
		WebElement elementToBeFound = driver.findElement(locator);
		boolean ifDisplayed = elementToBeFound.isDisplayed();
		org.testng.Assert.assertTrue(ifDisplayed);
	}

	public static int randNumber(int maxNumber) {
		Random rand = new Random();
		int randomNumber = rand.nextInt(maxNumber);
		return randomNumber;
	}

	public static void getElementVisible(WebDriver driver, By locator) throws Exception {
		WebElement elmentToBeVisible = driver.findElement(locator);

		elmentToBeVisible.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			elmentToBeVisible.sendKeys(Keys.PAGE_UP);
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}

		// try {
		// elmentToBeVisible.click();
		// } catch (Exception e) {
		// elmentToBeVisible.sendKeys(Keys.PAGE_UP);
		// }
		//
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void clickHiddenElement(WebDriver driver, By locator) {
		WebElement elementToClik = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", elementToClik);

	}
}