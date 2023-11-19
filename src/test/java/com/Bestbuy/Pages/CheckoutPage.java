package com.Bestbuy.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	WebDriver driver;

	@FindBy(xpath = "//a[normalize-space()='Go to Cart']")
	WebElement gotocart;

	@FindBy(xpath = "//button[normalize-space()='Checkout']")
	WebElement checkoutbutton;

	@FindBy(xpath = "//button[@class='c-button c-button-secondary c-button-lg cia-guest-content__continue guest']")
	WebElement continueasguest;

	@FindBy(xpath = "//input[@id='firstName']")
	WebElement firstname1;

	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lastname1;

	@FindBy(xpath = "//input[@id='street']")
	WebElement address1;

	@FindBy(xpath = "//input[@id='city']")
	WebElement city1;

	@FindBy(xpath = "//select[@id='state']")
	WebElement state1;

	@FindBy(xpath = "//option[@value='AA']")
	WebElement value1;

	@FindBy(xpath = "//input[@id='zipcode']")
	WebElement pincodeInput;

	@FindBy(xpath = "//button[@class='c-button c-button-secondary c-button-md new-address-form__button']")
	WebElement apply;

	@FindBy(xpath = "//div[contains(@class,'standardization-body-fu2021')]//button[1]")
	WebElement keepanaddress;

	@FindBy(xpath = "//input[@id='user.emailAddress']")
	WebElement email1;

	@FindBy(xpath = "//input[@id='user.phone']")
	WebElement phno1;

	@FindBy(xpath = "//input[@id='text-updates']")
	WebElement textbox;

	@FindBy(xpath = "//button[@class='btn btn-lg btn-block btn-secondary']")
	WebElement ctn;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void fillOutForm(String firstname, String lastname, String address, String city, String pincode) {

		gotocart.click();
		checkoutbutton.click();
		continueasguest.click();
		firstname1.sendKeys(firstname);
		lastname1.sendKeys(lastname);
		address1.sendKeys(address);
		city1.sendKeys(city);
		state1.click();
		value1.click();
		pincodeInput.sendKeys(pincode);
		apply.click();
		keepanaddress.click();

	}

	public void scheduledelivery(String email, String phno) {
		email1.sendKeys(email);
		phno1.sendKeys(phno);
		textbox.click();
		;
		ctn.click();
	}

}
