package com.iConnectConsulting.pageobjects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LastNamePopup {
	Random rand = new Random();

	public AddNewPatientPopup clickAddNewButton(WebDriver driver) {
		WebElement addNewButton = driver
				.findElement(By.cssSelector("button[class='btn btn-default btn-form-md pull-left ng-scope']"));
		addNewButton.click();
		return PageFactory.initElements(driver, AddNewPatientPopup.class);
	}
}
