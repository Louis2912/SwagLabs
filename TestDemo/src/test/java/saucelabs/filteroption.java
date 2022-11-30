package saucelabs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class filteroption {
	public WebDriver driver;																					
	String productorderAZ[] = {"Sauce Labs Backpack",										//Product name on A-Z order
							   "Sauce Labs Bike Light",
							   "Sauce Labs Bolt T-Shirt",
							   "Sauce Labs Fleece Jacket",
							   "Sauce Labs Onesie",
							   "Test.allTheThings() T-Shirt (Red)"};
	int a=0;
	
	String productorderZA[] = {"Test.allTheThings() T-Shirt (Red)",							//Product name on Z-A order
							   "Sauce Labs Onesie",
							   "Sauce Labs Fleece Jacket",
							   "Sauce Labs Bolt T-Shirt",
							   "Sauce Labs Bike Light",
							   "Sauce Labs Backpack"};
	int b=0;
	
	String productorderLH[] = {"Sauce Labs Onesie",											//Product name on L-H order
							   "Sauce Labs Bike Light",
							   "Sauce Labs Bolt T-Shirt",
							   "Test.allTheThings() T-Shirt (Red)",
							   "Sauce Labs Backpack",
							   "Sauce Labs Fleece Jacket"};
	int c=0;
	
	String productorderHL[] = {"Sauce Labs Fleece Jacket",									//Product name on H-L order
							   "Sauce Labs Backpack",
							   "Sauce Labs Bolt T-Shirt",
							   "Test.allTheThings() T-Shirt (Red)",
							   "Sauce Labs Bike Light",
							   "Sauce Labs Onesie"};
	int d=0;

	@BeforeMethod
	public void open() throws InterruptedException {																		//Startup steps
		System.setProperty("Webdriver.chrome.driver","C:\\Users\\lebi01\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
	}
	@AfterMethod																									    //Final Steps
	public void close() {
		driver.quit();
	}
	@Test 
	public void TC_019() throws InterruptedException{																	
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		driver.findElement(By.xpath("//option[@value='az']")).click();													//Clicking the A-Z Filter option
		Thread.sleep(2000);
		List<WebElement> currentnameorder = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		for(WebElement order: currentnameorder) {
			order.getText();
			Assert.assertEquals(order.getText(),productorderAZ[a]);														//Comparing the order of the products
			a++;
		}		
	}
	@Test
	public void TC_020() throws InterruptedException{
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		driver.findElement(By.xpath("//option[@value='za']")).click();													//Clicking the Z-A Filter option
		Thread.sleep(2000);
		List<WebElement> currentnameorder = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		for(WebElement order: currentnameorder) {
			order.getText();
			Assert.assertEquals(order.getText(),productorderZA[b]);														//Comparing the order of the products
			b++;
		}		
	}
	@Test
	public void TC_021() throws InterruptedException{
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		driver.findElement(By.xpath("//option[@value='lohi']")).click();												//Clicking the L-H Filter option
		Thread.sleep(2000);
		List<WebElement> currentnameorder = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		for(WebElement order: currentnameorder) {
			order.getText();
			Assert.assertEquals(order.getText(),productorderLH[c]);														//Comparing the order of the products
			c++;
		}		
	}
	@Test
	public void TC_022() throws InterruptedException{
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		driver.findElement(By.xpath("//option[@value='hilo']")).click();												//Clicking the H-L Filter option
		Thread.sleep(2000);
		List<WebElement> currentnameorder = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		for(WebElement order: currentnameorder) {
			order.getText();
			Assert.assertEquals(order.getText(),productorderHL[d]);														//Comparing the order of the products
			d++;
		}		
	}
	@Test
	public void TC_023() throws InterruptedException{
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		driver.findElement(By.xpath("//option[@value='za']")).click();													//Clicking the Z-A Filter option
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']")).click();										//Clicking on product
		driver.findElement(By.id("back-to-products")).click();															//Back to product page
		List<WebElement> currentnameorder = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		for(WebElement order: currentnameorder) {
			order.getText();
			Assert.assertEquals(order.getText(),productorderZA[b]);														//Comparing the order of the products
			b++;
		}
	}
}
