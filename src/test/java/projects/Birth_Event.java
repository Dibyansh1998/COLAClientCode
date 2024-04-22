package projects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Birth_Event {

	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {
		Launch_COLA_Site();
		LogIn_Page();
		Authorization_Page();
		Accept_Cookies();
		Tire_Down();

	}

	// Below Command to use to Launch the Browser and Open your Client Site
	@BeforeTest
	public static void Launch_COLA_Site() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// Below Command to put the URL:
		driver.get("https://pp.lifeatworkportal.com/countyofla");
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// Below Command to use to put your UserName and Password and then click LogIn-Button
	@Test
	public static void LogIn_Page() throws InterruptedException {

		// Log in page Commands:
		driver.findElement(By.id("USERNAME")).sendKeys("911317101");
		driver.findElement(By.id("password")).sendKeys("Test@1234");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showhide")));
		driver.findElement(By.id("showhide")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ContinueBtn")).click();
	}

	//This Code will be execute to check the Authorization page
	@Test
	public static void Authorization_Page() throws InterruptedException {
		// Authorization Page Commands till Home page:
		driver.findElement(By.id("Email")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ContinueBtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("seccode")).sendKeys("64769644");
		driver.findElement(By.id("showhide")).click();
		driver.findElement(By.id("Device1")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ContinueBtn")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='col-md-12'] h3")).getText(),
				"Authorization Confirmed");
		System.out.println(driver.findElement(By.cssSelector("div[class='col-md-12'] h3")).getText());
		driver.findElement(By.id("ContinueBtn")).click();

	}

	//This below code will be allowed Cookies Pop-up
	@Test
	public static void Accept_Cookies() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Accept Cookies']")))
				.click();
	}

	//This code would be Close the Browser
	@AfterTest
	public static void Tire_Down() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}