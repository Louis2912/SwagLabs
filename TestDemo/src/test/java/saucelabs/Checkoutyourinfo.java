package saucelabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Checkoutyourinfo {
	public WebDriver driver;																					//Startup steps						
	@BeforeMethod
	public void open() throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver","C:\\Users\\lebi01\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("shopping_cart_container")).click();
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(2000);
	}
	@AfterMethod																								//Final Steps
	public void close() {
		driver.quit();
	}
	@Test
	public void TC_037() {																					
		driver.findElement(By.id("first-name")).sendKeys("Louis");												
		driver.findElement(By.id("last-name")).sendKeys("Ebi");
		driver.findElement(By.id("postal-code")).sendKeys("600001");
		driver.findElement(By.id("continue")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");	
	}
	@Test
	public void TC_038() {
		driver.findElement(By.id("last-name")).sendKeys("Ebi");
		driver.findElement(By.id("postal-code")).sendKeys("600001");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.xpath("//h3")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Error: First Name is required");
	}
	@Test
	public void TC_039() {
		driver.findElement(By.id("first-name")).sendKeys("Louis");
		driver.findElement(By.id("postal-code")).sendKeys("600001");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.xpath("//h3")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Error: Last Name is required");
	}
	@Test
	public void TC_040() {
		driver.findElement(By.id("first-name")).sendKeys("Louis");
		driver.findElement(By.id("last-name")).sendKeys("Ebi");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.xpath("//h3")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Error: Postal Code is required");
	}
	@Test
	public void TC_041() {
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.xpath("//h3")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Error: First Name is required");
	}
	@Test
	public void TC_42() throws InterruptedException {
		driver.findElement(By.id("first-name")).sendKeys("Louis123");
		driver.findElement(By.id("last-name")).sendKeys("Ebi");
		driver.findElement(By.id("postal-code")).sendKeys("600001");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
	}	
	@Test
	public void TC_43() throws InterruptedException {
		driver.findElement(By.id("first-name")).sendKeys("Louis");
		driver.findElement(By.id("last-name")).sendKeys("Ebi123");
		driver.findElement(By.id("postal-code")).sendKeys("600001");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
	}
	@Test
	public void TC_44() throws InterruptedException {
		driver.findElement(By.id("first-name")).sendKeys("Louis");
		driver.findElement(By.id("last-name")).sendKeys("Ebi");
		driver.findElement(By.id("postal-code")).sendKeys("chennai");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
	}
	@Test
	public void TC_45() throws InterruptedException {
		driver.findElement(By.id("first-name")).sendKeys("Louis");
		driver.findElement(By.id("last-name")).sendKeys("Ebi");
		driver.findElement(By.id("postal-code")).sendKeys("60000111");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
	}
	@Test
	public void TC_46() {
		driver.findElement(By.id("cancel")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
	}
	
	
}
