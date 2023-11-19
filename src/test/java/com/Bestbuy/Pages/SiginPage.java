package com.Bestbuy.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SiginPage {

	WebDriver driver;

	@FindBy(xpath = "//button[@id='account-menu-account-button']")
	WebElement signin1;

	@FindBy(xpath = "//a[normalize-space()='Sign In']")
	WebElement signininto;

	@FindBy(xpath = "//input[@id='fld-e']")
	WebElement usernameInput;

	@FindBy(xpath = "//input[@id='fld-p1']")
	WebElement passwordInput;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signUpButton;

	@FindBy(xpath = "//a[normalize-space()='Return to previous page']")
	WebElement topage;

	public SiginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void signUp(String username, String password) {
		signin1.click();
		signininto.click();
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		signUpButton.click();
		driver.switchTo().frame("tmx_tags_iframe");
		topage.click();
	}
}
