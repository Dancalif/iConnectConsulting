package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.iConnectConsulting.data.UserData;
import com.iConnectConsulting.util.WebUtil;

public class SignInPage_PO {
	
	@FindBy(id = "username")
	WebElement usernameTextfield;
	@FindBy(name = "password")
	WebElement passwordTextfield;
	@FindBy(xpath = "//*[@type='submit']")
	WebElement submitButton;
	@FindBy(css = "a[href='#/dashboard']")
	WebElement dashboardTab;


	public void clickSignInButton(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		WebUtil.click(driver, submitButton);
		WebUtil.waitForElementVisible(driver, dashboardTab);
	}

	public boolean doesUsernameExist(WebDriver driver) {
		return driver.findElement(By.id("username")).isDisplayed();
	}

	public void login(WebDriver driver, UserData user) throws InterruptedException {
		// Fill in username
		WebUtil.input(driver, user.userName, usernameTextfield);
		// Fill in password
		Thread.sleep(1000);
		WebUtil.input(driver, user.password, passwordTextfield);
		Thread.sleep(1000);
	}
}
