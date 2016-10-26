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

import com.iConnectConsulting.pageobjects.AddNewPatientPopup;
import com.iConnectConsulting.pageobjects.CertificationOfTestOrderPopup;
import com.iConnectConsulting.pageobjects.DashBoardPage;
import com.iConnectConsulting.pageobjects.LastNamePopup;
import com.iConnectConsulting.pageobjects.OrderPlacedcePopup;
import com.iConnectConsulting.pageobjects.PatientInsurancePopup;
import com.iConnectConsulting.pageobjects.PhysicianNamePopup;
import com.iConnectConsulting.pageobjects.SampleTemplateSelectionPopup;
import com.iConnectConsulting.pageobjects.SignInPage;
import com.iConnectConsulting.pageobjects.TestOrderPage;
import com.iConnectConsulting.util.WebUtil;

/**
 * @author dancalif
 *
 */
public class TestOrderTab extends MainTest {

	// public SignInPage signInPage = PageFactory.initElements(getWebDriver(),
	// SignInPage.class);
	String specimenIDName = "";

	@Test(enabled = false)
	public void labwebportalLoginPass() throws InterruptedException {
		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
		DashBoardPage dashBoardPage = signInPage.login(driver, user);
		signInPage.clickSignInButton(driver);
		// Verify if user successfully signed in
		Thread.sleep(2000);
		Assert.assertTrue(dashBoardPage.doesDashboardExist(driver), "Dashboard is not shown up");
		// Sign out
		signInPage = dashBoardPage.signOut(driver);
		// Verify if user is signed out
		Assert.assertTrue(signInPage.doesUsernameExist(driver), "User is not signed out");
	}

	@Test(enabled = false)
	public void testOrderSubmit() throws Exception {
		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
		DashBoardPage dashBoardPage = signInPage.login(driver, user);
		signInPage.clickSignInButton(driver);
		TestOrderPage testOrderPage = dashBoardPage.clickTestOrderButton(driver);
		SampleTemplateSelectionPopup sampletemplateselectionpopup = dashBoardPage.clickPrecisionDiagnostics(driver);
		// Fill in Specimen Id textfield
		specimenIDName = testOrderPage.fillInSpecimenID(driver);
		// Click Physician Name textfield
		PhysicianNamePopup physicianNamePopup = testOrderPage.clickPhysicianNameTextField(driver);
		// Select any physician
		physicianNamePopup.clickPhysicianName(driver);
		// Click Apply selected button
		physicianNamePopup.clickApplySelectedButton(driver);
		// Verify if Specimen ID is unique
		testOrderPage.verifyIfSpecimenIDunigue(driver);
		// Click Last Name box
		LastNamePopup lastNamePopup = testOrderPage.clickLastNameTextField(driver);
		// Click Add New button
		AddNewPatientPopup addNewPatientPopup = lastNamePopup.clickAddNewButton(driver);
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
		CertificationOfTestOrderPopup certificationOfTestOrderPopup = testOrderPage.clickFinalSubmitButton(driver);
		// Click Agree on the disclaimer
		OrderPlacedcePopup orderPlacedPopup = certificationOfTestOrderPopup.clickAgreeButton(driver);
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
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		String getURL = driver.getCurrentUrl();
		Assert.assertTrue(getURL.contains(specimenIDName));
		// AssertJUnit.assertTrue(getURL.contains(specimenIDName));
		System.out.println(specimenIDName);
		driver.switchTo().window(tabs2.get(0));
		// click OK button to finish
		Thread.sleep(2000);
		orderPlacedPopup.clickOkButton(driver);
	}

	@Test(enabled = true)
	public void testOrderSubmitUninsured() throws Exception {
		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
		Thread.sleep(2000);
		DashBoardPage dashBoardPage = signInPage.login(driver, user);
		signInPage.clickSignInButton(driver);
		TestOrderPage testOrderPage = dashBoardPage.clickTestOrderButton(driver);
		SampleTemplateSelectionPopup sampletemplateselectionpopup = dashBoardPage.clickPrecisionDiagnostics(driver);
		// WebUtil.getElementVisible(driver, By.cssSelector("input"));
		// Fill in Specimen Id textfield
		specimenIDName = testOrderPage.fillInSpecimenID(driver);
		// Click Physician Name textfield
		// PhysicianNamePopup physicianNamePopup =
		// testOrderPage.clickPhysicianNameTextField(driver);
		// Select any physician
		// physicianNamePopup.clickPhysicianName(driver);
		// Click Apply selected button
		// physicianNamePopup.clickApplySelectedButton(driver);
		// Verify if Specimen ID is unique
		testOrderPage.verifyIfSpecimenIDunigue(driver);
		// Click Last Name box
		LastNamePopup lastNamePopup = testOrderPage.clickLastNameTextField(driver);
		// Click Add New button
		AddNewPatientPopup addNewPatientPopup = lastNamePopup.clickAddNewButton(driver);
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
		// Selectin insurance
		PatientInsurancePopup patientInsurancePopup = testOrderPage.clickInsuranceNameTextfield(driver);
		//
		Thread.sleep(3000);
		patientInsurancePopup.clickAddNewInsuranceButton(driver);
		Thread.sleep(1000);
		patientInsurancePopup.clickNameInAddNewPatientInsurance(driver);
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
		CertificationOfTestOrderPopup certificationOfTestOrderPopup = testOrderPage.clickFinalSubmitButton(driver);
		// Click Agree on the disclaimer
		OrderPlacedcePopup orderPlacedPopup = certificationOfTestOrderPopup.clickAgreeButton(driver);
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
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		String getURL = driver.getCurrentUrl();
		Assert.assertTrue(getURL.contains(specimenIDName));
		// AssertJUnit.assertTrue(getURL.contains(specimenIDName));
		System.out.println(specimenIDName);
		driver.switchTo().window(tabs2.get(0));
		// click OK button to finish
		Thread.sleep(2000);
		orderPlacedPopup.clickOkButton(driver);

	}

}
