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
import com.iConnectConsulting.pageobjects.SelectPatientInsurancePopup_PO;
import com.iConnectConsulting.pageobjects.OrderPlacedPopup_PO;
import com.iConnectConsulting.pageobjects.PatientInsurancePopup_PO;
import com.iConnectConsulting.pageobjects.PhysicianNamePopup_PO;
import com.iConnectConsulting.pageobjects.SampleTemplateSelectionPopup_PO;
import com.iConnectConsulting.pageobjects.SelectInsuranceProvidersPopup_PO;
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
		SelectPatientInsurancePopup_PO selectPatientsPopup = PageFactory.initElements(driver, SelectPatientInsurancePopup_PO.class);
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
		testOrderPage.clickSignOut(driver);
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
		SelectPatientInsurancePopup_PO selectPatientsPopup = PageFactory.initElements(driver, SelectPatientInsurancePopup_PO.class);
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
		SelectInsuranceProvidersPopup_PO selectInsuranceProvidersPopup = PageFactory.initElements(driver, SelectInsuranceProvidersPopup_PO.class);
		//Selecting desired page number in pagination and click random insurance provider on it
		selectInsuranceProvidersPopup.selectingInsuranceProvider(driver);
		addNewPatientInsurancePopup.clickSubmitButton(driver);
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
		testOrderPage.clickSignOut(driver);
	}
}
