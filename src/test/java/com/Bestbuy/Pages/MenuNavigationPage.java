package com.Bestbuy.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuNavigationPage {

	@FindBy(linkText = "Deal of the Day")
	WebElement menu1;

	@FindBy(linkText = "Black Friday Deals")
	WebElement menu2;

	@FindBy(linkText = "My Best Buy Memberships")
	WebElement menu3;

	@FindBy(linkText = "Credit Cards")
	WebElement menu4;

	public MenuNavigationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void navigateToMenu1() {
		menu1.click();
	}

	public void navigateToMenu4() {
		menu4.click();
	}

	public void navigateToMenu2() {
		menu2.click();
	}

	public void navigateToMenu3() {
		menu3.click();
	}

}
