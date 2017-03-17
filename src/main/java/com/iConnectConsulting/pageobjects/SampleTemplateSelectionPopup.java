package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.iConnectConsulting.util.WebUtil;

public class SampleTemplateSelectionPopup {
	
	@FindBy(how = How.XPATH, using = "//li[text()='Precision Diagnostics']")
	WebElement precisionDiagnosticsOption;
	@FindBy(how = How.XPATH, using = ".//*[@id='se_refresh_btn']")
	WebElement okButton;
	
	public void clickPrecisionDiagnostics(WebDriver driver) {
		WebUtil.click(driver, precisionDiagnosticsOption);
		WebUtil.click(driver, okButton);
	}
}
