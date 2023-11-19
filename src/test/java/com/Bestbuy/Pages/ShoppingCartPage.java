package com.Bestbuy.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	WebDriver driver;

	// search on searchinput

	@FindBy(xpath = "//input[@id='gh-search-input']")
	WebElement searchInput;

	@FindBy(xpath = "//span[@class='header-search-icon']//*[name()='svg']")
	WebElement searchButton;

	@FindBy(xpath = "(//button[@data-button-state='ADD_TO_CART'])[1]")
	WebElement addToCartButton;

	// shop by department

	@FindBy(xpath = "//button[@aria-label='Menu']//*[name()='svg']")
	WebElement shopByDepartmentMenu;

	@FindBy(xpath = "//button[normalize-space()='Computers & Tablets']")
	WebElement computers;

	@FindBy(xpath = "//button[normalize-space()='Laptops & Desktops']")
	WebElement laptops;

	@FindBy(xpath = "//a[normalize-space()='Laptops']")
	WebElement exactlaptop;

	@FindBy(xpath = "//a[normalize-space()='All Laptops']")
	WebElement allaptop;

	@FindBy(xpath = "(//button[@data-button-state='ADD_TO_CART'])[2]")
	WebElement addtocart1;

	// select item from Brand

	@FindBy(xpath = "//button[@aria-label='Menu']//*[name()='svg']")
	WebElement shopByDepartmentMenu1;

	@FindBy(xpath = "//button[normalize-space()='Brands']")
	WebElement brand;

	@FindBy(xpath = "//a[@data-lid='ubr_shp_see']")
	WebElement samsung;

	@FindBy(xpath = "//div[@class='mt-500 v-text-tech-black']//a[@class='btn btn-secondary'][normalize-space()='Shop now']")
	WebElement shopnow;

	@FindBy(xpath = "(//button[@data-button-state='ADD_TO_CART'])[1]")
	WebElement addtocartbrand;

	public ShoppingCartPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void searchAndAddToCart(String itemName) {

		searchInput.sendKeys(itemName);
		searchButton.click();
		addToCartButton.click();
	}

	public void selectItemFromShopByDepartment() {
		shopByDepartmentMenu.click();
		computers.click();
		laptops.click();
		exactlaptop.click();
		allaptop.click();
		addtocart1.click();

	}

	public void selectItemFromBrands() {
		shopByDepartmentMenu1.click();
		brand.click();
		samsung.click();
		shopnow.click();
		addtocartbrand.click();
	}
}
