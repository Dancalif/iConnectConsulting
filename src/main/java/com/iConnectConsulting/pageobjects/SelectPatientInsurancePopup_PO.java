package com.iConnectConsulting.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.iConnectConsulting.util.WebUtil;

public class SelectPatientInsurancePopup_PO {

	@FindBy(css = "button[class='btn btn-default btn-form-md pull-left ng-scope']")
	WebElement addNewButton;

	public void clickAddNewButton(WebDriver driver) {
		WebUtil.waitForElementVisible(driver, addNewButton);
		WebUtil.click(driver, addNewButton);
	}
}
