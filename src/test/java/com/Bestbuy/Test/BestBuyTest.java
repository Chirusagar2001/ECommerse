package com.Bestbuy.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Bestbuy.Pages.BottomLinksValidationPage;
import com.Bestbuy.Pages.CheckoutPage;
import com.Bestbuy.Pages.HomePage;
import com.Bestbuy.Pages.MenuNavigationPage;
import com.Bestbuy.Pages.PaymentPage;
import com.Bestbuy.Pages.ShoppingCartPage;
import com.Bestbuy.Pages.SiginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BestBuyTest {

	WebDriver driver;
	HomePage homePage;
	CheckoutPage checkoutPage;
	SiginPage signin;
	BottomLinksValidationPage bottomlink;
	MenuNavigationPage menunavigation;
	ShoppingCartPage shoppingcart;
	CheckoutPage checkout;
	PaymentPage placeorder;

	@BeforeClass
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();

		// Initialize FirefoxDriver
		driver = new FirefoxDriver();
		
		homePage = new HomePage(driver);
		signin = new SiginPage(driver);
		bottomlink = new BottomLinksValidationPage(driver);
		menunavigation = new MenuNavigationPage(driver);
		shoppingcart = new ShoppingCartPage(driver);
		checkoutPage = new CheckoutPage(driver);
		placeorder = new PaymentPage(driver);

		// Maximize the browser window
		driver.manage().window().maximize();

		// Initialize WebDriverWait with a timeout of 30 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test(priority = 1)
	public void openHomePage() {

		homePage.openHomePage("https://www.bestbuy.com/");

	}

	@Test(priority = 2)
	public void signUp() {
		signin.signUp("some2008@gmail.com", "Some@2004_Chiru");

	}

	@Test(priority = 3)
	public void navigateToAllMenuAndValidateTitle() {

		menunavigation.navigateToMenu1();

		// Add validation logic for the title ofthe page
		assert driver.getTitle().contains("Deal of the Day: Electronics Deals - Best Buy")
				: "Title validation failed for Deal of the day page.";

		menunavigation.navigateToMenu4();
		assert driver.getTitle().contains("Best Buy Credit Card: Rewards & Financing")
				: "Title validation failed for page 4.";

		menunavigation.navigateToMenu2();
		assert driver.getTitle().contains("Best Buy Black Friday 2023 Deals") : "Title validation failed for page 2.";

		menunavigation.navigateToMenu3();
		assert driver.getTitle().contains("My Best Buy Memberships") : "Title validation failed for page 3.";

	}

	@Test(priority = 4)
	public void validateLink1() {
		bottomlink.navigateToBottomlink();

		// bottomlinkvalidation logic for the title of the page
		assert driver.getTitle().contains("Accessibility - Best Buy") : "BottomTitle validation failed.";
	}

	@Test(priority = 5)
	public void SearchItem() {

		shoppingcart.searchAndAddToCart("smart watch for samsung");
	}

	@Test(priority = 6)
	public void selectItemFromShopByDepartment() {

		shoppingcart.selectItemFromShopByDepartment();
	}

	@Test(priority = 7)
	public void selectItemFromBrands() {

		shoppingcart.selectItemFromBrands();
	}

	@Test(priority = 8)
	public void filloutchectoutpage() {
		checkoutPage.fillOutForm("some", " M k", "rajajinagar", "banglore", "560091");
		checkoutPage.scheduledelivery("some2001@gmail.com", "7865345243");
	}

	@Test(priority = 9)
	public void VerifyOrderPlacement() {

		placeorder.placeyourorder("7384 4682 6452 8653");

		// the invalid card details message is displayed on the same page
		assert placeorder.getInvalidCardDetailsMessage().contains("Invalid card details")
				: "Invalid card details message not displayed.";
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
