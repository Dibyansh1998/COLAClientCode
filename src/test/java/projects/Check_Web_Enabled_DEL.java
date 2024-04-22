package projects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Check_Web_Enabled_DEL {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		try {
			// Define an array of username-password pairs
			String[][] credentials = {
					{"911317301","Test@1234"},  //911317301:AFNMFX
					{"911317302","Test@1234"},  //911317302:AFNMFX
					{"911317303","Test@1234"},  //911317303:AFNMFX
					{"911317304","Test@1234"},  //911317304:AFNMFX
					{"911317305","Test@1234"},  //911317305:AFNMFX
					{"911317306","Test@1234"},  //911317306:AFNMFX
					{"911317307","Test@1234"},  //911317307:AFNMFX
					{"911317308","Test@1234"},  //911317308:AFNMFX
					{"911317309","Test@1234"},  //911317309:AFNMFX
					{"911317310","Test@1234"},  //911317310:AFNMFX
					{"911317311","Test@1234"},  //911317311:AFNMFX
					{"911317312","Test@1234"},  //911317312:AFNMFX
					{"911317313","Test@1234"},  //911317313:AFNMFX
					{"911317314","Test@1234"},  //911317314:AFNMFX
					{"911317315","Test@1234"},  //911317315:AFNMFX

					// Add more username-password pairs as needed
			};

			// Loop through credentials and perform logins
			for (String[] credential : credentials) {
				String username = credential[0];
				String password = credential[1];

				// Below Command to put the URL:
				driver.get("https://pp.lifeatworkportal.com/deloitte");
				// Use Duration.ofSeconds() instead of Duration.seconds()
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				// Log In Page Command
				// Find the UserName and password input fields and enter credentials
				WebElement usernameInput = driver.findElement(By.id("USERNAME"));
				usernameInput.sendKeys(username);
				WebElement passwordInput = driver.findElement(By.id("password"));
				passwordInput.sendKeys(password);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showhide")));
				driver.findElement(By.id("showhide")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@id='ContinueBtn']")).click();

				Thread.sleep(2000);
				// Authorization Page Command
				driver.findElement(By.cssSelector("#CancelBtn")).click();
				System.out.println("This User" + "(" + username + ")" + " is Web Enabled!!!");
//				driver.findElement(By.id("ContinueBtn")).click();
//				driver.findElement(By.xpath("//button[@id='CancelBtn']")).click();

				// Click on Site Again Link Command
				driver.findElement(By.cssSelector("a[href='/deloitte']")).click();

//				driver.findElement(By.xpath("//a[normalize-space()='site again']")).click();

			}

		} catch (InterruptedException e) {
			e.printStackTrace();

		} finally {

			// Close the browser session
			driver.quit();
		}

	}

}