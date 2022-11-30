package saucelabs;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Loginpage {
	public WebDriver driver;
	
	@BeforeMethod
	public void open() throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver","C:\\Users\\lebi01\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		Thread.sleep(3000);
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}
	
	@Test
	public void TC_001() throws InterruptedException {
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(3000);
	}
	
	@Test
	public void TC_002() throws InterruptedException {
		driver.get("https://www.saucedemo.com/");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login_logo']")).getCssValue("text-align"),"center");
		Thread.sleep(3000);
	}
}
