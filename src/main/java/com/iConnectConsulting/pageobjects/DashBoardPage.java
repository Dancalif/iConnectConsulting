package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.iConnectConsulting.util.WebUtil;

public class DashBoardPage {
	
	@FindBy(how = How.CSS, using = "a[href='#/test-order']")
	WebElement testOrderButton;
	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'modal-header')]//h1[contains(@class, 'ng-binding')]")
	WebElement sampleTemplateSelectionPopup;
	
	public static SignInPage signOut(WebDriver driver) {
		WebUtil.click(driver, By
				.cssSelector("div[class='navbar-collapse collapse hidden-xs main-navigation__top'] > ul > li > a > i"));
		WebUtil.click(driver, By.linkText("Logout"));
		WebUtil.waitForElementVisible(driver, By.id("username"));
		return PageFactory.initElements(driver, SignInPage.class);
	}

	public static boolean doesDashboardExist(WebDriver driver) {
		return driver.findElement(By.cssSelector("a[href='#/dashboard']")).isDisplayed();
	}

	public void clickTestOrderButton(WebDriver driver) {
		WebUtil.click(driver, testOrderButton);
		WebUtil.waitForElementVisible(driver, sampleTemplateSelectionPopup);
	}

	public static SampleTemplateSelectionPopup clickPrecisionDiagnostics(WebDriver driver) {
		WebUtil.click(driver, By.xpath("//li[text()='Precision Diagnostics']"));
		WebUtil.click(driver, By.xpath(".//*[@id='se_refresh_btn']"));
		return PageFactory.initElements(driver, SampleTemplateSelectionPopup.class);
	}

	public AllSpecimensPage clickAllSpecimensButton(WebDriver driver) {
		WebUtil.click(driver, By.cssSelector("a[href='#/all-specimens']"));
		return PageFactory.initElements(driver, AllSpecimensPage.class);
	}

	public boolean ifdashBoardPageDisplayed(WebDriver driver) {
		return driver
				.findElement(By
						.xpath("//div[@class='dashboard__tile dashboard__tile--lg dashboard__tile--announcement dashboard__tile--783C82']"))
				.isDisplayed();
	}

	public DashBoardPage clickDashboardTab(WebDriver driver) {
		WebUtil.click(driver, By.cssSelector("a[href='#/dashboard']"));
		return PageFactory.initElements(driver, DashBoardPage.class);
	}

	public PhysicianQueuePage clickPhysicianQueueButton(WebDriver driver) {
		WebUtil.click(driver, By.cssSelector("a[href='#/physician-queue']"));
		return PageFactory.initElements(driver, PhysicianQueuePage.class);
	}
}
