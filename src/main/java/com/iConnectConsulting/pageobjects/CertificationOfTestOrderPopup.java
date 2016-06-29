package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.iConnectConsulting.util.WebUtil;

public class CertificationOfTestOrderPopup {

	public OrderPlacedcePopup clickAgreeButton(WebDriver driver) throws InterruptedException {
		WebUtil.click(driver, By.xpath("//span[text()='Agree']"));
		Thread.sleep(2000);
		return PageFactory.initElements(driver, OrderPlacedcePopup.class);
	}

}
