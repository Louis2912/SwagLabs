package saucelabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Overviewpage {
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
		Thread.sleep(2000);
	}
	@AfterMethod																									//Final Steps
	public void close() {
		driver.quit();
	}
	@Test
	public void TC_047() throws InterruptedException {
		String beforeqty= driver.findElement(By.xpath("//div[text()='1']")).getText();								//Fetching and saving the product details on cart page
		String beforename= driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
		String beforedescription= driver.findElement(By.xpath("//div[@class='inventory_item_desc']")).getText(); 
		String beforeprice= driver.findElement(By.xpath("//div[text()='29.99']")).getText();
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Louis");												
		driver.findElement(By.id("last-name")).sendKeys("Ebi");
		driver.findElement(By.id("postal-code")).sendKeys("600001");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);
		String afterqty= driver.findElement(By.xpath("//div[@class='cart_quantity']")).getText();
		String aftername= driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		String afterdescription= driver.findElement(By.xpath("//div[@class='inventory_item_desc']")).getText();
		String afterprice= driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
		Assert.assertEquals(afterqty, beforeqty);																	//Fetching and saving the product details on overview page
		Assert.assertEquals(aftername, beforename);
		Assert.assertEquals(afterdescription, beforedescription);
		Assert.assertEquals(afterprice, beforeprice);	
		
	}
	

}
