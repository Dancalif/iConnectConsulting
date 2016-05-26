/**
 * 
 */
package iConnectConsulting;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author dancalif
 *
 */
public class LabwebportalLoginTest {
	WebDriver driver = new FirefoxDriver();
	JavascriptExecutor je = (JavascriptExecutor) driver;
	Actions action = new Actions(driver);
	Random rand = new Random();
	StringBuilder randomString = new StringBuilder();
	String candidateChars = "abcdefghijklmnopqrstuvwxyz";
	// @Test
	// public void labwebportalLoginPass() {
	// // 1. Got to www.labwebportal.com
	// driver.get("https://www.labwebportal.com/Precision_v7_dev/#/login");
	// // 2. Fill in username
	// WebElement usernameTextField = driver.findElement(By.id("username"));
	// usernameTextField.clear();
	// usernameTextField.sendKeys("ptox");
	// // 3. Fill in password
	// WebElement passwordTextField = driver.findElement(By.name("password"));
	// passwordTextField.clear();
	// passwordTextField.sendKeys("ptox2013");
	// // 4. Click Sing in button
	// WebElement signInButton =
	// driver.findElement(By.xpath("//*[@type='submit']"));
	// signInButton.click();
	// // 5. Verify if user successfully signed in
	// WebDriverWait wait = new WebDriverWait(driver, 30);
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='#/dashboard']")));
	// Assert.assertTrue("Dashboard exists",
	// driver.findElement(By.cssSelector("a[href='#/dashboard']")).isDisplayed());
	// WebElement profileButton = driver.findElement(By.xpath("//*[@class = 'fa
	// fa-caret-down']"));
	// profileButton.click();
	// WebElement signoutButton = driver.findElement(By.linkText("Logout"));
	// signoutButton.click();
	// // 6. Verify if user is signed out
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).isDisplayed();
	// Assert.assertTrue("User is not signed out",
	// driver.findElement(By.id("username")).isDisplayed());
	// }

	@Test
	public void testOrderSubmit() throws InterruptedException {
		// 1. Got to www.labwebportal.com
		driver.get("https://www.labwebportal.com/Precision_v7_dev/#/login");
		driver.manage().window().maximize();
		// 2. Fill in username
		WebElement usernameTextField = driver.findElement(By.id("username"));
		usernameTextField.clear();
		usernameTextField.sendKeys("ptox");
		// 3. Fill in password
		WebElement passwordTextField = driver.findElement(By.name("password"));
		passwordTextField.clear();
		passwordTextField.sendKeys("ptox2013");
		// 4. Click Sing in button
		WebElement signInButton = driver.findElement(By.xpath("//*[@type='submit']"));
		signInButton.click();
		// 5. Verify if user successfully signed in
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='#/dashboard']")));
		Assert.assertTrue("Dashboard exists",
				driver.findElement(By.cssSelector("a[href='#/dashboard']")).isDisplayed());
		// 6. Click Test Order button on the navigation panel
		WebElement testOrder = driver.findElement(By.cssSelector("a[href='#/test-order']"));
		testOrder.click();
		// 7. Fill in Specimen Id textfield
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input")));
		WebElement specimenID = driver.findElement(By.cssSelector("input"));
		int numberID = 1000 + rand.nextInt(8999);
		String specimenIDName = "DanU" + numberID;
		specimenID.clear();
		specimenID.sendKeys(specimenIDName);
		// 8. Click Physician Name textfield
		WebElement physicianName = driver.findElement(By.cssSelector("i[class='fa fa-ellipsis-h']"));
		physicianName.click();
		// 9. Select any physician
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("k-grid-content")));
		WebElement physicianNameTable = driver.findElement(By.className("k-grid-content"));
		List<WebElement> rowsPhysicianName = physicianNameTable.findElements(By.tagName("tr"));
		int randomNumber = rand.nextInt(rowsPhysicianName.size());
		for (int i = 0; i < rowsPhysicianName.size(); i++)

		{
			if (i == randomNumber) {
				rowsPhysicianName.get(i).click();
				break;
			}
		}

		// 10. Click Apply selected button
		WebElement applySelectedButtonPhysicians = driver
				.findElement(By.xpath("//button[@class='btn btn-primary btn-form-md']"));
		applySelectedButtonPhysicians.click();

		// Verify if Specimen ID is unique
		boolean doFlag = false;
		do {
			try {
				WebElement uniqueMessage = driver.findElement(By.xpath("//span[text()='The value is not unique']"));
				if (uniqueMessage.isDisplayed()) {
					numberID = 1000 + rand.nextInt(8999);
					specimenIDName = "DanU" + numberID;
					specimenID.clear();
					specimenID.sendKeys(specimenIDName);
				} else {
					break;
				}
			} catch (Exception e1) {
				doFlag = true;
			}
		} while (doFlag == false);

		// 11. Click Last Name box
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"design-item-lookup[data-item-id='Sample___PID'] > div > div > div > div > div > div[class='input-group-btn']")));
		WebElement lastNameTextField = driver.findElement(By.cssSelector(
				"design-item-lookup[data-item-id='Sample___PID'] > div > div > div > div > div > div[class='input-group-btn']"));
		lastNameTextField.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("button[class='btn btn-default btn-form-md pull-left ng-scope']")));
		// 12. Click Add New button
		WebElement addNewButton = driver
				.findElement(By.cssSelector("button[class='btn btn-default btn-form-md pull-left ng-scope']"));
		addNewButton.click();
		// Enter Date of Birth
		WebElement addDateOfBirth = driver.findElement(By.cssSelector(
				"input[class='form-control item-focusable order-field-input ng-pristine ng-untouched ng-valid empty k-input']"));
		addDateOfBirth.clear();
		addDateOfBirth.sendKeys("12/21/1978");
		// Fill out Last name text field
		WebElement addLastName = driver.findElement(By.xpath("(//input[@type='text'])[42]"));

		// String lastName =
		// StringBuilder sb = new StringBuilder();

		int lengthOfLastName = 8;
		int doFlagInt = 0;
		do

		{
			for (int i = 0; i < lengthOfLastName; i++) {
				randomString.append(candidateChars.charAt(rand.nextInt(candidateChars.length())));
				doFlagInt++;
			}
		} while (doFlagInt < 8);

		addLastName.clear();
		addLastName.sendKeys(randomString);

		// Fill out First name text field
		WebElement addFirstName = driver.findElement(By.xpath("(//input[@type='text'])[43]"));
		addFirstName.clear();
		addFirstName.sendKeys("Dan");

		List<WebElement> maleFemaleRadioButtons = driver.findElements(By.cssSelector(
				"design-item-list-box[class='lwp-design__item col-md-6 column ng-isolate-scope'][data-item-id='Patients___SEX'] > div > div > ul > li > div > fa-radio"));
		maleFemaleRadioButtons.get(1).click();
		// Click Submit button
		WebElement submitButton = driver.findElement(
				By.xpath("//button[contains(@class,'btn btn-primary btn-form-md')]//span[text()='Submit']"));
		Thread.sleep(3000);
		addDateOfBirth.click();
		Thread.sleep(1000);
		addDateOfBirth.click();
		submitButton.click();
		Thread.sleep(1000);
		WebElement scrollToBillingMethodSection = driver.findElement(By.xpath("//span[text()='Birth Date']"));
		scrollToBillingMethodSection.sendKeys(Keys.PAGE_DOWN);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[contains(@class,'lwp-checkbox')]//span[text()='Uninsured']")));
		Thread.sleep(3000);
		WebElement uninsuredRadioButton = driver
				.findElement(By.xpath("//div[contains(@class,'lwp-checkbox')]//span[text()='Uninsured']"));
		uninsuredRadioButton.click();
		// Enter 304 under DIAGNOSIS CODES
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder, 'Select diagnosis...')]")));
		WebElement diagnosisCodeInput = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'Select diagnosis...')]"));
		diagnosisCodeInput.sendKeys("304");
		// Select any diagnos from dropdown menue
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='k-state-default']")));
		List<WebElement> diagnosOptions = driver.findElements(By.cssSelector("span[class='k-state-default']"));
		diagnosOptions.get(2).click();
		// Click Urine radiobutton under SPECIMEN TYPE
		WebElement urineRadioButton = driver
				.findElement(By.xpath("//div[contains(@class,'lwp-checkbox')]//span[text()='Urine']"));
		urineRadioButton.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		urineRadioButton.click();
		// Click RECORD POC RESULTS to expand the options
		WebElement recordPOCResultsExpand = driver.findElement(By.cssSelector(
				"design-item-group-box[data-item-id='502b26d4-5aed-4fe9-bbb7-7b8a88349309'] > div > div > div > a"));
		recordPOCResultsExpand.click();
		// Select several checkboxes under RECORD POC RESULTS

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
				je.executeScript("arguments[0].scrollIntoView(true);", urineRadioButton);
			}

			try {
				negCheckBoxes.get(negRandomNumber).click();
				maxNum++;
			} catch (Exception e) {
				je.executeScript("arguments[0].scrollIntoView(true);", urineRadioButton);
			}
		} while (maxNum < 6);

		// Click Perform Custom Profile under SELECT YOUR TESTING OPTION
		WebElement performCustomProfileCheckbox = driver
				.findElement(By.xpath("//span[text()='PERFORM CUSTOM PROFILE']"));
		performCustomProfileCheckbox.click();
		WebElement performCustomProfileArrow = driver.findElement(By.cssSelector("span[class='k-icon k-i-arrow-s']"));
		performCustomProfileArrow.click();
		Thread.sleep(1000);
		WebElement firstOptionCustomProfile = driver.findElement(By.xpath("//li[text()='FULLPANELMIX']"));
		firstOptionCustomProfile.click();
		// MEDICATIONS
		List<WebElement> medicationsCheckBoxes = driver.findElements(
				By.cssSelector("div[class='animated row fadeInRight'] > div > ul > li > div > div > fa-check-box > i"));

		// do {
		// randomNumber = rand.nextInt(medicationsCheckBoxes.size());
		// action.moveToElement(medicationsCheckBoxes.get(randomNumber));
		// action.perform();
		// maxNum++;
		// } while (maxNum < 8);
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

		// Enter initials into the Collector's initials textfield
		WebElement collectorInitialsTextField = driver.findElement(
				By.cssSelector("design-item-text-box[data-item-id='Sample___ORDERING_PHYSICIAN'] > div > div > input"));
		collectorInitialsTextField.clear();
		collectorInitialsTextField.sendKeys("DU");
		// Click Submit button
		WebElement finalSubmitButton = driver.findElement(By.xpath("//span[text()='Submit']"));
		finalSubmitButton.click();
		// Click Agree on the desclaimer
		WebElement agreeButon = driver.findElement(By.xpath("//span[text()='Agree']"));
		agreeButon.click();
		Thread.sleep(2000);
		// Verify if Order placed module is displayed
		String orderPlacedText = driver.findElement(By.xpath("//div[contains(@class,'modal-header')]/h1")).getText();

		assertEquals("Order Placed", orderPlacedText);
		// name of patient
		String nameUnderOrder = driver.findElement(By.xpath("//div[@class='modal-body']/div/p/b")).getText();
		assertEquals(specimenIDName, nameUnderOrder);
		// click OK button to finish
		Thread.sleep(2000);
		WebElement okButton = driver.findElement(By.xpath("//span[text()='OK']"));
		okButton.click();
		// Verify if order was placed
		WebElement allSpecimensButton = driver.findElement(By.cssSelector("a[href='#/all-specimens']"));
		allSpecimensButton.click();
	}

	// @After
	// public void tearDown() {
	// // Clean up enviroment
	// driver.quit();
	// }
}
