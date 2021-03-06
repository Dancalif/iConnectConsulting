package com.iConnectConsulting.pageobjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.iConnectConsulting.util.WebUtil;

public class TestOrderPage_PO {
	String specimenIDName = "";
	Random rand = new Random();
	int randomNumber, numberID, maxNum = 0;

	@FindBy(css = "input[placeholder='Specimen Id']")
	WebElement specimenIdTextfield;
	@FindBy(css = "design-item-lookup[data-item-id='Sample___CONTACTID'] > div > div[class='print-field order-form-field fieldfiller'] > div > div > div > input")
	WebElement physicianNameTextfield;
	@FindBy(xpath = "//span[text()='The value is not unique']")
	WebElement uniqueMessage1;
	@FindBy(xpath = ".//div[text()='*Specimen Id: The value is not unique']")
	WebElement uniqueMessage2;
	@FindBy(css = "design-item-lookup[data-item-id='Sample___PID'] > div > div > div > div > div > div[class='input-group-btn'] > button > i[class='fa fa-ellipsis-h']")
	WebElement lastNameTextField;
	@FindBy(xpath = "//div[contains(@class,'lwp-checkbox')]//span[text()='Uninsured']")
	WebElement uninsuredRadiobutton;
	@FindBy(xpath = "//input[contains(@placeholder, 'Select diagnosis...')]")
	WebElement selectDiagnosisTextfield;
	@FindBy(css = "span[class='k-state-default']")
	List<WebElement> listDiagnosOptions;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'lwp-checkbox')]//span[text()='Urine']")
	WebElement urineRadioButton;
	@FindBy(css = "design-item-group-box[data-item-id='502b26d4-5aed-4fe9-bbb7-7b8a88349309'] > div > div > div > a")
	WebElement recordPOCResultsExpand;
	@FindBy(css = "data-multicolumn-layout[class='ng-scope row'] > div > ul > li > div > div > fa-check-box[title='POS(+)'] > i")
	List<WebElement> recordPOCResultsPositive;
	@FindBy(css = "data-multicolumn-layout[class='ng-scope row'] > div > ul > li > div > div > fa-check-box[title='NEG(-)'] > i")
	List<WebElement> recordPOCResultsNegative;
	@FindBy(css = "ul[class='lwp-design__test-codes__controls list-inline-centered pull-right additional-controls'] > li > ul > li > fa-check-box > i")
	WebElement PerformCustomProfileModule;
	@FindBy(css = "div[class='animated row fadeInRight'] > div > ul > li > div > div > fa-check-box > i")
	List<WebElement> listMedicationsCheckBoxes;
	@FindBy(css = "design-item-text-box[data-item-id='Sample___ORDERING_PHYSICIAN'] > div > div > input")
	WebElement collectorInitialsTextfield;
	@FindBy(xpath = "//span[text()='Submit']")
	WebElement submitButton;
	@FindBy(xpath = "//div[contains(@class,'lwp-checkbox')]//span[text()='Insured']")
	WebElement insuredRadioButton;
	@FindBy(css = "div > design-items[data-item-id='d32c5ffa-fd7c-4833-8406-aea37559e163'] > div > div > div > design-item-lookup > div > div[class='print-field order-form-field fieldfiller'] > div > div > div > div > button[ng-click='openLookup(model)'] > i")
	WebElement insuranceNameTextfield;
	@FindBy(css = "ul > li > span > span > span > span")
	WebElement arrowToGetCustomProfileOptions;
	@FindBy(css = "div[class='k-animation-container'] > div > ul[style='overflow: auto; height: auto;'] > li")
	List<WebElement> customProfileOptions;
	@FindBy(xpath = "//span[text()='*Specimen Id']")
	WebElement specimenIdTitle;

	public void selectCustomProfileOptions(WebDriver driver) throws InterruptedException {
		List<WebElement> customProfiles = WebUtil.createListOfElements(driver, customProfileOptions);
		randomNumber = WebUtil.randNumber(customProfiles.size());
		Thread.sleep(1000);
		customProfiles.get(randomNumber).click();
	}

	public void clickCustomProfileOptions(WebDriver driver) {
		WebUtil.click(driver, arrowToGetCustomProfileOptions);
	}

	public String fillInSpecimenID(WebDriver driver) throws InterruptedException {
		randomNumber = 1000 + WebUtil.randNumber(8999);
		specimenIDName = "DanU" + randomNumber;
		WebUtil.waitForElementVisible(driver, specimenIdTextfield);
		WebUtil.input(driver, specimenIDName, specimenIdTextfield);
		WebUtil.click(driver, specimenIdTitle);
		return specimenIDName;
	}

	public void clickPhysicianNameTextField(WebDriver driver) {
		WebUtil.click(driver, physicianNameTextfield);
	}

	public boolean verifyIfSpecimenIDunigue1(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		boolean myFlag = WebUtil.ifElementIsDisplayed(driver, uniqueMessage1);
		return myFlag;
	}

	public boolean verifyIfSpecimenIDunigue2(WebDriver driver) {
		boolean myFlag = WebUtil.ifElementIsDisplayed(driver, uniqueMessage2);
		return myFlag;
	}

	public void clickLastNameTextField(WebDriver driver) throws InterruptedException {
		WebUtil.waitForElementVisible(driver, lastNameTextField);
		Thread.sleep(1000);
		WebUtil.click(driver, lastNameTextField);
	}

	public void clickUninsuredRadioButton(WebDriver driver) throws Exception {
		WebUtil.clickHiddenElement(driver, uninsuredRadiobutton);
	}

	public void inputDiagnosisCode(WebDriver driver, String diagnosisCode) throws Exception {
		WebUtil.getElementVisible(driver, selectDiagnosisTextfield);
		WebUtil.input(driver, diagnosisCode, selectDiagnosisTextfield);
	}

	public void selectDiagnosisOption(WebDriver driver) throws Exception {
		Thread.sleep(1000);
		List<WebElement> diagnosOptions = WebUtil.createListOfElements(driver, listDiagnosOptions);
		randomNumber = WebUtil.randNumber(diagnosOptions.size());
		Thread.sleep(1000);
		diagnosOptions.get(randomNumber).click();
	}

	public void clickUrineRadioButton(WebDriver driver) throws Exception {
		WebUtil.clickHiddenElement(driver, urineRadioButton);
	}

	public void clickRecordPOCResultsExpand(WebDriver driver) throws Exception {
		WebUtil.clickHiddenElement(driver, recordPOCResultsExpand);
	}

	public void selectRecordPOCResults(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		List<WebElement> posCheckBoxes = WebUtil.createListOfElements(driver, recordPOCResultsPositive);
		List<WebElement> negCheckBoxes = WebUtil.createListOfElements(driver, recordPOCResultsNegative);
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
				je.executeScript("arguments[0].scrollIntoView(true);", urineRadioButton);
			}
		} while (maxNum < 6);

	}

	public void clickPerformCustomProfile(WebDriver driver) throws Exception {
		WebUtil.clickHiddenElement(driver, PerformCustomProfileModule);
	}

	public void clickMedicationsCheckBoxes(WebDriver driver) throws InterruptedException {
		List<WebElement> medicationsCheckBoxes = WebUtil.createListOfElements(driver, listMedicationsCheckBoxes);
		maxNum = 0;
		do {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			randomNumber = WebUtil.randNumber(medicationsCheckBoxes.size());
			WebElement myElement = medicationsCheckBoxes.get(randomNumber);
			js.executeScript("arguments[0].click();", myElement);
			maxNum++;
		} while (maxNum < 8);
	}

	public void inputcollectorInitials(WebDriver driver) {
		WebUtil.input(driver, "DU", collectorInitialsTextfield);
	}

	public void clickFinalSubmitButton(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		WebUtil.click(driver, submitButton);
	}

	public void clickInsuredRadioButton(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		WebUtil.clickHiddenElement(driver, insuredRadioButton);

	}

	public void clickInsuranceNameTextfield(WebDriver driver) throws Exception {
		Thread.sleep(3000);
		WebUtil.clickHiddenElement(driver, insuranceNameTextfield);
		Thread.sleep(3000);
	}
}
