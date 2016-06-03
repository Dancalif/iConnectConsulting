/**
 * 
 */
package iConnectConsulting;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iConnectConsulting.pageobjects.AddNewPatientPopup;
import com.iConnectConsulting.pageobjects.CertificationOfTestOrderPopup;
import com.iConnectConsulting.pageobjects.DashBoardPage;
import com.iConnectConsulting.pageobjects.LastNamePopup;
import com.iConnectConsulting.pageobjects.OrderPlacedcePopup;
import com.iConnectConsulting.pageobjects.PhysicianNamePopup;
import com.iConnectConsulting.pageobjects.SignInPage;
import com.iConnectConsulting.pageobjects.TestOrderPage;
import com.iConnectConsulting.util.WebUtil;

/**
 * @author dancalif
 *
 */
public class LabwebportalLoginTest {
	WebDriver driver = new FirefoxDriver();
	JavascriptExecutor je = (JavascriptExecutor) driver;
	Actions action = new Actions(driver);
	Random rand = new Random();
	WebDriverWait wait = new WebDriverWait(driver, 30);
	int randomNumber, numberID, maxNum = 0;
	String specimenIDName = "";

	@Ignore
	@Test
	public void labwebportalLoginPass() {
		// Got to www.labwebportal.com
		SignInPage signInPage = WebUtil.goToSignInPage(driver);
		// Fill in username
		signInPage.fillInUserName(driver, "ptox");
		// Fill in password
		signInPage.fillInPassword(driver, "ptox2013");
		// Click Sing in button
		DashBoardPage dashBoardPage = signInPage.clickSignInButton(driver);
		// Verify if user successfully signed in
		Assert.assertTrue("Dashboard is not shown up", dashBoardPage.doesDashboardExist(driver));
		// Sign out
		signInPage = dashBoardPage.signOut(driver);
		// Verify if user is signed out
		Assert.assertTrue("User is not signed out", signInPage.doesUsernameExist(driver));
	}

	@Test
	public void testOrderSubmit() throws InterruptedException {
		// Got to www.labwebportal.com
		SignInPage signInPage = WebUtil.goToSignInPage(driver);
		// Fill in username
		signInPage.fillInUserName(driver, "ptox");
		// Fill in password
		signInPage.fillInPassword(driver, "ptox2013");
		// Click Sing in button
		DashBoardPage dashBoardPage = signInPage.clickSignInButton(driver);
		// Click Test Order button on the navigation panel
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
		testOrderPage.scrollToBillingMethod(driver);
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
		// Click Agree on the desclaimer
		OrderPlacedcePopup orderPlacedPopup = certificationOfTestOrderPopup.clickAgreeButton(driver);
		// Verify if Order placed module is displayed
		assertEquals("Order Placed", orderPlacedPopup.doesOrderPlacedExist(driver));
		// Verify name of patient
		assertEquals(specimenIDName, orderPlacedPopup.doesNameUnderOrderMatch(driver));
		// click OK button to finish
		Thread.sleep(2000);
		orderPlacedPopup.clickOkButton(driver);
		System.out.print(specimenIDName);

		// Verify if order was placed
		// WebElement allSpecimensButton =
		// driver.findElement(By.cssSelector("a[href='#/all-specimens']"));
		// allSpecimensButton.click();
	}

	@After
	public void tearDown() {
		// Clean up enviroment
		driver.quit();
	}
}
