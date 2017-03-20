/**
 * 
 */
package iConnectConsulting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iConnectConsulting.pageobjects.AddNewPatientInsurancePopup_PO;
import com.iConnectConsulting.pageobjects.AddNewPatientPopup_PO;
import com.iConnectConsulting.pageobjects.CertificationOfTestOrderPopup_PO;
import com.iConnectConsulting.pageobjects.DashBoardPage_PO;
import com.iConnectConsulting.pageobjects.SelectPatientsPopup_PO;
import com.iConnectConsulting.pageobjects.OrderPlacedPopup_PO;
import com.iConnectConsulting.pageobjects.PatientInsurancePopup_PO;
import com.iConnectConsulting.pageobjects.PhysicianNamePopup_PO;
import com.iConnectConsulting.pageobjects.SampleTemplateSelectionPopup_PO;
import com.iConnectConsulting.pageobjects.SignInPage_PO;
import com.iConnectConsulting.pageobjects.TestOrderPage_PO;
import com.iConnectConsulting.util.WebUtil;

/**
 * @author dancalif
 *
 */
public class TestOrderTab extends MainTest {

	String specimenIDName = "";

	@Test(enabled = false)
	public void testOrderSubmit() throws Exception {
		SignInPage_PO signInPage = PageFactory.initElements(driver, SignInPage_PO.class);
		signInPage.login(driver, user);
		signInPage.clickSignInButton(driver);
		DashBoardPage_PO dashBoardPage = PageFactory.initElements(driver, DashBoardPage_PO.class);
		dashBoardPage.clickTestOrderButton(driver);
		SampleTemplateSelectionPopup_PO sampleTemplateSelectionPopup = PageFactory.initElements(driver, SampleTemplateSelectionPopup_PO.class);
		sampleTemplateSelectionPopup.clickPrecisionDiagnostics(driver);
		TestOrderPage_PO testOrderPage = PageFactory.initElements(driver, TestOrderPage_PO.class);
		// Fill in Specimen Id textfield
		testOrderPage.fillInSpecimenID(driver);
		// Click Physician Name textfield
		testOrderPage.clickPhysicianNameTextField(driver);
		PhysicianNamePopup_PO physicianNamePopup = PageFactory.initElements(driver, PhysicianNamePopup_PO.class);
		// Select any physician
		physicianNamePopup.clickPhysicianName(driver);
		// Click Apply selected button
		physicianNamePopup.clickApplySelectedButton(driver);
		// Verify if Specimen ID is unique
		testOrderPage.verifyIfSpecimenIDunigue(driver);
		// Click Last Name box
		testOrderPage.clickLastNameTextField(driver);
		SelectPatientsPopup_PO selectPatientsPopup = PageFactory.initElements(driver, SelectPatientsPopup_PO.class);
		// Click Add New button
		selectPatientsPopup.clickAddNewButton(driver);
		AddNewPatientPopup_PO addNewPatientPopup = PageFactory.initElements(driver, AddNewPatientPopup_PO.class);
		// Enter Date of Birth
		addNewPatientPopup.fillInDateOfBirthTextfield(driver);
		// Fill out Last name text field
		addNewPatientPopup.fillLastNameTextfield(driver);
		// Fill out First name text field
		addNewPatientPopup.fillFirstNameTextfield(driver);
		// Select a gender
		addNewPatientPopup.selectMaleFemaleRadioButton(driver);
		// Click Submit button
		addNewPatientPopup.clickSubmitButton(driver);
		// Select uninsured radio button
		testOrderPage.clickUninsuredRadioButton(driver);
		// Enter 304 under DIAGNOSIS CODES
		testOrderPage.inputDiagnosisCode(driver);
		// Select any diagnosis from dropdown menue
		testOrderPage.selectDiagnosisOption(driver);
		// Click Urine radiobutton under SPECIMEN TYPE
		testOrderPage.clickUrineRadioButton(driver);
		// Click RECORD POC RESULTS to expand the options
		testOrderPage.clickRecordPOCResultsExpand(driver);
		// Select several checkboxes under RECORD POC RESULTS
		testOrderPage.selectRecordPOCResults(driver);
		// Click Perform Custom Profile under SELECT YOUR TESTING OPTION
		testOrderPage.clickPerformCustomProfile(driver);
		// Select MEDICATIONS
		testOrderPage.clickMedicationsCheckBoxes(driver);
		// Enter initials into the Collector's initials textfield
		testOrderPage.inputcollectorInitials(driver);
		// Click Submit button
		testOrderPage.clickFinalSubmitButton(driver);
		CertificationOfTestOrderPopup_PO certificationOfTestOrderPopup = PageFactory.initElements(driver, CertificationOfTestOrderPopup_PO.class);
		// Click Agree on the disclaimer
		certificationOfTestOrderPopup.clickAgreeButton(driver);
		// Verify if Order placed module is displayed
		OrderPlacedPopup_PO orderPlacedPopup = PageFactory.initElements(driver, OrderPlacedPopup_PO.class);
		Assert.assertEquals("Order Placed", orderPlacedPopup.doesOrderPlacedExist(driver));
		// Verify name of patient
		Assert.assertEquals(specimenIDName, orderPlacedPopup.doesNameUnderOrderMatch(driver));
		// Verify if Print button is displayed
		orderPlacedPopup.doesPrintButtonExist(driver);
		// Click Print button
		orderPlacedPopup.clickPrintButton(driver);
		//Switching to another window
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		//Verify if url contains specimen ID name
		String getURL = driver.getCurrentUrl();
		Assert.assertTrue(getURL.contains(specimenIDName));
		//Switching back to parent window
		driver.switchTo().window(tabs2.get(0));
		// click OK button to finish
		Thread.sleep(2000);
		orderPlacedPopup.clickOkButton(driver);
	}

