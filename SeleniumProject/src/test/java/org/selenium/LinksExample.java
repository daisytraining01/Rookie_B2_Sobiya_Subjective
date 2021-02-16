package org.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LinksExample {
	
	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sobiyaranis\\eclipse-workspace\\CucumberMavenProject\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://wordpress.com/?aff=58022&cid=8348279");

		Actions acc = new Actions(driver);
		WebElement product = driver.findElement(By.xpath("//button[@data-dropdown-trigger='products']"));
		acc.moveToElement(product).perform();

		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int size = allLinks.size();
		System.out.println(size);
		 for(WebElement link:allLinks){
		 System.out.println(link.getText() + " - " + link.getAttribute("href"));
		 }
		


}}
