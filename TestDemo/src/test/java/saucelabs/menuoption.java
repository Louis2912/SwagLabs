package saucelabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class menuoption {
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
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
	}
	@AfterMethod																									  //Final Steps
	public void close() {
		driver.quit();
	}
	@Test
	public void TC_024() {
		driver.findElement(By.id("inventory_sidebar_link")).click();												  //All items menu
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");					  //Checking redirected or not
	}
	@Test
	public void TC_025() {																	
		driver.findElement(By.id("about_sidebar_link")).click();													  //About menu
		Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");										  //Checking redirected or not
	}
	@Test
	public void TC_026() {
		driver.findElement(By.id("logout_sidebar_link")).click();													  //Logout menu
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");									  //Checking redirected or not
	}
	@Test
	public void TC_027() {
		driver.findElement(By.id("reset_sidebar_link")).click();													  //Reset menu
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");					  //Checking redirected or not
	} 
	@Test
	public void TC_028() throws InterruptedException {																 
		driver.findElement(By.id("logout_sidebar_link")).click();													 //logout Function
		driver.navigate().back();
		Thread.sleep(2000);
		String errormsg = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");									  //Checking redirected or not
		Assert.assertEquals(errormsg, "Epic sadface: You can only access '/inventory.html' when you are logged in."); //Checking the Error shown or not	
	}

}
