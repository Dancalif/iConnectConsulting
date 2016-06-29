/**
 * 
 */
package iConnectConsulting;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.iConnectConsulting.pageobjects.AddNewPatientPopup;
import com.iConnectConsulting.pageobjects.CertificationOfTestOrderPopup;
import com.iConnectConsulting.pageobjects.DashBoardPage;
import com.iConnectConsulting.pageobjects.LastNamePopup;
import com.iConnectConsulting.pageobjects.OrderPlacedcePopup;
import com.iConnectConsulting.pageobjects.PhysicianNamePopup;
import com.iConnectConsulting.pageobjects.SignInPage;
import com.iConnectConsulting.pageobjects.TestOrderPage;

/**
 * @author dancalif
 *
 */
public class LabWebportal extends MainTest {

	public SignInPage signInPage = PageFactory.initElements(getWebDriver(), SignInPage.class);
	String specimenIDName = "";

	@Test(enabled = true)
	public void labwebportalLoginPass() throws InterruptedException {
		DashBoardPage dashBoardPage = signInPage.login(driver, user);
		signInPage.clickSignInButton(driver);
		// Verify if user successfully signed in
		Assert.assertTrue(dashBoardPage.doesDashboardExist(driver), "Dashboard is not shown up");
		// Sign out
		signInPage = dashBoardPage.signOut(driver);
		// Verify if user is signed out
		Assert.assertTrue(signInPage.doesUsernameExist(driver), "User is not signed out");
	}

	@Test(enabled = false)
	public void testOrderSubmit() throws Exception {
		DashBoardPage dashBoardPage = signInPage.login(driver, user);
		TestOrderPage testOrderPage = dashBoardPage.clickTestOrderButton(driver);
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
		// Scroll to the elements
		// testOrderPage.scrollToBillingMethod(driver);
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
		AssertJUnit.assertEquals("Order Placed", orderPlacedPopup.doesOrderPlacedExist(driver));
		// Verify name of patient
		AssertJUnit.assertEquals(specimenIDName, orderPlacedPopup.doesNameUnderOrderMatch(driver));
		// Verify if Print button is displayed
		orderPlacedPopup.doesPrintButtonExist(driver);
		// Click Print button
		orderPlacedPopup.clickPrintButton(driver);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		String getURL = driver.getCurrentUrl();
		AssertJUnit.assertTrue(getURL.contains(specimenIDName));
		System.out.println(specimenIDName);
		driver.switchTo().window(tabs2.get(0));
		// click OK button to finish
		Thread.sleep(2000);
		orderPlacedPopup.clickOkButton(driver);
	}
}
