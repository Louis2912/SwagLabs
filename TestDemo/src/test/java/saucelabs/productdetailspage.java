package saucelabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class productdetailspage {
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
		driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
		Thread.sleep(2000);
	}
	@AfterMethod																									//Final Steps
	public void close() {
		driver.quit();
	}
	
	@Test
	public void TC_016() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=4");			//Fetched the current URL and compared with the expected URL. 																										
	}
	@Test
	public void TC_017() {
		driver.findElement(By.id("back-to-products")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");                     //Fetched the current URL and compared with the expected URL. 																										
	}
	@Test
	public void TC_018() throws InterruptedException {
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		String nameondetailspage = driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText();	//Fetching the product name on product details page and storing
		Thread.sleep(2000);
		driver.findElement(By.id("shopping_cart_container")).click();
		String nameonyourscart= driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();		//Fetching the product name on yourscart page
		Assert.assertEquals(nameonyourscart,nameondetailspage);                                                     //comparing the both names from different pages 																										
	}
	

}
