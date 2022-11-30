package saucelabs;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Socialmedia {
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
			Thread.sleep(2000);
		}
		@AfterMethod																								//Final Steps
		public void close() {
			driver.quit();
		}
		
		@Test
		public void TC_029() throws InterruptedException {															//Twitter
			String homehandle =driver.getWindowHandle();
			driver.findElement(By.xpath("//a[text()='Twitter']")).click();												
			Thread.sleep(3000);
			Set<String> handles= driver.getWindowHandles();
			for (String handle: handles) {
				if(!handle.equalsIgnoreCase(homehandle)) {
					driver.switchTo().window(handle);
					driver.getCurrentUrl();
					Assert.assertEquals(driver.getCurrentUrl(),"https://twitter.com/saucelabs");					//checking page opened or not
				}			
			}			
		}
		@Test
		public void TC_030() throws InterruptedException {															//Facebook
			String homehandle =driver.getWindowHandle();
			driver.findElement(By.xpath("//a[text()='Facebook']")).click();
			Thread.sleep(3000);
			Set<String> handles= driver.getWindowHandles();
			for (String handle: handles) {
				if(!handle.equalsIgnoreCase(homehandle)) {
					driver.switchTo().window(handle);
					driver.getCurrentUrl();
					Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/saucelabs");				//checking page opened or not
				}				
			}			
		}
		@Test
		public void TC_031() throws InterruptedException {															//LinkdIn
			String homehandle =driver.getWindowHandle();
			driver.findElement(By.xpath("//a[text()='LinkedIn']")).click();
			Thread.sleep(3000);
			Set<String> handles= driver.getWindowHandles();
			for (String handle: handles) {
				if(!handle.equalsIgnoreCase(homehandle)) {
					driver.switchTo().window(handle);
					Assert.assertEquals(driver.getTitle(),"Sign In | LinkedIn");									//checking page opened or not
				}		
			}			
		}
}
