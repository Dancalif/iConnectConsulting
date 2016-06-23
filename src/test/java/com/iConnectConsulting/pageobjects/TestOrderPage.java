package com.iConnectConsulting.pageobjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
		WebUtil.waitForElementVisible(driver,
				By.xpath("//div[contains(@class,'lwp-checkbox')]//span[text()='Uninsured']"));
		WebUtil.getElementVisible(driver, By.xpath("//span[text()='*Billing Method']"));
		WebUtil.waitForElementVisible(driver,
				By.xpath("//div[contains(@class,'lwp-checkbox')]//span[text()='Uninsured']"));
		WebUtil.click(driver, By.xpath("//div[contains(@class,'lwp-checkbox')]//span[text()='Uninsured']"));
	}

	public void inputDiagnosisCode(WebDriver driver) throws Exception {
		WebUtil.getElementVisible(driver, By.xpath("//input[contains(@placeholder, 'Select diagnosis...')]"));
		WebUtil.waitForElementVisible(driver, By.xpath("//input[contains(@placeholder, 'Select diagnosis...')]"));
		WebUtil.input(driver, "304", By.xpath("//input[contains(@placeholder, 'Select diagnosis...')]"));
	}

	public void selectDiagnosisOption(WebDriver driver) throws InterruptedException {
		WebUtil.waitForElementVisible(driver, By.cssSelector("span[class='k-state-default']"));
		List<WebElement> diagnosOptions = driver.findElements(By.cssSelector("span[class='k-state-default']"));
		randomNumber = rand.nextInt(diagnosOptions.size());
		diagnosOptions.get(randomNumber).click();
	}

	public void clickUrineRadioButton(WebDriver driver) throws Exception {
		WebUtil.waitForElementVisible(driver, By.xpath("//div[contains(@class,'lwp-checkbox')]//span[text()='Urine']"));
		WebUtil.getElementVisible(driver, By.xpath("//span[text()='*SPECIMEN TYPE']"));
		WebUtil.waitForElementVisible(driver, By.xpath("//div[contains(@class,'lwp-checkbox')]//span[text()='Urine']"));
		WebUtil.click(driver, By.xpath("//div[contains(@class,'lwp-checkbox')]//span[text()='Urine']"));
	}

	public void clickRecordPOCResultsExpand(WebDriver driver) throws Exception {
		// Thread.sleep(1000);
		// WebUtil.getElementVisible(driver, By.cssSelector(
		// "div[class='print-field order-form-field fieldfiller'] >
		// div[class='print-poc-code-list'] > data-multicolumn-layout"));
		WebUtil.click(driver, By.cssSelector(
				"design-item-group-box[data-item-id='502b26d4-5aed-4fe9-bbb7-7b8a88349309'] > div > div > div > a"));

		// WebElement pocResultsExpand = driver.findElement(By.cssSelector(
		// "design-item-group-box[data-item-id='502b26d4-5aed-4fe9-bbb7-7b8a88349309']
		// > div > div > div > a"));
		// try {
		// WebUtil.click(driver, By.cssSelector(
		// "design-item-group-box[data-item-id='502b26d4-5aed-4fe9-bbb7-7b8a88349309']
		// > div > div > div > a"));
		// } catch (Exception e) {
		// pocResultsExpand.sendKeys(Keys.PAGE_UP);
		// WebUtil.click(driver, By.cssSelector(
		// "design-item-group-box[data-item-id='502b26d4-5aed-4fe9-bbb7-7b8a88349309']
		// > div > div > div > a"));
		// }
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

				// WebElement urineRadioButton = driver
				// .findElement(By.xpath("//div[contains(@class,'lwp-checkbox')]//span[text()='Urine']"));
				// je.executeScript("arguments[0].scrollIntoView(true);",
				// urineRadioButton);
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
		WebUtil.getElementVisible(driver,
				By.xpath("//div[text()='6 SELECT YOUR TESTING OPTION (THIS SECTION MUST BE COMPLETED)']"));
		WebUtil.click(driver, By.xpath("//span[text()='PERFORM CUSTOM PROFILE']"));
		WebUtil.waitForElementVisible(driver, By.cssSelector("span[class='k-icon k-i-arrow-s']"));
		WebUtil.click(driver, By.cssSelector("span[class='k-icon k-i-arrow-s']"));
		WebUtil.click(driver, By.xpath("//li[text()='FULLPANELMIX']"));
	}

	public void clickMedicationsCheckBoxes(WebDriver driver) throws InterruptedException {
		List<WebElement> medicationsCheckBoxes = driver.findElements(
				By.cssSelector("div[class='animated row fadeInRight'] > div > ul > li > div > div > fa-check-box > i"));

		maxNum = 0;
		do

		{
			randomNumber = WebUtil.randNumber(medicationsCheckBoxes.size());
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
		WebUtil.input(driver, "DU",
				By.cssSelector("design-item-text-box[data-item-id='Sample___ORDERING_PHYSICIAN'] > div > div > input"));
	}

	public CertificationOfTestOrderPopup clickFinalSubmitButton(WebDriver driver) {
		WebUtil.click(driver, By.xpath("//span[text()='Submit']"));
		return PageFactory.initElements(driver, CertificationOfTestOrderPopup.class);
	}
}
