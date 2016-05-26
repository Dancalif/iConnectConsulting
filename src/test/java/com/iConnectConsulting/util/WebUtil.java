package com.iConnectConsulting.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.iConnectConsulting.pageobjects.SignInPage;

public class WebUtil {

	public static SignInPage goToSignInPage(WebDriver driver) {
		driver.get("https://www.labwebportal.com/Precision_v7_dev/#/login");
		return PageFactory.initElements(driver, SignInPage.class);
	}

}
