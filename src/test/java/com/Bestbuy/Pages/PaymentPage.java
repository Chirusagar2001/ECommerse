package com.Bestbuy.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

	WebDriver driver;

	@FindBy(xpath = "//input[@id='number']")
	WebElement creditcardno;

	@FindBy(xpath = "//button[@class='btn btn-lg btn-block btn-primary']")
	WebElement placeyourorder;

	@FindBy(id = "invalid-card-details-message")
	private WebElement invalidCardDetailsMessage;

	public PaymentPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void placeyourorder(String creditnumber) {

		creditcardno.sendKeys(creditnumber);
		placeyourorder.click();

	}

	public String getInvalidCardDetailsMessage() {
		return invalidCardDetailsMessage.getText();
	}

}
