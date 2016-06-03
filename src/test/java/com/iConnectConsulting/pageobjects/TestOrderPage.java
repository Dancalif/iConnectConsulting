package com.iConnectConsulting.pageobjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestOrderPage {
	String specimenIDName = "";
	Random rand = new Random();
	int randomNumber, numberID, maxNum = 0;

	public String fillInSpecimenID(WebDriver driver) {
		WebElement specimenID = driver.findElement(By.cssSelector("input"));
		randomNumber = 1000 + rand.nextInt(8999);
		specimenIDName = "DanU" + randomNumber;
		specimenID.clear();
		specimenID.sendKeys(specimenIDName);
		return specimenIDName;
	}

	public PhysicianNamePopup clickPhysicianNameTextField(WebDriver driver) {
		WebElement physicianName = driver.findElement(By.cssSelector("i[class='fa fa-ellipsis-h']"));
		physicianName.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("k-grid-content")));
		return PageFactory.initElements(driver, PhysicianNamePopup.class);
	}

	public void verifyIfSpecimenIDunigue(WebDriver driver) throws InterruptedException {
		boolean doFlag = false;
		do {
			try {
				WebElement uniqueMessage = driver.findElement(By.xpath("//span[text()='The value is not unique']"));
				if (uniqueMessage.isDisplayed()) {
					randomNumber = 1000 + rand.nextInt(8999);
					specimenIDName = "DanU" + randomNumber;
					WebElement specimenID = driver.findElement(By.cssSelector("input"));
					specimenID.clear();
					specimenID.sendKeys(specimenIDName);
					System.out.print("The specimen ID is " + specimenIDName);
				} else {
					break;
				}
			} catch (Exception e1) {
				doFlag = true;
			}
		} while (doFlag == false);
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"design-item-lookup[data-item-id='Sample___PID'] > div > div > div > div > div > div[class='input-group-btn']")));
	}

	public LastNamePopup clickLastNameTextField(WebDriver driver) {
		WebElement lastNameTextField = driver.findElement(By.cssSelector(
				"design-item-lookup[data-item-id='Sample___PID'] > div > div > div > div > div > div[class='input-group-btn']"));
		lastNameTextField.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("button[class='btn btn-default btn-form-md pull-left ng-scope']")));
		return PageFactory.initElements(driver, LastNamePopup.class);
	}

	public void scrollToBillingMethod(WebDriver driver) throws InterruptedException {
		WebElement scrollToBillingMethodSection = driver.findElement(By.xpath("//span[text()='Birth Date']"));
		scrollToBillingMethodSection.sendKeys(Keys.PAGE_DOWN);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[contains(@class,'lwp-checkbox')]//span[text()='Uninsured']")));

	}

	public void clickUninsuredRadioButton(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		WebElement uninsuredRadioButton = driver
				.findElement(By.xpath("//div[contains(@class,'lwp-checkbox')]//span[text()='Uninsured']"));
		uninsuredRadioButton.click();

	}

	public void inputDiagnosisCode(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder, 'Select diagnosis...')]")));
		WebElement diagnosisCodeInput = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'Select diagnosis...')]"));
		diagnosisCodeInput.sendKeys("304");

	}

	public void selectDiagnosisOption(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='k-state-default']")));
		List<WebElement> diagnosOptions = driver.findElements(By.cssSelector("span[class='k-state-default']"));
		randomNumber = rand.nextInt(diagnosOptions.size());
		diagnosOptions.get(randomNumber).click();
		Thread.sleep(3000);

	}

	public void clickUrineRadioButton(WebDriver driver) throws InterruptedException {
		WebElement urineRadioButton = driver
				.findElement(By.xpath("//div[contains(@class,'lwp-checkbox')]//span[text()='Urine']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(250,350)");
		boolean doFlag = false;
		do {
			try {
				Thread.sleep(1000);
				urineRadioButton.click();
				Thread.sleep(1000);
				doFlag = true;
			} catch (Exception e) {
				urineRadioButton.sendKeys(Keys.PAGE_UP);
				Thread.sleep(1000);
				urineRadioButton.click();
				Thread.sleep(1000);
				doFlag = true;
			}
			Thread.sleep(3000);
		} while (doFlag == false);
	}

	public void clickRecordPOCResultsExpand(WebDriver driver) throws InterruptedException {
		WebElement recordPOCResultsExpand = driver.findElement(By.cssSelector(
				"design-item-group-box[data-item-id='502b26d4-5aed-4fe9-bbb7-7b8a88349309'] > div > div > div > a"));
		Thread.sleep(3000);
		recordPOCResultsExpand.click();
	}

	public void selectRecordPOCResults(WebDriver driver) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		List<WebElement> posCheckBoxes = driver.findElements(By.cssSelector(
				"data-multicolumn-layout[class='ng-scope row'] > div > ul > li > div > div > fa-check-box[title='POS(+)'] > i"));
		List<WebElement> negCheckBoxes = driver.findElements(By.cssSelector(
				"data-multicolumn-layout[class='ng-scope row'] > div > ul > li > div > div > fa-check-box[title='NEG(-)'] > i"));
		int maxNum = 0;
		do

		{
			int posRandomNumber = rand.nextInt(posCheckBoxes.size());
			int negRandomNumber = rand.nextInt(negCheckBoxes.size());

			try {
				posCheckBoxes.get(posRandomNumber).click();
				maxNum++;
			} catch (Exception e) {
				WebElement urineRadioButton = driver
						.findElement(By.xpath("//div[contains(@class,'lwp-checkbox')]//span[text()='Urine']"));
				je.executeScript("arguments[0].scrollIntoView(true);", urineRadioButton);
			}

			try {
				negCheckBoxes.get(negRandomNumber).click();
				maxNum++;
			} catch (Exception e) {
				WebElement urineRadioButton = driver
						.findElement(By.xpath("//div[contains(@class,'lwp-checkbox')]//span[text()='Urine']"));
				je.executeScript("arguments[0].scrollIntoView(true);", urineRadioButton);
			}
		} while (maxNum < 6);

	}

	public void clickPerformCustomProfile(WebDriver driver) throws InterruptedException {
		WebElement performCustomProfileCheckbox = driver
				.findElement(By.xpath("//span[text()='PERFORM CUSTOM PROFILE']"));
		performCustomProfileCheckbox.click();
		WebElement performCustomProfileArrow = driver.findElement(By.cssSelector("span[class='k-icon k-i-arrow-s']"));
		performCustomProfileArrow.click();
		Thread.sleep(1000);
		WebElement firstOptionCustomProfile = driver.findElement(By.xpath("//li[text()='FULLPANELMIX']"));
		firstOptionCustomProfile.click();

	}

	public void clickMedicationsCheckBoxes(WebDriver driver) throws InterruptedException {
		List<WebElement> medicationsCheckBoxes = driver.findElements(
				By.cssSelector("div[class='animated row fadeInRight'] > div > ul > li > div > div > fa-check-box > i"));

		maxNum = 0;
		do

		{
			randomNumber = rand.nextInt(medicationsCheckBoxes.size());
			WebElement myElement = medicationsCheckBoxes.get(randomNumber);
			myElement.sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(1000);
			try {
				myElement.click();
			} catch (Exception e) {
				myElement.sendKeys(Keys.PAGE_UP);
				Thread.sleep(1000);
				myElement.click();
			}
			maxNum++;
		} while (maxNum < 8);

	}

	public void inputcollectorInitials(WebDriver driver) {
		WebElement collectorInitialsTextField = driver.findElement(
				By.cssSelector("design-item-text-box[data-item-id='Sample___ORDERING_PHYSICIAN'] > div > div > input"));
		collectorInitialsTextField.clear();
		collectorInitialsTextField.sendKeys("DU");

	}

	public CertificationOfTestOrderPopup clickFinalSubmitButton(WebDriver driver) {
		WebElement finalSubmitButton = driver.findElement(By.xpath("//span[text()='Submit']"));
		finalSubmitButton.click();
		return PageFactory.initElements(driver, CertificationOfTestOrderPopup.class);
	}
}
