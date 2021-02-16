package org.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumPractise {
	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sobiyaranis\\eclipse-workspace\\CucumberMavenProject\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Sofiya");
		String fname = driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value");
		System.out.println(fname);

		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Selvaraj");
		String lname = driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value");
		System.out.println(lname);

		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1234567812");
		String phone = driver.findElement(By.xpath("//input[@name='phone']")).getAttribute("value");
		System.out.println(phone);

		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("someone@gmail.com");
		String email = driver.findElement(By.xpath("//input[@id='userName']")).getAttribute("value");
		System.out.println(email);

		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("abc street");
		String address = driver.findElement(By.xpath("//input[@name='address1']")).getAttribute("value");
		System.out.println(address);

		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Chennai");
		String city = driver.findElement(By.xpath("//input[@name='city']")).getAttribute("value");
		System.out.println(city);

		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Tamilnadu");
		String state = driver.findElement(By.xpath("//input[@name='state']")).getAttribute("value");
		System.out.println(state);

		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("0001219");
		String postcode = driver.findElement(By.xpath("//input[@name='postalCode']")).getAttribute("value");
		System.out.println(postcode);

		Select country = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		country.selectByVisibleText("AUSTRALIA");
		boolean multiple = country.isMultiple();
		System.out.println("Is Country multi select Dropdown :" + multiple);
		WebElement selectedOption = country.getFirstSelectedOption();
		System.out.println(selectedOption.getText());

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("someone@gmail.com");
		String username = driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value");
		System.out.println(username);

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Sofiya20");
		String password = driver.findElement(By.xpath("//input[@name='password']")).getAttribute("value");
		System.out.println(password);

		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("Sofiya201");
		String confirmpassword = driver.findElement(By.xpath("//input[@name='confirmPassword']")).getAttribute("value");
		System.out.println(confirmpassword);

		// negative scenario
		try {

			Assert.assertTrue(password.equals(confirmpassword));
			System.out.println("Passwords Matched");

			driver.findElement(By.xpath("//input[@name='submit']")).click();
			Thread.sleep(1000);
			captureScreen(driver, "Password_matched");
			try {
				String title = driver.getTitle();
				String expected = "Register: Mercury Tours";
				Assert.assertEquals(expected, title);
				captureScreen(driver, "Page_navigated");

				System.out.println("Page navigated successfuly");
			} catch (Throwable e) {
				captureScreen(driver, "Page_not_navigated");
				System.out.println("Page not navigated successfully");
			}

		} catch (Throwable e) {
			driver.findElement(By.xpath("//input[@name='submit']")).click();
			System.out.println("Given passwords doesn't match");
			Thread.sleep(2000);
			captureScreen(driver, "Password_mismatch");

		}

	}

	public static String captureScreen(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = new File("./reports/") + screenshotName + " .png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}


}
