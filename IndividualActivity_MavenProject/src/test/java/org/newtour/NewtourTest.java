package org.newtour;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class NewtourTest {
	static WebDriver driver;

@Before
public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sobiyaranis\\eclipse-workspace\\CucumberMavenProject\\drivers\\chromedriver.exe");

		 driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/register.php");
}

@Test
public void test() throws Throwable {
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Sofiya");

		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Selvaraj");

		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1234567812");

		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("someone@gmail.com");

		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("abc street");

		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Chennai");


		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Tamilnadu");

		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("0001219");

		Select country = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		country.selectByVisibleText("AUSTRALIA");
		boolean multiple = country.isMultiple();
		System.out.println("Is Country multi select Dropdown :" + multiple);
		List<WebElement> options = country.getOptions();
		for (int i = 0; i < options.size(); i++) {
			String text = options.get(i).getText();
			System.out.println(text);
		}


		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("someone@gmail.com");

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Sofiya20");
		String password = driver.findElement(By.xpath("//input[@name='password']")).getAttribute("value");

		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("Sofiya20");
		String confirmpassword = driver.findElement(By.xpath("//input[@name='confirmPassword']")).getAttribute("value");

		// negative scenario
		try {

			Assert.assertTrue(password.equals(confirmpassword));
			System.out.println("Passwords Matched");

			driver.findElement(By.xpath("//input[@name='submit']")).click();
			Thread.sleep(1000);
			getScreenshot(driver, "Password_matched");
			try {
				String title = driver.getTitle();
				String expected = "Register: Mercury Tours";
				Assert.assertEquals(expected, title);
				getScreenshot(driver, "Page_navigated");

				System.out.println("Page navigated successfuly");
			} catch (Throwable e) {
				getScreenshot(driver, "Page_not_navigated");
				System.out.println("Page not navigated successfully");
			}

		} catch (Throwable e) {
			driver.findElement(By.xpath("//input[@name='submit']")).click();
			System.out.println("Given passwords doesn't match");
			Thread.sleep(2000);
			getScreenshot(driver, "Password_mismatch");

		}

	}

@After
public void cleanUp() {
	driver.quit();
}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = new File("reports/snap").getAbsolutePath() + "\\" + screenshotName + dateName + ".png";
		File finaldest = new File(dest);
		FileUtils.copyFile(source, finaldest);
		System.out.println("finalDestination" + finaldest);
		return dest;
	}


}

