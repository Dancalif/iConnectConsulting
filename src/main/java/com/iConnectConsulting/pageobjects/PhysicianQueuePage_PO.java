package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhysicianQueuePage_PO {

	@FindBy(xpath = "//span[text()='Physician Queue']")
	WebElement physicianQueuePageTitle;
	
	public boolean ifPhysicianQueuePageDisplayed(WebDriver driver) {
		return physicianQueuePageTitle.isDisplayed();
	}

}
