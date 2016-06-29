package com.iConnectConsulting.pageobjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.iConnectConsulting.util.WebUtil;

public class PhysicianNamePopup {
	Random rand = new Random();
	int randomNumber = 0;

	public void clickPhysicianName(WebDriver driver) {
		WebElement physicianNameTable = driver.findElement(By.className("k-grid-content"));
		List<WebElement> rowsPhysicianName = physicianNameTable.findElements(By.tagName("tr"));
		randomNumber = rand.nextInt(rowsPhysicianName.size());
		for (int i = 0; i < rowsPhysicianName.size(); i++) {
			if (i == randomNumber) {
				rowsPhysicianName.get(i).click();
				break;
			}
		}
	}

	public void clickApplySelectedButton(WebDriver driver) {
		WebUtil.click(driver, By.xpath("//button[@class='btn btn-primary btn-form-md']"));
	}
}
