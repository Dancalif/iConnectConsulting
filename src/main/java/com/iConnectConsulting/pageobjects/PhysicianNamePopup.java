package com.iConnectConsulting.pageobjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.iConnectConsulting.util.WebUtil;

public class PhysicianNamePopup {
	Random rand = new Random();
	int randomNumber = 0;
	
	@FindBy(how = How.CLASS_NAME, using = "k-grid-content")
	WebElement physiciansNamesTable;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary btn-form-md']")
	WebElement applySelectedButton;
	

	public void clickPhysicianName(WebDriver driver) {
		List<WebElement> rowsPhysicianName = physiciansNamesTable.findElements(By.tagName("tr"));
		randomNumber = WebUtil.randNumber(rowsPhysicianName.size());
		for (int i = 0; i < rowsPhysicianName.size(); i++) {
			if (i == randomNumber) {
				rowsPhysicianName.get(i).click();
				break;
			}
		}
	}

	public void clickApplySelectedButton(WebDriver driver) {
		WebUtil.click(driver, applySelectedButton);
	}
}
