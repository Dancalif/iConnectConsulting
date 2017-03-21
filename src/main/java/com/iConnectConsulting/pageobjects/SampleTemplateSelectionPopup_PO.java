package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.iConnectConsulting.util.WebUtil;

public class SampleTemplateSelectionPopup_PO {
	
	@FindBy(xpath = "//li[text()='Precision Diagnostics']")
	WebElement precisionDiagnosticsOption;
	@FindBy(xpath = ".//*[@id='se_refresh_btn']")
	WebElement okButton;
	@FindBy(xpath = "//div[contains(@class, 'modal-header')]//h1[contains(@class, 'ng-binding')]")
	WebElement sampleTemplateSelectionPopup;
	
	
	public void clickPrecisionDiagnostics(WebDriver driver) {
		WebUtil.click(driver, precisionDiagnosticsOption);
		WebUtil.click(driver, okButton);
	}
}
