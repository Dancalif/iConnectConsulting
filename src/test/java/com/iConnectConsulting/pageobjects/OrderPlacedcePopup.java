package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.iConnectConsulting.util.WebUtil;

public class OrderPlacedcePopup {

	public Object doesOrderPlacedExist(WebDriver driver) {
		WebUtil.waitForElementVisible(driver, By.xpath("//div[contains(@class,'modal-header')]/h1"));
		return driver.findElement(By.xpath("//div[contains(@class,'modal-header')]/h1")).getText();
	}

	public Object doesNameUnderOrderMatch(WebDriver driver) {
		WebUtil.waitForElementVisible(driver, By.xpath("//div[@class='modal-body']/div/p/b"));
		return driver.findElement(By.xpath("//div[@class='modal-body']/div/p/b")).getText();
	}

	public void clickOkButton(WebDriver driver) {
		WebUtil.click(driver, By.xpath("//span[text()='OK']"));
	}

	public void doesPrintButtonExist(WebDriver driver) {
		WebUtil.verifyIfElementExists(driver, By.xpath("//span[text()='Print']"));
	}

	public void clickPrintButton(WebDriver driver) {
		WebUtil.click(driver, By.xpath("//span[text()='Print']"));

	}
}
