package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllSpecimensPage_PO {

	@FindBy(xpath = "//span[text()='All Specimens']")
	WebElement allSpecimensPageTitle;

	public boolean ifAllSpecimensPageDisplayed(WebDriver driver) {
		return allSpecimensPageTitle.isDisplayed();
	}

}
