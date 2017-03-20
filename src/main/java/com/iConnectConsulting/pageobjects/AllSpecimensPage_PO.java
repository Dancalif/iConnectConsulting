package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllSpecimensPage_PO {

	public boolean ifAllSpecimensPageDisplayed(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='All Specimens']")).isDisplayed();
	}

}
