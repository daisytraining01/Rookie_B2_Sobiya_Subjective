package org.newtour;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableTest {
	static WebDriver driver;

	@Before
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sobiyaranis\\eclipse-workspace\\CucumberMavenProject\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
	}

	@Test
	public void test1() {

		List<WebElement> tRow = driver.findElements(By.tagName("tr"));

		for (int i = 0; i < tRow.size(); i++) {
			WebElement row = tRow.get(i);

			List<WebElement> tData = row.findElements(By.tagName("td"));

			for (int j = 0; j < tData.size(); j++) {

				WebElement data = tData.get(j);
				String text = data.getText();
				System.out.println(text);

			}

		}

	}
	@After
	public void cleanUp() {
		driver.quit();
	}

}
