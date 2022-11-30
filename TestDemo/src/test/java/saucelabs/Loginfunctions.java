package saucelabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Loginfunctions {
	public WebDriver driver;
	@BeforeMethod
	public void open() throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver","C:\\Users\\lebi01\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(2000);
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}
	
	@Test
	public void TC_003() throws InterruptedException {
		driver.findElement(By.id("user-name")).sendKeys("standard_user200");
		driver.findElement(By.id("password")).sendKeys("secret_sauce123");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.xpath("//h3")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Epic sadface: Username and password do not match any user in this service");
	}
	@Test
	public void TC_004() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user200");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();	
		driver.findElement(By.xpath("//h3")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Epic sadface: Username and password do not match any user in this service");
	}
	@Test
	public void TC_005() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce123");
		driver.findElement(By.id("login-button")).click();	
		driver.findElement(By.xpath("//h3")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Epic sadface: Username and password do not match any user in this service");
	}
		
	@Test
	public void TC_006() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.id("login-button")).click();	
		driver.findElement(By.xpath("//h3")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Epic sadface: Password is required");
		
	}
	@Test
	public void TC_007() {
		driver.findElement(By.id("user-name")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();	
		driver.findElement(By.xpath("//h3")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Epic sadface: Username is required");
		
	}
	@Test
	public void TC_008() {
		driver.findElement(By.id("user-name")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.id("login-button")).click();	
		driver.findElement(By.xpath("//h3")).getText();
		Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Epic sadface: Username is required");
		
	}
	@Test
	public void TC_009() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}
}
		
	
		
		

	
