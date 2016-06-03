package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPlacedcePopup {

	public Object doesOrderPlacedExist(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'modal-header')]/h1")));
		return driver.findElement(By.xpath("//div[contains(@class,'modal-header')]/h1")).getText();
	}

	public Object doesNameUnderOrderMatch(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']/div/p/b")));
		return driver.findElement(By.xpath("//div[@class='modal-body']/div/p/b")).getText();
	}

	public void clickOkButton(WebDriver driver) {
		WebElement okButton = driver.findElement(By.xpath("//span[text()='OK']"));
		okButton.click();

	}

}
