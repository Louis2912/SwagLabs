package saucelabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Completepage {
	public WebDriver driver;																						//Startup steps						
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
		driver.findElement(By.id("first-name")).sendKeys("Louis");												
		driver.findElement(By.id("last-name")).sendKeys("Ebi");
		driver.findElement(By.id("postal-code")).sendKeys("600001");
		Thread.sleep(2000);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
	}
	@AfterMethod																									//Final Steps
	public void close() {
		driver.quit();
	}
	@Test
	public void TC_048() {
		String finalmsg = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
		Assert.assertEquals(finalmsg, "THANK YOU FOR YOUR ORDER");
	}
	@Test
	public void TC_049() {
		driver.findElement(By.id("back-to-products")).click();
		driver.getCurrentUrl();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}
}
