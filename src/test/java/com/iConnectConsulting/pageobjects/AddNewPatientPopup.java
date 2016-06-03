package com.iConnectConsulting.pageobjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewPatientPopup {
	StringBuilder randomString = new StringBuilder();
	String candidateChars = "abcdefghijklmnopqrstuvwxyz";
	Random rand = new Random();

	public void fillInDateOfBirthTextfield(WebDriver driver) {
		WebElement addDateOfBirth = driver.findElement(By.cssSelector(
				"input[class='form-control item-focusable order-field-input ng-pristine ng-untouched ng-valid empty k-input']"));
		Random rand = new Random();
		int yyyy = 1900 + rand.nextInt(116);
		int mm = 1 + rand.nextInt(12);
		int dd = 0;

		switch (mm) {
		case 2:
			if (yyyy % 4 == 0) {
				dd = 1 + rand.nextInt(29);
			} else {
				dd = 1 + rand.nextInt(28);
			}
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			dd = 1 + rand.nextInt(31);
		default:
			dd = 1 + rand.nextInt(30);
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
		addDateOfBirth.clear();
		addDateOfBirth.sendKeys(month + '/' + day + '/' + year);
	}

	public void fillLastNameTextfield(WebDriver driver) {
		WebElement addLastName = driver.findElement(By.xpath("(//input[@type='text'])[42]"));
		int lengthOfLastName = 8;
		addLastName.clear();
		for (int i = 0; i < lengthOfLastName; i++) {
			if (i == 0) {
				randomString.append(candidateChars.toUpperCase().charAt(rand.nextInt(candidateChars.length())));
			} else {
				randomString.append(candidateChars.charAt(rand.nextInt(candidateChars.length())));
			}
		}
		addLastName.sendKeys(randomString);
	}

	public void fillFirstNameTextfield(WebDriver driver) {
		WebElement addFirstName = driver.findElement(By.xpath("(//input[@type='text'])[43]"));
		addFirstName.clear();
		addFirstName.sendKeys("Dan");

	}

	public void selectMaleFemaleRadioButton(WebDriver driver) {
		List<WebElement> maleFemaleRadioButtons = driver.findElements(By.cssSelector(
				"design-item-list-box[class='lwp-design__item col-md-6 column ng-isolate-scope'][data-item-id='Patients___SEX'] > div > div > ul > li > div > fa-radio"));
		int randMaleFemale = rand.nextInt(maleFemaleRadioButtons.size());
		maleFemaleRadioButtons.get(randMaleFemale).click();

	}

	public void clickSubmitButton(WebDriver driver) throws InterruptedException {
		WebElement submitButton = driver.findElement(
				By.xpath("//button[contains(@class,'btn btn-primary btn-form-md')]//span[text()='Submit']"));
		Thread.sleep(3000);
		WebElement addDateOfBirth = driver.findElement(By.cssSelector(
				"input[class='form-control item-focusable order-field-input ng-valid k-input ng-dirty ng-valid-parse ng-touched']"));
		addDateOfBirth.click();
		Thread.sleep(1000);
		addDateOfBirth.click();
		submitButton.click();
		Thread.sleep(1000);

	}

}
