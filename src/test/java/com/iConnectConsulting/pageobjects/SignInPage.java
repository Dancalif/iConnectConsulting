package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.iConnectConsulting.util.WebUtil;

public class SignInPage {
	public void fillInUserName(WebDriver driver, String s) {
		WebUtil.input(driver, s, By.id("username"));
	}

	public void fillInPassword(WebDriver driver, String s) {
		WebUtil.input(driver, s, By.name("password"));
	}

	public DashBoardPage clickSignInButton(WebDriver driver) {
		WebUtil.click(driver, By.xpath("//*[@type='submit']"));
		WebUtil.waitForElementVisible(driver, By.cssSelector("a[href='#/dashboard']"));
		return PageFactory.initElements(driver, DashBoardPage.class);
	}

	public boolean doesUsernameExist(WebDriver driver) {
		return driver.findElement(By.id("username")).isDisplayed();
	}
}
