package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.iConnectConsulting.util.WebUtil;

public class PatientInsurancePopup_PO {
	
	@FindBy(xpath = "//span[text()='Add New']")
	WebElement addNewInsuranceButton;

	public void clickAddNewInsuranceButton(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		WebUtil.click(driver, addNewInsuranceButton);
		Thread.sleep(1000);
	}

	

	// public void getMaxNumberOfPages(WebDriver driver) {
	// WebUtil.getMaxNumber(driver, By.)
	//
	// }

}
