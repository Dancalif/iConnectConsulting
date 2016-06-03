package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage {
	public SignInPage signOut(WebDriver driver) {
		WebElement profileButton = driver.findElement(By
				.cssSelector("div[class='navbar-collapse collapse hidden-xs main-navigation__top'] > ul > li > a > i"));
		profileButton.click();
		WebElement signoutButton = driver.findElement(By.linkText("Logout"));
		signoutButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).isDisplayed();
		return PageFactory.initElements(driver, SignInPage.class);
	}

	public boolean doesDashboardExist(WebDriver driver) {
		return driver.findElement(By.cssSelector("a[href='#/dashboard']")).isDisplayed();
	}

	public TestOrderPage clickTestOrderButton(WebDriver driver) {
		WebElement testOrder = driver.findElement(By.cssSelector("a[href='#/test-order']"));
		testOrder.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input")));
		return PageFactory.initElements(driver, TestOrderPage.class);
	}
}
