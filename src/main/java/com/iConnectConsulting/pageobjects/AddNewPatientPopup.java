package com.iConnectConsulting.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.iConnectConsulting.util.WebUtil;

public class AddNewPatientPopup {
	StringBuilder randomStringBuilder = new StringBuilder();
	String candidateChars = "abcdefghijklmnopqrstuvwxyz";

	public void fillInDateOfBirthTextfield(WebDriver driver) throws InterruptedException {
		int yyyy = 1900 + WebUtil.randNumber(116);
		int mm = 1 + WebUtil.randNumber(12);
		int dd = 0;

		switch (mm) {
		case 2:
			if (yyyy % 4 == 0) {
				dd = 1 + WebUtil.randNumber(29);
			} else {
				dd = 1 + WebUtil.randNumber(28);
			}
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			dd = 1 + WebUtil.randNumber(31);
		default:
			dd = 1 + WebUtil.randNumber(30);
		}
		String year = Integer.toString(yyyy);
		String month = Integer.toString(mm);
		String day = Integer.toString(dd);
		if (mm < 10) {
			month = "0" + mm;
		}
		if (dd < 10) {
			day = "0" + dd;
		}
		Thread.sleep(2000);
		WebUtil.input(driver, month + '/' + day + '/' + year, By.cssSelector(
				"input[class='form-control item-focusable order-field-input ng-pristine ng-untouched ng-valid empty k-input']"));
	}

	public void fillLastNameTextfield(WebDriver driver) {
		int lengthOfLastName = WebUtil.randNumber(50);
		for (int i = 0; i < lengthOfLastName; i++) {
			if (i == 0) {
				randomStringBuilder
						.append(candidateChars.toUpperCase().charAt(WebUtil.randNumber(candidateChars.length())));
			} else {
				randomStringBuilder.append(candidateChars.charAt(WebUtil.randNumber(candidateChars.length())));
			}
		}
		String randomString = randomStringBuilder.toString();
		WebUtil.input(driver, randomString, By.cssSelector(
				"design-items[data-item-id='9bfd2fbd-3337-446c-ad46-9d27346891fb'] > div > div > div > design-item-text-box[data-item-id='Patients___LAST_NAME'] > div > div > input"));
		System.out.println(randomString);
	}

	public void fillFirstNameTextfield(WebDriver driver) {
		WebUtil.input(driver, "Dan", By.cssSelector(
				"design-items[data-item-id='9bfd2fbd-3337-446c-ad46-9d27346891fb'] > div > div > div > design-item-text-box[data-item-id='Patients___FIRST_NAME'] > div > div > input"));
	}

	public void selectMaleFemaleRadioButton(WebDriver driver) {
		List<WebElement> maleFemaleRadioButtons = driver.findElements(By.cssSelector(
				"design-item-list-box[class='lwp-design__item col-md-6 column ng-isolate-scope'][data-item-id='Patients___SEX'] > div > div > ul > li > div > fa-radio"));
		int randMaleFemale = WebUtil.randNumber(maleFemaleRadioButtons.size());
		maleFemaleRadioButtons.get(randMaleFemale).click();

	}

	public void clickSubmitButton(WebDriver driver) throws InterruptedException {
		WebUtil.waitForElementVisible(driver,
				By.xpath("//button[contains(@class,'btn btn-primary btn-form-md')]//span[text()='Submit']"));

		WebUtil.click(driver, By.cssSelector(
				"div[data-ng-hide='model.Layout[1].properties.ishidden'] > design-items > div > div > div > design-item-date-picker > div > div > div > span > span > input"));
		Thread.sleep(1000);
		WebUtil.click(driver, By.cssSelector(
				"div[data-ng-hide='model.Layout[1].properties.ishidden'] > design-items > div > div > div > design-item-date-picker > div > div > div > span > span > input"));
		WebUtil.click(driver,
				By.xpath("//button[contains(@class,'btn btn-primary btn-form-md')]//span[text()='Submit']"));
	}
}
