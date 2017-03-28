package com.iConnectConsulting.pageobjects;

import java.util.List;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.iConnectConsulting.util.WebUtil;

public class AddNewPatientPopup_PO {
	StringBuilder randomStringBuilder = new StringBuilder();
	String candidateChars = "abcdefghijklmnopqrstuvwxyz";

	@FindBy(css = "input[class='form-control item-focusable order-field-input ng-pristine ng-untouched ng-valid empty k-input']")
	WebElement dateOfBirthTextfield;
	@FindBy(css = "div[data-ng-hide='model.Layout[1].properties.ishidden'] > design-items > div > div > div > design-item-date-picker > div > div > div > span > span > input")
	WebElement entereDateOfBirthTextfield;
	@FindBy(css = "design-items[data-item-id='9bfd2fbd-3337-446c-ad46-9d27346891fb'] > div > div > div > design-item-text-box[data-item-id='Patients___LAST_NAME'] > div > div > input")
	WebElement lastNameTextfield;
	@FindBy(css = "design-items[data-item-id='9bfd2fbd-3337-446c-ad46-9d27346891fb'] > div > div > div > design-item-text-box[data-item-id='Patients___FIRST_NAME'] > div > div > input")
	WebElement firstNameTextfield;
	@FindBy(css = "design-item-list-box[class='lwp-design__item col-md-6 column ng-isolate-scope'][data-item-id='Patients___SEX'] > div > div > ul > li > div > fa-radio")
	List<WebElement> maleFemaleRadiobuttons;
	@FindBy(xpath = "//button[contains(@class,'btn btn-primary btn-form-md')]//span[text()='Submit']")
	WebElement submitButton;
	@FindBy(css = "design-items[data-item-id='b33f14bc-1228-4d0f-ac6c-9c2895b8fe07'] > div > div > div > design-item-masked-text-box > div > div[class='print-field order-form-field fieldfiller'] > input")
	WebElement ssNumber;

	public void fillInDateOfBirthTextfield(WebDriver driver) throws InterruptedException {
		WebUtil.waitForElementVisible(driver, dateOfBirthTextfield);
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
		WebUtil.input(driver, month + '/' + day + '/' + year, dateOfBirthTextfield);
		Thread.sleep(1000);
		WebUtil.click(driver, ssNumber);
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
		WebUtil.input(driver, randomString, lastNameTextfield);
	}

	public void fillFirstNameTextfield(WebDriver driver) {
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName();
		WebUtil.input(driver, browserName.substring(0, 1).toUpperCase() + browserName.substring(1), firstNameTextfield);
	}

	public void selectMaleFemaleRadioButton(WebDriver driver) {
		List<WebElement> maleFemaleRadioButtons = WebUtil.createListOfElements(driver, maleFemaleRadiobuttons);
		int randMaleFemale = WebUtil.randNumber(maleFemaleRadioButtons.size());
		maleFemaleRadioButtons.get(randMaleFemale).click();
	}

	public void clickSubmitButton(WebDriver driver) throws InterruptedException {
		WebUtil.waitForElementVisible(driver, submitButton);
		WebUtil.click(driver, ssNumber);
		WebUtil.click(driver, entereDateOfBirthTextfield);
		WebUtil.click(driver, ssNumber);
		Thread.sleep(1000);
		WebUtil.click(driver, submitButton);
	}
}
