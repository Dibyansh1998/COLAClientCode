package projects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Check_Web_Enabled_DEL {
	
	
	@Test(groups="Smoke")
	public static void webenabledcheck()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		try {
			// Define an array of username-password pairs
			String[][] credentials = {

					{"911316451","Test@1234"},  //911316451:ASEMGN
					{"911316452","Test@1234"},  //911316452:TSEMGN
//					{"911316453","Test@1234"},  //911316453:ASEMCN
//					{"911316454","Test@1234"},  //911316454:TTEMGN
//					{"911316455","Test@1234"},  //911316455:RSEMGN
//					{"911316456","Test@1234"},  //911316456:TSEMCN
//					{"911316457","Test@1234"},  //911316457:ASMDGN
//					{"911316458","Test@1234"},  //911316458:ASPPGN
//					{"911316459","Test@1234"},  //911316459:RSPPGN
//					{"911316460","Test@1234"},  //911316460:TSEMGW
//					{"911316461","Test@1234"},  //911316461:PSEMGN
//					{"911316462","Test@1234"},  //911316462:RSMDGN
//					{"911316463","Test@1234"},  //911316463:OSEMGN
//					{"911316464","Test@1234"},  //911316464:CSEMGC
//					{"911316465","Test@1234"},  //911316465:TSMDGN
//					{"911316466","Test@1234"}  //911316466:TSPPGN

					// Add more username-password pairs as needed
			};

			// Loop through credentials and perform logins
			for (String[] credential : credentials) {
				String username = credential[0];
				String password = credential[1];

				// Below Command to put the URL:
				driver.get("https://qa6.lifeatworkportal.com/deloitte");
				// Use Duration.ofSeconds() instead of Duration.seconds()

				// Log In Page Command
				// Find the UserName and password input fields and enter credentials
				WebElement usernameInput = driver.findElement(By.id("USERNAME"));
				usernameInput.sendKeys(username);
				WebElement passwordInput = driver.findElement(By.id("password"));
				passwordInput.sendKeys(password);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showhide"))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='ContinueBtn']")))
						.click();
				System.out.println("This User" + "(" + username + ")" + " is able to click on Continue button on Home Page!!");

				// Authorization Page Command
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#CancelBtn"))).click();
				System.out.println("This User" + "(" + username + ")" + " is Web Enabled!!!");

				// Click on Site Again Link Command
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/deloitte']")))
						.click();

			}

		} finally {

			// Close the browser session
			driver.quit();
		}

	}
	
}