package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.iConnectConsulting.util.WebUtil;

public class OrderPlacedPopup_PO {
	
	@FindBy(xpath = "//div[contains(@class,'modal-header')]/h1")
	WebElement orderPlacedTitle;
	@FindBy(xpath = "//div[@class='modal-body']/div/p/b")
	WebElement testOrderName;
	@FindBy(xpath = "//span[text()='Print']")
	WebElement printButton;
	@FindBy(xpath = "//span[text()='OK']")
	WebElement okButton;

	public String doesOrderPlacedExist(WebDriver driver) {
		WebUtil.waitForElementVisible(driver, orderPlacedTitle);
		return orderPlacedTitle.getText();
	}

	public String doesNameUnderOrderMatch(WebDriver driver) {
		WebUtil.waitForElementVisible(driver, testOrderName);
		return testOrderName.getText();
	}

	public void clickOkButton(WebDriver driver) {
		WebUtil.click(driver, okButton);
	}

	public void doesPrintButtonExist(WebDriver driver) {
		WebUtil.verifyIfElementExists(driver, printButton);
	}

	public void clickPrintButton(WebDriver driver) {
		WebUtil.click(driver, printButton);

	}
}