	@Test(enabled = true)
	public void testOrderSubmitUninsured() throws Exception {
		
		SignInPage_PO signInPage = PageFactory.initElements(driver, SignInPage_PO.class);
		signInPage.login(driver, user);
		signInPage.clickSignInButton(driver);
		DashBoardPage_PO dashBoardPage = PageFactory.initElements(driver, DashBoardPage_PO.class);
		dashBoardPage.clickTestOrderButton(driver);
		SampleTemplateSelectionPopup_PO sampleTemplateSelectionPopup = PageFactory.initElements(driver, SampleTemplateSelectionPopup_PO.class);
		sampleTemplateSelectionPopup.clickPrecisionDiagnostics(driver);
		TestOrderPage_PO testOrderPage = PageFactory.initElements(driver, TestOrderPage_PO.class);
		// Fill in Specimen Id textfield
		testOrderPage.fillInSpecimenID(driver);
		// Click Physician Name textfield
		testOrderPage.clickPhysicianNameTextField(driver);
		PhysicianNamePopup_PO physicianNamePopup = PageFactory.initElements(driver, PhysicianNamePopup_PO.class);
		// Select any physician
		physicianNamePopup.clickPhysicianName(driver);
		// Click Apply selected button
		physicianNamePopup.clickApplySelectedButton(driver);
		// Verify if Specimen ID is unique
		testOrderPage.verifyIfSpecimenIDunigue(driver);
		// Click Last Name box
		testOrderPage.clickLastNameTextField(driver);
		SelectPatientsPopup_PO selectPatientsPopup = PageFactory.initElements(driver, SelectPatientsPopup_PO.class);
		// Click Add New button
		selectPatientsPopup.clickAddNewButton(driver);
		AddNewPatientPopup_PO addNewPatientPopup = PageFactory.initElements(driver, AddNewPatientPopup_PO.class);
		// Enter Date of Birth
		addNewPatientPopup.fillInDateOfBirthTextfield(driver);
		// Fill out Last name text field
		addNewPatientPopup.fillLastNameTextfield(driver);
		// Fill out First name text field
		addNewPatientPopup.fillFirstNameTextfield(driver);
		// Select a gender
		addNewPatientPopup.selectMaleFemaleRadioButton(driver);
		// Click Submit button
		addNewPatientPopup.clickSubmitButton(driver);
		// Click Insired button
		testOrderPage.clickInsuredRadioButton(driver);
		//Click Insurance Name textfield
		testOrderPage.clickInsuranceNameTextfield(driver);
		// Selecting insurance
		PatientInsurancePopup_PO patientInsurancePopup = PageFactory.initElements(driver, PatientInsurancePopup_PO.class);
		//Click add new insurance
		patientInsurancePopup.clickAddNewInsuranceButton(driver);
		AddNewPatientInsurancePopup_PO addNewPatientInsurancePopup = PageFactory.initElements(driver, AddNewPatientInsurancePopup_PO.class);
		//Click Add button to add new insurance
		addNewPatientInsurancePopup.clickNameInAddNewPatientInsurance(driver);
		
				
				
			
				
		
		
		
		
		
		// patientInsurancePopup.getMaxNumberOfPages(driver);

		WebElement lastPageOfInsuranceProviders = driver.findElement(By.xpath(
				"//a[@class='k-link k-pager-nav']/following-sibling::a[@class='k-link k-pager-nav k-pager-last']"));
		String paginationInsuranceProvidersString = lastPageOfInsuranceProviders.getAttribute("data-page");
		int numberOfPagesInsProviders = Integer.parseInt(paginationInsuranceProvidersString);
		// int desiredPageInsProvider =
		// WebUtil.randNumber(numberOfPagesInsProviders);
		int desiredPageInsProvider = 6;

		WebElement currentPageInsProviders = null;
		int currentPage = 0;
		do {
			currentPageInsProviders = driver.findElement(By.xpath(
					"//div[@class='ng-scope ng-isolate-scope k-grid k-widget k-reorderable']//div//ul//li//span[@class='k-state-selected']"));
			String currentPageString = currentPageInsProviders.getText();
			currentPage = Integer.parseInt(currentPageString);
			Random rand = new Random();

			if (currentPage != desiredPageInsProvider) {
				Thread.sleep(3000);
				WebUtil.click(driver, By.xpath("//a[@class='k-link k-pager-nav']//span[@class='k-icon k-i-arrow-e']"));
			} else {
				Thread.sleep(3000);
				List<WebElement> insuranceProvidersA = driver.findElements(
						By.xpath("//table[@class='k-selectable']//tbody[@role='rowgroup']//tr[@class='ng-scope']"));
				List<WebElement> insuranceProvidersB = driver.findElements(By
						.xpath("//table[@class='k-selectable']//tbody[@role='rowgroup']//tr[@class='k-alt ng-scope']"));
				int totalInsuranceProviders = insuranceProvidersA.size() + insuranceProvidersB.size();
				int randomNumber = rand.nextInt(totalInsuranceProviders);
				Thread.sleep(1000);
				if (randomNumber <= 5) {
					int randomNum = rand.nextInt(insuranceProvidersA.size());
					insuranceProvidersA.get(randomNum).click();
				} else {
					int randomNum = rand.nextInt(insuranceProvidersB.size());
					insuranceProvidersB.get(randomNum).click();
				}

				WebUtil.click(driver, By.xpath(
						"//div[@index='2']//div//div//div//div//button[@class='btn btn-primary btn-form-md']//span[text()='Apply selected']"));
			}
		} while (currentPage != desiredPageInsProvider);
		Thread.sleep(2000);
		WebUtil.click(driver, By.xpath("//button[@class='btn btn-primary btn-form-md']//span[text()='Submit']"));
		Thread.sleep(2000);
		
		
		
		// Enter 304 under DIAGNOSIS CODES
		testOrderPage.inputDiagnosisCode(driver);
		// Select any diagnosis from dropdown menue
		testOrderPage.selectDiagnosisOption(driver);
		// Click Urine radiobutton under SPECIMEN TYPE
		testOrderPage.clickUrineRadioButton(driver);
		// Click RECORD POC RESULTS to expand the options
		testOrderPage.clickRecordPOCResultsExpand(driver);
		// Select several checkboxes under RECORD POC RESULTS
		testOrderPage.selectRecordPOCResults(driver);
		// Click Perform Custom Profile under SELECT YOUR TESTING OPTION
		testOrderPage.clickPerformCustomProfile(driver);
		// Select MEDICATIONS
		testOrderPage.clickMedicationsCheckBoxes(driver);
		// Enter initials into the Collector's initials textfield
		testOrderPage.inputcollectorInitials(driver);
		// Click Submit button
		CertificationOfTestOrderPopup_PO certificationOfTestOrderPopup = testOrderPage.clickFinalSubmitButton(driver);
		// Click Agree on the disclaimer
		OrderPlacedPopup_PO orderPlacedPopup = certificationOfTestOrderPopup.clickAgreeButton(driver);
		Thread.sleep(2000);
		// Verify if Order placed module is displayed
		Assert.assertEquals("Order Placed", orderPlacedPopup.doesOrderPlacedExist(driver));
		// Verify name of patient
		Assert.assertEquals(specimenIDName, orderPlacedPopup.doesNameUnderOrderMatch(driver));
		// AssertJUnit.assertEquals(specimenIDName,
		// orderPlacedPopup.doesNameUnderOrderMatch(driver));
		// Verify if Print button is displayed
		orderPlacedPopup.doesPrintButtonExist(driver);
		// Click Print button
		orderPlacedPopup.clickPrintButton(driver);
		Thread.sleep(2000);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		String getURL = driver.getCurrentUrl();
		Assert.assertTrue(getURL.contains(specimenIDName));
		Thread.sleep(2000);
		// AssertJUnit.assertTrue(getURL.contains(specimenIDName));
		driver.switchTo().window(tabs2.get(0));
		// click OK button to finish
		Thread.sleep(2000);
		orderPlacedPopup.clickOkButton(driver);

	}

}
