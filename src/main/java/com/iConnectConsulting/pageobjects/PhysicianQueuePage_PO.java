package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PhysicianQueuePage_PO {

	public boolean ifPhysicianQueuePageDisplayed(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='Physician Queue']")).isDisplayed();
	}

}
