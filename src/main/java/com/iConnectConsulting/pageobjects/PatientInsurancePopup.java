package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.iConnectConsulting.util.WebUtil;

public class PatientInsurancePopup {

	public void clickAddNewInsuranceButton(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		WebUtil.click(driver, By.xpath("//span[text()='Add New']"));

	}

	public void clickNameInAddNewPatientInsurance(WebDriver driver) {
		WebUtil.click(driver, By.xpath(
				"//div//div//span[text()='*Name']/../following-sibling::div[@class='print-field order-form-field fieldfiller']"));

	}

	// public void getMaxNumberOfPages(WebDriver driver) {
	// WebUtil.getMaxNumber(driver, By.)
	//
	// }

}
