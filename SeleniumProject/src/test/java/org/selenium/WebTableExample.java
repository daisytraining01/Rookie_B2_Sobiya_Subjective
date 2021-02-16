package org.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample {
	
	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sobiyaranis\\eclipse-workspace\\CucumberMavenProject\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/"); 
		
		List<WebElement> tRow = driver.findElements(By.tagName("tr"));
		
		for (int i = 0; i <tRow.size(); i++) {
			WebElement row = tRow.get(i);
			
			List<WebElement> tData = row.findElements(By.tagName("td"));
			
			for (int j = 0; j < tData.size(); j++) {
				
				WebElement data = tData.get(j);
				String text = data.getText();
				//System.out.println(text);
				
				
				if(text.equalsIgnoreCase("Australia")) {
					String text2 = tData.get(2).getText();
					System.out.println("Captial of Australia :"+text2);
					}
				if(text.equalsIgnoreCase("Belarus")) {
					tData.get(0).findElement(By.xpath("input[@class='hasVisited']")).click();
				System.out.println("Clicked the checkbox");	
				}
				
				
				
				}

				
				
			}
			
			
		
		
				}
				


}
