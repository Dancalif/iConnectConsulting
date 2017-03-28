package com.iConnectConsulting.pageobjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.iConnectConsulting.util.WebUtil;

public class SelectInsuranceProvidersPopup_PO {

	@FindBy(xpath = "//a[@class='k-link k-pager-nav']/following-sibling::a[@class='k-link k-pager-nav k-pager-last']")
	WebElement lastPageOfInsuranceProviders;
	@FindBy(xpath = "//div[@class='ng-scope ng-isolate-scope k-grid k-widget k-reorderable']//div//ul//li//span[@class='k-state-selected']")
	WebElement currentPageInsProviders;
	@FindBy(xpath = "//a[@class='k-link k-pager-nav']//span[@class='k-icon k-i-arrow-e']")
	WebElement nextPageArrow;
	@FindBy(xpath = "//table[@class='k-selectable']//tbody[@role='rowgroup']//tr[@class='ng-scope']")
	List<WebElement> insuranceProvidersA;
	@FindBy(xpath = "//table[@class='k-selectable']//tbody[@role='rowgroup']//tr[@class='k-alt ng-scope']")
	List<WebElement> insuranceProvidersB;
	@FindBy(xpath = "//div[@index='2']//div//div//div//div//button[@class='btn btn-primary btn-form-md']//span[text()='Apply selected']")
	WebElement applySelectedButton;

	public void selectingInsuranceProvider(WebDriver driver) throws InterruptedException {

		String paginationInsuranceProvidersString = lastPageOfInsuranceProviders.getAttribute("data-page");
		int numberOfPagesInsProviders = Integer.parseInt(paginationInsuranceProvidersString);
		int desiredPageInsProvider = 6;

		WebElement currentPageInsProviders = null;
		int currentPage = 0;
		do {
			String currentPageString = currentPageInsProviders.getText();
			currentPage = Integer.parseInt(currentPageString);
			Random rand = new Random();

			if (currentPage != desiredPageInsProvider) {
				Thread.sleep(3000);
				WebUtil.click(driver, nextPageArrow);
			} else {
				Thread.sleep(3000);
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

				WebUtil.click(driver, applySelectedButton);
			}
		} while (currentPage != desiredPageInsProvider);

	}

}
