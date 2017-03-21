package com.iConnectConsulting.pageobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.iConnectConsulting.util.WebUtil;

public class PublishedReportsPage_PO {

	@FindBy(xpath = "//span[text()='Published Reports']")
	WebElement publishedReportsPageTitle;
	@FindBy(css = "table > tbody > tr > td:nth-child(3)")
	List<WebElement> specimenIDsList;
	@FindBy(css = "div[class='textLayer'] > div")
	WebElement reportPDF;
	@FindBy(css = "div[class='textLayer'] > div")
	List<WebElement> reportSpecomenIDNames;

	public boolean ifPublishedReportsPageDisplayed(WebDriver driver) {
		return publishedReportsPageTitle.isDisplayed();
	}
	
	public void verifySpecimenIDonTheReport(WebDriver driver) throws InterruptedException{
	Random rand = new Random();
	
	int specimenIDsNum = specimenIDsList.size();
	int randomNum = WebUtil.randNumber(specimenIDsNum);
	String specimenIDName = specimenIDsList.get(randomNum).getText();

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", specimenIDsList.get(randomNum));

	Thread.sleep(2000);
	ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tabs2.get(1));
	WebUtil.waitForElementVisible(driver, reportPDF);
	int countNum = 0;
	for (WebElement nextItem : reportSpecomenIDNames) {
		countNum++;
		if (nextItem.getText().equalsIgnoreCase(specimenIDName)) {
			Assert.assertEquals(specimenIDName, nextItem.getText());
			break;
		} else {
			if (specimenIDsList.size() == countNum) {
				Assert.fail("The SpecimenID that was submitted " + specimenIDName
						+ " doesn't match with the SpecimenID on the report.");
			}
		}
	}
	driver.switchTo().window(tabs2.get(0));
	}
}