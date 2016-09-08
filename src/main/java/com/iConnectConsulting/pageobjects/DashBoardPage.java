package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.iConnectConsulting.util.WebUtil;

public class DashBoardPage {
	public SignInPage signOut(WebDriver driver) {
		WebUtil.click(driver, By
				.cssSelector("div[class='navbar-collapse collapse hidden-xs main-navigation__top'] > ul > li > a > i"));
		WebUtil.click(driver, By.linkText("Logout"));
		WebUtil.waitForElementVisible(driver, By.id("username"));
		return PageFactory.initElements(driver, SignInPage.class);
	}

	public boolean doesDashboardExist(WebDriver driver) {
		return driver.findElement(By.cssSelector("a[href='#/dashboard']")).isDisplayed();
	}

	public TestOrderPage clickTestOrderButton(WebDriver driver) {
		WebUtil.click(driver, By.cssSelector("a[href='#/test-order']"));
		WebUtil.waitForElementVisible(driver,
				By.xpath("//div[contains(@class, 'modal-header')]//h1[contains(@class, 'ng-binding')]"));

		// WebUtil.waitForElementVisible(driver, By.cssSelector("input"));
		return PageFactory.initElements(driver, TestOrderPage.class);
	}

	public SampleTemplateSelectionPopup clickPrecisionDiagnostics(WebDriver driver) {
		WebUtil.click(driver, By.xpath("//li[text()='Precision Diagnostics']"));
		WebUtil.click(driver, By.xpath(".//*[@id='se_refresh_btn']"));
		return PageFactory.initElements(driver, SampleTemplateSelectionPopup.class);
	}
}
