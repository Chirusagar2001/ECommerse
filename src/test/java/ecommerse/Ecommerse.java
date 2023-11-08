package ecommerse;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ecommerse {
	public WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@Test(priority = 1)
	public void linkisbroken() throws Exception {

		driver.get("https://www.bestbuy.com/");

		WebElement selectNation = driver.findElement(By.xpath("//div[@lang='en']//img[@alt='United States']"));
		selectNation.click();

		// 1: Open the connection
		HttpURLConnection httpcon = (HttpURLConnection) new URL("https://www.bestbuy.com/").openConnection();

		// 2: Establish the connection
		httpcon.connect();

		// 3: Validating links

		int rescode = httpcon.getResponseCode();

		if (rescode >= 400) {

			System.out.println("URL is broken");

		}

		else {

			System.out.println("URL is not broken");
		}
	}

	
	  @Test(priority = 2) 
	  public void launchApplication() { 
	  driver.get("https://www.bestbuy.com/"); 
	  //driver.findElement(By.xpath("//div[@lang='en']//img[@alt='United States']"));
	  // selectNation1.click(); 
	  Assert.assertEquals("Best Buy | Official Online Store | Shop Now & Save",driver.getTitle()); }
	  
	  @Test(priority = 3) 
	  public void signupandlogin() throws Exception { 
	  driver.get("https://www.bestbuy.com/"); Thread.sleep(3000);
	  
	  WebElement signin =
	  driver.findElement(By.xpath("//button[@id='account-menu-account-button']"));
	  signin.click();
	  
	  WebElement signinto =
	  driver.findElement(By.xpath("//a[normalize-space()='Sign In']"));
	  signinto.click();
	  
	  WebElement emailid = driver.findElement(By.xpath(" //input[@id='fld-e']"));
	  emailid.sendKeys("some2008@gmail.com");
	  
	  WebElement emailpass = driver.findElement(By.xpath("//input[@id='fld-p1']"));
	  emailpass.sendKeys("Some@2004_Chiru");
	  
	  WebElement signbutton =
	  driver.findElement(By.xpath("//button[@type='submit']")); signbutton.click();
	  }
	  
	  
	  @Test(priority = 4) 
	  public void navigationofallMenu() throws Exception {
	  
	  driver.get("https://www.bestbuy.com/"); 
	  // WebElement selectNation = //
	  //driver.findElement(By.xpath("//div[@lang='en']//img[@alt='United States']") ); // selectNation.click();
	  
	  WebElement menu = driver.findElement(By.linkText("Top Deals")); menu.click();
	  
	  String pageTitle = driver.getTitle(); Assert.assertEquals(pageTitle,
	  "Top Deals and Featured Offers on Electronics - Best Buy");
	  
	  WebElement menu2 = driver.findElement(By.linkText("Deal of the Day"));
	  menu2.click();
	  
	  String pageTitle2 = driver.getTitle(); Assert.assertEquals(pageTitle2,
	  "Deal of the Day: Electronics Deals - Best Buy");
	  
	  WebElement menu3 =
	  driver.findElement(By.linkText("My Best Buy Memberships")); menu3.click();
	  
	  String pageTitle3 = driver.getTitle(); Assert.assertEquals(pageTitle3,
	  "My Best Buy Memberships");
	  
	  WebElement menu4 = driver.findElement(By.linkText("Credit Cards"));
	  menu4.click();
	  
	  String pageTitle4 = driver.getTitle(); Assert.assertEquals(pageTitle4,
	  "Best Buy Credit Card: Rewards & Financing");
	  
	  WebElement menu5 = driver.findElement(By.linkText("Black Friday Deals"));
	  menu5.click();
	  
	  String pageTitle5 = driver.getTitle(); Assert.assertEquals(pageTitle5,
	  "Best Buy Black Friday 2023 Deals");
	  
	  }
	  
	  
	  @Test(priority = 5) 
	  public void validatethebottomlink() throws Exception {
	  
	  Thread.sleep(3000);
	  
	  WebElement bottomlink = driver.findElement(By.linkText("Accessibility"));
	  bottomlink.click();
	  
	  String bottompageTitle = driver.getTitle();
	  Assert.assertEquals(bottompageTitle, "Accessibility - Best Buy");
	  
	  }
	 
	@Test(priority = 6)
	public void searchfor() throws Exception {

		WebElement search = driver.findElement(By.xpath("//input[@id='gh-search-input']"));
		search.sendKeys("smart watch for samsung");

		WebElement searchButton = driver.findElement(By.xpath("//span[@class='header-search-icon']//*[name()='svg']"));
		searchButton.click();

		WebElement addToCartButton = driver.findElement(By.xpath("(//button[@data-button-state='ADD_TO_CART'])[1]"));
		addToCartButton.click();
		//Thread.sleep(5000);
		//WebElement goaddToCart1 = driver.findElement(By.xpath("//a[normalize-space()='Go to Cart']"));
		//goaddToCart1.click(); 

	}
	
	  @Test(priority = 7) 
	  public void shopbyDepartment() throws Exception {
	  
	  WebElement shopByDepartmentMenu =
	  driver.findElement(By.xpath("//button[@aria-label='Menu']//*[name()='svg']"))
	  ; shopByDepartmentMenu.click();
	  
	  
	  WebElement computers = driver.findElement(By.
	  xpath("//button[normalize-space()='Computers & Tablets']"));
	  computers.click();
	  
	  WebElement laptops = driver.findElement(By.
	  xpath("//button[normalize-space()='Laptops & Desktops']")); laptops.click();
	  
	  WebElement exactlaptop =
	  driver.findElement(By.xpath("//a[normalize-space()='Laptops']"));
	  exactlaptop.click();
	  
	  WebElement alllaptop =
	  driver.findElement(By.xpath("//a[normalize-space()='All Laptops']"));
	  alllaptop.click();
	  
	  WebElement addToCartInDepartment = driver
	  .findElement(By.xpath("(//button[@data-button-state='ADD_TO_CART'])[1]"));
	  addToCartInDepartment.click();
	  
	 // WebElement goaddToCart2 =driver.findElement(By.xpath("//div[@class='go-to-cart-button']"));
	 // goaddToCart2.click();
	  
	  // WebElement nothanks = driver.findElement(By. // xpath("//button[@class='c-button c-button-outline c-button-lg btn-secondary
	  // my-bby-total-footer__no-thanks']"));
	  
	  }
	  
	  @Test(priority = 8) 
	  public void selectAnyBrand() throws Exception {
	  
	  Thread.sleep(7000);
	  
	  WebElement shopByDepartmentMenu =
	  driver.findElement(By.xpath("//button[@aria-label='Menu']//*[name()='svg']"))
	  ; shopByDepartmentMenu.click();
	  
	  Thread.sleep(7000);
	  
	  WebElement brand =
	  driver.findElement(By.xpath("//button[normalize-space()='Brands']"));
	  brand.click();
	  
	  WebElement samsung =
	  driver.findElement(By.xpath("//a[@data-lid='ubr_shp_see']"));
	  samsung.click();
	  
	  WebElement shopnow1 = driver.findElement(By.xpath(
	  "//div[@class='mt-500 v-text-tech-black']//a[@class='btn btn-secondary'][normalize-space()='Shop now']"
	  )); shopnow1.click();
	  
	  Thread.sleep(4500);
	  
	  WebElement addtocartbrand =
	  driver.findElement(By.xpath("(//button[@data-button-state='ADD_TO_CART'])[1]"
	  )); addtocartbrand.click();
	  
	  Thread.sleep(4500); WebElement closepopup =
	  driver.findElement(By.xpath("//a[normalize-space()='Go to Cart']"));
	  closepopup.click();
	  
	  }
	  
	  @Test(priority = 9) 
	  public void checkout() throws Exception {
	  
	  Thread.sleep(4500); WebElement checkout =
	  driver.findElement(By.xpath("//button[normalize-space()='Checkout']"));
	  checkout.click();
	  
	  WebElement continueasguest = driver.findElement(By
	  .xpath("//button[@class='c-button c-button-secondary c-button-lg cia-guest-content__continue guest']"
	  )); continueasguest.click();
	  
	  Thread.sleep(6000); WebElement firstname =
	  driver.findElement(By.xpath("//input[@id='firstName']"));
	  firstname.sendKeys("some");
	  
	  WebElement lastname =
	  driver.findElement(By.xpath("//input[@id='lastName']"));
	  lastname.sendKeys("chiru");
	  
	  WebElement address = driver.findElement(By.xpath("//input[@id='street']"));
	  address.sendKeys("rajajinagar");
	  
	  WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
	  city.sendKeys("banglore");
	  
	  WebElement click = driver.findElement(By.xpath("//select[@id='state']"));
	  click.click();
	  
	  WebElement click1 = driver.findElement(By.xpath("//option[@value='AA']"));
	  click1.click();
	  
	  WebElement zipcode = driver.findElement(By.xpath("//input[@id='zipcode']"));
	  zipcode.sendKeys("560091");
	  
	  WebElement apply = driver.findElement( By.
	  xpath("//button[@class='c-button c-button-secondary c-button-md new-address-form__button']"
	  )); apply.click();
	  
	  WebElement keepanaddress = driver .findElement(By.xpath(
	  "//div[contains(@class,'standardization-body-fu2021')]//button[1]"));
	  keepanaddress.click();
	  
	  WebElement emailid1 =
	  driver.findElement(By.xpath("//input[@id='user.emailAddress']"));
	  emailid1.sendKeys("some2001@gmail.com");
	  
	  WebElement phonenumber =
	  driver.findElement(By.xpath("//input[@id='user.phone']"));
	  phonenumber.sendKeys("7353888398");
	  
	  WebElement textupdate =
	  driver.findElement(By.xpath("//input[@id='text-updates']"));
	  textupdate.click();
	  
	  WebElement payment = driver.findElement(By.
	  xpath("//button[@class='btn btn-lg btn-block btn-secondary']"));
	  payment.click();
	  
	  }
	  
	  @Test(priority = 10) 
	  public void orderwasplaced() throws Exception {
	  
	  WebElement creditcardnumber =
	  driver.findElement(By.xpath("//input[@id='number']"));
	  creditcardnumber.sendKeys("7363562467249834");
	  
	  WebElement placeyourorder = driver.findElement(By.
	  xpath("//button[@class='btn btn-lg btn-block btn-primary']"));
	  placeyourorder.click();
	  
	  WebElement confirmationMessage =
	  driver.findElement(By.cssSelector("div.order-confirmation")); String message
	  = confirmationMessage.getText();
	  
	  if (message.contains("Order placed successfully")) {
	  System.out.println("Order placed successfully!"); } else {
	  System.out.println("Order placement failed."); }
	  
	  }

}
