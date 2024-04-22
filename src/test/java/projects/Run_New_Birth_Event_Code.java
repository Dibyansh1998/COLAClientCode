package projects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Run_New_Birth_Event_Code {
	
	

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// Below Command to put the URL:
		driver.get("https://pp.lifeatworkportal.com/countyofla");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Log in page Commands:
		driver.findElement(By.id("USERNAME")).sendKeys("911317101");
		driver.findElement(By.id("password")).sendKeys("Test@1234");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showhide")));
		driver.findElement(By.id("showhide")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ContinueBtn")).click();

		// Authorization Page Commands upto Home page:
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
		driver.findElement(By.id("ContinueBtn")).click();

		// Click on Allow Cookies Button on Home Page
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//button[@class='btn btn-primary mr-10'])[1]")));
		driver.findElement(By.xpath("(//button[@class='btn btn-primary mr-10'])[1]")).click();

	}
	

}
