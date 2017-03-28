package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.iConnectConsulting.data.UserData;
import com.iConnectConsulting.util.WebUtil;

public class SignInPage_PO {

	@FindBy(id = "username")
	WebElement usernameTextfield;
	@FindBy(name = "password")
	WebElement passwordTextfield;
	@FindBy(xpath = "//*[@type='submit']")
	WebElement submitButton;

	public boolean doesUsernameExist(WebDriver driver) {
		return usernameTextfield.isDisplayed();
	}

	public void login(WebDriver driver, UserData user) throws InterruptedException {
		// Fill in username
		WebUtil.input(driver, user.userName, usernameTextfield);
		// Fill in password
		WebUtil.input(driver, user.password, passwordTextfield);
		WebUtil.click(driver, submitButton);
	}
}
