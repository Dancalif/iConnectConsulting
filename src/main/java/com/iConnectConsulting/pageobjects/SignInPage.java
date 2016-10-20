package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.iConnectConsulting.data.UserData;
import com.iConnectConsulting.util.WebUtil;

public class SignInPage {

	public DashBoardPage clickSignInButton(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		WebUtil.click(driver, By.xpath("//*[@type='submit']"));
		WebUtil.waitForElementVisible(driver, By.cssSelector("a[href='#/dashboard']"));
		return PageFactory.initElements(driver, DashBoardPage.class);
	}

	public boolean doesUsernameExist(WebDriver driver) {
		return driver.findElement(By.id("username")).isDisplayed();
	}

	public DashBoardPage login(WebDriver driver, UserData user) throws InterruptedException {
		// Fill in username
		WebUtil.input(driver, user.userName, By.id("username"));
		// Fill in password
		Thread.sleep(1000);
		WebUtil.input(driver, user.password, By.name("password"));
		Thread.sleep(1000);
		return PageFactory.initElements(driver, DashBoardPage.class);

	}
}
