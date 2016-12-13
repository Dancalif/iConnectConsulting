package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.iConnectConsulting.util.WebUtil;

import iConnectConsulting.PublishedReportsTab;

public class PublishedReportsPage {

	public static PublishedReportsTab clickPublishedReportsTab(WebDriver driver) {
		WebUtil.click(driver, By.cssSelector("a[href='#/reports-all']"));
		return PageFactory.initElements(driver, PublishedReportsTab.class);

	}

}
