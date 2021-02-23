package org.newtour;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FindLinksTest {
	static WebDriver driver;


	@Before
	public void setUp() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sobiyaranis\\eclipse-workspace\\CucumberMavenProject\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		System.out.println("Browser launched successfully");
		driver.get("https://maveric-systems.com/");
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

	}
	@Test
	public void test1() {
		
		 List<WebElement> data = driver.findElements(By.tagName("a"));
		 for (int i = 0; i < data.size(); i++) {
			String attribute = data.get(i).getAttribute("href");
			
			System.out.println(attribute);
		}
		 
	}
	 @After 
	 public void cleanUp() {
		 driver.quit();
	 }

	}
	


