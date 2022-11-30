package saucelabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Yourcart {
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
		Thread.sleep(2000);
	}
	@AfterMethod																								//Final Steps
	public void close() {
		driver.quit();
	}
	
	@Test
	public void TC_032() {
		driver.findElement(By.xpath("//div[@class='cart_quantity']")).isSelected();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='cart_quantity']")).isSelected(), true);	//checking the box selected or not
	}
	
	@Test
	public void TC_033() {
		driver.findElement(By.id("continue-shopping")).click();													
		driver.getCurrentUrl();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");				//Checking the page navigated
	}
	
	@Test
	public void TC_034() {
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();										//Check the product present or not
		try {
			driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
		}catch (Exception error) {
			error.getCause();
			Assert.assertNull(error.getCause());																//catch the null exception and validate
		}
	}
	@Test
	public void TC_035() {
		driver.findElement(By.id("checkout")).click();															//Checkout page
		driver.getCurrentUrl();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
	}
	@Test
	public void TC_036() {
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();										//Without product page checkout	
		driver.findElement(By.id("checkout")).click();
		driver.getCurrentUrl();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");						//Check the page changed or not
	}
	
}
