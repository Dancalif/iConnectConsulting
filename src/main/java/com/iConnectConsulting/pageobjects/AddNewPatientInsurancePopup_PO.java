package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.iConnectConsulting.util.WebUtil;

public class AddNewPatientInsurancePopup_PO {
	
	@FindBy(xpath = "//div//div//span[text()='*Name']/../following-sibling::div[@class='print-field order-form-field fieldfiller']")
	WebElement nameTextfield;
	@FindBy(xpath = "//button[@class='btn btn-primary btn-form-md']//span[text()='Submit']")
	WebElement submitButton;
	
	public void clickNameInAddNewPatientInsurance(WebDriver driver) {
		WebUtil.click(driver, nameTextfield);
	}

	public void clickSubmitButton(WebDriver driver) throws InterruptedException {
		WebUtil.click(driver, submitButton);
		Thread.sleep(2000);
	}
}
