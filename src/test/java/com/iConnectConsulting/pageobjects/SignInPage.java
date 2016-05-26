package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

	public void fillInUserName(WebDriver driver, String s) {
		WebElement usernameTextField = driver.findElement(By.id("username"));
		usernameTextField.clear();
		usernameTextField.sendKeys(s);
	}

	public void fillInPassword(WebDriver driver, String s) {
		WebElement passwordTextField = driver.findElement(By.name("password"));
		passwordTextField.clear();
		passwordTextField.sendKeys(s);
	}

	public DashBoardPage clickSignInButton(WebDriver driver) {
		WebElement signInButton = driver.findElement(By.xpath("//*[@type='submit']"));
		signInButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='#/dashboard']")));
		return PageFactory.initElements(driver, DashBoardPage.class);
	}

	public boolean isUsernameExist(WebDriver driver) {
		return driver.findElement(By.id("username")).isDisplayed();
	}
}
