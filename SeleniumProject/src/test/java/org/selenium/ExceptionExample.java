package org.selenium;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExceptionExample {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sobiyaranis\\eclipse-workspace\\CucumberMavenProject\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://adactinhotelapp.com/HotelAppBuild2/");
		try {
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Sofiya21396");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sofiya!2020");
			
			driver.findElement(By.xpath("//input[@id='login']")).click();

			try {
				driver.switchTo().alert().sendKeys("Text");

			} catch (NoAlertPresentException e) {
				System.out.println(e.getMessage());

			}

		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		Select location = new Select(driver.findElement(By.cssSelector("select#location")));
		location.selectByIndex(2);
		Thread.sleep(1000);

		try {
			driver.switchTo().frame("a077aa5e");

		} catch (NoSuchFrameException e) {
			System.out.println(e.getMessage());
		}
		try {
			driver.findElement(By.cssSelector("input#Submit")).click();
			String par = driver.getWindowHandle();
			Set<String> childID = driver.getWindowHandles();
			for (String x : childID) {
				if (!par.equals(childID)) {
					driver.switchTo().window(x).getTitle();
					driver.close();
				}
			}
		} catch (NoSuchWindowException e) {
			System.out.println(e.getMessage());
		}

	}

}
