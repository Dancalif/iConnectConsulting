package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.iConnectConsulting.util.WebUtil;

public class CertificationOfTestOrderPopup_PO {

	@FindBy(xpath = "//span[text()='Agree']")
	WebElement agreeButton;

	public void clickAgreeButton(WebDriver driver) throws InterruptedException {
		WebUtil.waitForElementVisible(driver, agreeButton);
		WebUtil.click(driver, agreeButton);
		Thread.sleep(2000);
	}
}