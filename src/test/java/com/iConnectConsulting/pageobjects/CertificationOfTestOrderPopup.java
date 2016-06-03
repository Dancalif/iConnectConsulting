package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CertificationOfTestOrderPopup {

	public OrderPlacedcePopup clickAgreeButton(WebDriver driver) throws InterruptedException {
		WebElement agreeButon = driver.findElement(By.xpath("//span[text()='Agree']"));
		agreeButon.click();
		Thread.sleep(2000);
		return PageFactory.initElements(driver, OrderPlacedcePopup.class);
	}

}
