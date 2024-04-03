package projects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Check_Web_Enabled {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		try {
			// Define an array of username-password pairs
			String[][] credentials = { { "911317101", "Test@1234" }, 
															{ "911317102", "Test@1234" },
															{ "911317103", "Test@1234" }
					// Add more username-password pairs as needed
			};

			// Loop through credentials and perform logins
			for (String[] credential : credentials) {
				String username = credential[0];
				String password = credential[1];

				// Below Command to put the URL:
				driver.get("https://pp.lifeatworkportal.com/countyofla");
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

				// Log In Page Command
				// Find the UserName and password input fields and enter credentials
				WebElement usernameInput = driver.findElement(By.id("USERNAME"));
				usernameInput.sendKeys(username);
				WebElement passwordInput = driver.findElement(By.id("password"));
				passwordInput.sendKeys(password);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showhide")));
				driver.findElement(By.id("showhide")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("ContinueBtn")).click();

				// Authorization Page Command
				driver.findElement(By.id("CancelBtn")).click();

				// Click on Site Again Link Command
				driver.findElement(By.cssSelector("a[href='/countyofla']")).click();
				System.out.println("User " +"("+ username +")"+ " is successfully Logged Out!!!");

			}

		} catch (InterruptedException e) {
			e.printStackTrace();

		} finally {

			// Close the browser session
			driver.quit();
		}

	}

}
