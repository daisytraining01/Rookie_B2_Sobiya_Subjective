package org.selenium;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitExample {
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sobiyaranis\\eclipse-workspace\\CucumberMavenProject\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("http://adactinhotelapp.com/HotelAppBuild2/");
		
		WebDriverWait wait=new WebDriverWait(driver, 20);

		
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("Sofiya21396");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sofiya!2020");
		WebElement button = driver.findElement(By.xpath("//input[@id='login']"));
		wait.until(ExpectedConditions.elementToBeClickable(button)).click();
		
		Wait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver)							
				.withTimeout(30, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);
		
		WebElement password = fluentwait.until(new Function<WebDriver, WebElement>() 
		{
		    public WebElement apply(WebDriver driver) {
		    return driver.findElement(By.xpath("//input[@id='password']"));
		}
		}
		);
				

}	

}
