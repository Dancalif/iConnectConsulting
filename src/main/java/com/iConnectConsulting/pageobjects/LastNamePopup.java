package com.iConnectConsulting.pageobjects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.iConnectConsulting.util.WebUtil;

public class LastNamePopup {
	Random rand = new Random();

	public AddNewPatientPopup clickAddNewButton(WebDriver driver) {
		WebUtil.click(driver, By.cssSelector("button[class='btn btn-default btn-form-md pull-left ng-scope']"));
		return PageFactory.initElements(driver, AddNewPatientPopup.class);
	}
}
