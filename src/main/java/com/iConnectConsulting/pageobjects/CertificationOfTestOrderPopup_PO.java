package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.iConnectConsulting.util.WebUtil;

public class CertificationOfTestOrderPopup_PO {
	
	@FindBy(xpath = "//span[text()='Agree']")
	WebElement agreeButton;

	public void clickAgreeButton(WebDriver driver) throws InterruptedException {
		WebUtil.click(driver, agreeButton);
		Thread.sleep(2000);
	}

}
