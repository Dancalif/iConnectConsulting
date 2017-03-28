package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.iConnectConsulting.util.WebUtil;

public class CommonElements {

	@FindBy(css = "a[href='#/dashboard']")
	WebElement dashboardTab;
	@FindBy(css = "a[href='#/test-order']")
	WebElement testOrderTab;
	@FindBy(css = "a[href='#/reports-all']")
	WebElement publishedReportsTab;
	@FindBy(css = "a[href='#/physician-queue']")
	WebElement physicianqueueTab;
	@FindBy(css = "a[href='#/all-specimens']")
	WebElement allSpecimensTab;
	@FindBy(css = "div[class='navbar-collapse collapse hidden-xs main-navigation__top'] > ul > li > a")
	WebElement navBar;
	@FindBy(css = "div > ul > li[class='dropdown nlightblue main-navigation__user-profile open'] > ul > li[data-ng-click='logout()'] > a")
	WebElement logoutButton;

	public void clickSignOut(WebDriver driver) throws InterruptedException {
		WebUtil.waitForElementVisible(driver, navBar);
		Thread.sleep(1000);
		WebUtil.click(driver, navBar);
		Thread.sleep(1000);
		WebUtil.waitForElementVisible(driver, logoutButton);
		WebUtil.click(driver, logoutButton);
	}

	public boolean doesDashboardExist(WebDriver driver) {
		return dashboardTab.isDisplayed();
	}

	public void clickTestOrderTab(WebDriver driver) {
		WebUtil.waitForElementVisible(driver, testOrderTab);
		WebUtil.click(driver, testOrderTab);
	}

	public void clickAllSpecimensTab(WebDriver driver) {
		WebUtil.click(driver, allSpecimensTab);
	}

	public void clickDashboardTab(WebDriver driver) {
		WebUtil.click(driver, dashboardTab);
	}

	public void clickPhysicianQueueTab(WebDriver driver) {
		WebUtil.click(driver, physicianqueueTab);
	}

	public void clickPublishedReportsTab(WebDriver driver) {
		WebUtil.click(driver, publishedReportsTab);
	}

}
