package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.iConnectConsulting.util.WebUtil;

public class SampleTemplateSelectionPopup_PO {

	@FindBy(xpath = "//li[text()='Precision Diagnostics']")
	WebElement precisionDiagnosticsOption;
	@FindBy(xpath = ".//*[@id='se_refresh_btn']")
	WebElement okButton;
	@FindBy(xpath = "//div[contains(@class, 'modal-header')]//h1[contains(@class, 'ng-binding')]")
	WebElement sampleTemplateSelectionPopup;
	@FindBy(xpath = "//li[text()='Precision Diagnostics Ellkay']")
	WebElement precisionDiagnosticsEllkayOption;

	public void selectTestRequisitionForm(WebDriver driver, String serviceForm) {
		if (serviceForm.equalsIgnoreCase("Precision")) {
			WebUtil.click(driver, precisionDiagnosticsOption);
		} else {
			WebUtil.click(driver, precisionDiagnosticsEllkayOption);
		}
		WebUtil.click(driver, okButton);
	}
}