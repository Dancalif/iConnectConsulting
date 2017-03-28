package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage_PO {

	@FindBy(xpath = "//div[contains(text(), 'Hello')]")
	WebElement dashboardPageGreeting;

	public boolean ifdashBoardPageDisplayed(WebDriver driver) {
		return dashboardPageGreeting.isDisplayed();
	}

}
