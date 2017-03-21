package com.iConnectConsulting.pageobjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.iConnectConsulting.util.WebUtil;

public class TestOrderPage_PO {
	String specimenIDName = "";
	Random rand = new Random();
	int randomNumber, numberID, maxNum = 0;
	
	@FindBy(css = "input[placeholder='Specimen Id']")
	WebElement specimenIdTextfield;
	@FindBy(css = "i[class='fa fa-ellipsis-h']")
	WebElement physicianNameTextfield;
	@FindBy(className = "k-grid-content")
	WebElement physiciansNamesTable;
	@FindBy(xpath = "//span[text()='The value is not unique']")
	WebElement uniqueMessage;
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
	
	
	public void fillInSpecimenID(WebDriver driver) {
		randomNumber = 1000 + WebUtil.randNumber(8999);
		specimenIDName = "DanU" + randomNumber;
		WebUtil.waitForElementVisible(driver, specimenIdTextfield);
		WebUtil.input(driver, specimenIDName, specimenIdTextfield);
	}

	public void clickPhysicianNameTextField(WebDriver driver) {
		WebUtil.click(driver, physicianNameTextfield);
		WebUtil.waitForElementVisible(driver, physiciansNamesTable);
	}

	public void verifyIfSpecimenIDunigue(WebDriver driver) throws InterruptedException {
		boolean doFlag = false;
		do {
			try {
				if (uniqueMessage.isDisplayed()) {
					randomNumber = 1000 + WebUtil.randNumber(rand.nextInt(8999));
					specimenIDName = "DanU" + randomNumber;
					specimenIdTextfield.clear();
					specimenIdTextfield.sendKeys(specimenIDName);
				} else {
					break;
				}
			} catch (Exception e1) {
				doFlag = true;
			}
		} while (doFlag == false);
		Thread.sleep(1000);
		WebUtil.waitForElementVisible(driver, lastNameTextField);
	}

	public void clickLastNameTextField(WebDriver driver) {
		WebUtil.click(driver, lastNameTextField);
	}

	public void clickUninsuredRadioButton(WebDriver driver) throws Exception {
		Thread.sleep(3000);
		WebUtil.clickHiddenElement(driver, uninsuredRadiobutton);
	}

	public void inputDiagnosisCode(WebDriver driver) throws Exception {
		WebUtil.getElementVisible(driver, selectDiagnosisTextfield);
		WebUtil.input(driver, "304", selectDiagnosisTextfield);
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
