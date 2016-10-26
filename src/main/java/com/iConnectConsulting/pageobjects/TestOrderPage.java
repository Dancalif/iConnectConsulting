package com.iConnectConsulting.pageobjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.iConnectConsulting.util.WebUtil;

public class TestOrderPage {
	String specimenIDName = "";
	Random rand = new Random();
	int randomNumber, numberID, maxNum = 0;

	public String fillInSpecimenID(WebDriver driver) {
		randomNumber = 1000 + rand.nextInt(8999);
		specimenIDName = "DanU" + randomNumber;
		WebUtil.waitForElementVisible(driver, By.cssSelector("input"));
		WebUtil.input(driver, specimenIDName, By.cssSelector("input"));
		return specimenIDName;
	}

	public PhysicianNamePopup clickPhysicianNameTextField(WebDriver driver) {
		WebUtil.click(driver, By.cssSelector("i[class='fa fa-ellipsis-h']"));
		WebUtil.waitForElementVisible(driver, By.className("k-grid-content"));
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
					WebElement specimenID = driver.findElement(By.cssSelector("input[placeholder='Specimen Id']"));
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
		WebUtil.waitForElementVisible(driver, By.cssSelector(
				"design-item-lookup[data-item-id='Sample___PID'] > div > div > div > div > div > div[class='input-group-btn']"));
	}

	public LastNamePopup clickLastNameTextField(WebDriver driver) {
		WebUtil.click(driver, By.cssSelector(
				"design-item-lookup[data-item-id='Sample___PID'] > div > div > div > div > div > div[class='input-group-btn'] > button > i[class='fa fa-ellipsis-h']"));
		WebUtil.waitForElementVisible(driver,
				By.cssSelector("button[class='btn btn-default btn-form-md pull-left ng-scope']"));
		return PageFactory.initElements(driver, LastNamePopup.class);
	}

	public void clickUninsuredRadioButton(WebDriver driver) throws Exception {
		Thread.sleep(3000);
		WebUtil.clickHiddenElement(driver,
				By.xpath("//div[contains(@class,'lwp-checkbox')]//span[text()='Uninsured']"));
	}

	public void inputDiagnosisCode(WebDriver driver) throws Exception {
		WebUtil.getElementVisible(driver, By.xpath("//input[contains(@placeholder, 'Select diagnosis...')]"));
		// WebUtil.waitForElementVisible(driver,
		// By.xpath("//input[contains(@placeholder, 'Select diagnosis...')]"));
		WebUtil.input(driver, "304", By.xpath("//input[contains(@placeholder, 'Select diagnosis...')]"));
	}

	public void selectDiagnosisOption(WebDriver driver) throws Exception {
		// WebUtil.getElementVisible(driver,
		// By.cssSelector("span[class='k-state-default']"));
		// WebUtil.waitForElementVisible(driver,
		// By.cssSelector("span[class='k-state-default']"));
		Thread.sleep(1000);
		List<WebElement> diagnosOptions = driver.findElements(By.cssSelector("span[class='k-state-default']"));
		randomNumber = rand.nextInt(diagnosOptions.size());
		Thread.sleep(1000);
		// diagnosOptions.get(randomNumber);
		diagnosOptions.get(randomNumber).click();

	}

	public void clickUrineRadioButton(WebDriver driver) throws Exception {
		WebUtil.clickHiddenElement(driver, By.xpath("//div[contains(@class,'lwp-checkbox')]//span[text()='Urine']"));
	}

	public void clickRecordPOCResultsExpand(WebDriver driver) throws Exception {
		WebUtil.clickHiddenElement(driver, By.cssSelector(
				"design-item-group-box[data-item-id='502b26d4-5aed-4fe9-bbb7-7b8a88349309'] > div > div > div > a"));

	}

	public void selectRecordPOCResults(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		List<WebElement> posCheckBoxes = driver.findElements(By.cssSelector(
				"data-multicolumn-layout[class='ng-scope row'] > div > ul > li > div > div > fa-check-box[title='POS(+)'] > i"));
		List<WebElement> negCheckBoxes = driver.findElements(By.cssSelector(
				"data-multicolumn-layout[class='ng-scope row'] > div > ul > li > div > div > fa-check-box[title='NEG(-)'] > i"));
		int maxNum = 0;
		do

		{
			int posRandomNumber = WebUtil.randNumber(posCheckBoxes.size());
			int negRandomNumber = WebUtil.randNumber(negCheckBoxes.size());

			try {
				posCheckBoxes.get(posRandomNumber).click();
				maxNum++;
			} catch (Exception e) {

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

	public void clickPerformCustomProfile(WebDriver driver) throws Exception {
		WebUtil.clickHiddenElement(driver, By.cssSelector(
				"ul[class='lwp-design__test-codes__controls list-inline-centered pull-right additional-controls'] > li > ul > li > fa-check-box > i"));
		// WebUtil.click(driver, By.cssSelector(
		// "ul[class='lwp-design__test-codes__controls list-inline-centered
		// pull-right additional-controls']"));
		// WebUtil.waitForElementVisible(driver,
		// By.cssSelector("span[class='k-icon k-i-arrow-s']"));
		// WebUtil.click(driver, By.cssSelector("span[class='k-icon
		// k-i-arrow-s']"));
		//
		// WebUtil.click(driver, By.xpath("//li[text()='FULLPANELMIX']"));
	}

	public void clickMedicationsCheckBoxes(WebDriver driver) throws InterruptedException {
		List<WebElement> medicationsCheckBoxes = driver.findElements(
				By.cssSelector("div[class='animated row fadeInRight'] > div > ul > li > div > div > fa-check-box > i"));

		maxNum = 0;
		do

		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			randomNumber = WebUtil.randNumber(medicationsCheckBoxes.size());

			WebElement myElement = medicationsCheckBoxes.get(randomNumber);

			js.executeScript("arguments[0].click();", myElement);
			maxNum++;
		} while (maxNum < 8);

	}

	public void inputcollectorInitials(WebDriver driver) {
		WebUtil.input(driver, "DU",
				By.cssSelector("design-item-text-box[data-item-id='Sample___ORDERING_PHYSICIAN'] > div > div > input"));
	}

	public CertificationOfTestOrderPopup clickFinalSubmitButton(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		WebUtil.click(driver, By.xpath("//span[text()='Submit']"));
		return PageFactory.initElements(driver, CertificationOfTestOrderPopup.class);
	}

	public void clickInsuredRadioButton(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		WebUtil.clickHiddenElement(driver, By.xpath("//div[contains(@class,'lwp-checkbox')]//span[text()='Insured']"));

	}

	public PatientInsurancePopup clickInsuranceNameTextfield(WebDriver driver) throws Exception {
		Thread.sleep(3000);
		WebUtil.clickHiddenElement(driver, By.cssSelector(
				"div > design-items[data-item-id='d32c5ffa-fd7c-4833-8406-aea37559e163'] > div > div > div > design-item-lookup > div > div[class='print-field order-form-field fieldfiller'] > div > div > div > div > button[ng-click='openLookup(model)'] > i"));
		return PageFactory.initElements(driver, PatientInsurancePopup.class);
	}
}
