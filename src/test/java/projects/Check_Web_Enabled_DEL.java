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
//					{"911378401","Test@1234"},  //911378401:AFNMFX
//					{"911378402","Test@1234"},  //911378402:AFNMFX
//					{"911378403","Test@1234"},  //911378403:AFNMFX
//					{"911378404","Test@1234"},  //911378404:AFNMFX
//					{"911378405","Test@1234"},  //911378405:AFNMFX
//					{"911378406","Test@1234"},  //911378406:AFNMFX
//					{"911378407","Test@1234"},  //911378407:AFNMFX
//					{"911378408","Test@1234"},  //911378408:AFNMFX
//					{"911378409","Test@1234"},  //911378409:AFNMFX
//					{"911378410","Test@1234"},  //911378410:AFNMFX
//					{"911378411","Test@1234"},  //911378411:AFNMFX
//					{"911378412","Test@1234"},  //911378412:AFNMFX
//					{"911378413","Test@1234"},  //911378413:AFNMFX
//					{"911378414","Test@1234"},  //911378414:AFNMFX
//					{"911378415","Test@1234"},  //911378415:AFNMFX
//					{"911378416","Test@1234"},  //911378416:LFROPX
//					{"911378417","Test@1234"},  //911378417:LFROPX
//					{"911378418","Test@1234"},  //911378418:LFROPX
//					{"911378419","Test@1234"},  //911378419:LFROPX
//					{"911378420","Test@1234"},  //911378420:LFROPX
//					{"911378421","Test@1234"},  //911378421:LFROPX - Not Web Enabled
//					{"911378422","Test@1234"},  //911378422:LFROPX
//					{"911378423","Test@1234"},  //911378423:LFROPX
//					{"911378424","Test@1234"},  //911378424:LFROPX
//					{"911378425","Test@1234"},  //911378425:LFROPX
//					{"911378426","Test@1234"},  //911378426:LFROPX
//					{"911378427","Test@1234"},  //911378427:LFROPX - Not Web Enabled
//					{"911378428","Test@1234"},  //911378428:LFROPX
//					{"911378429","Test@1234"},  //911378429:LFROPX
//					{"911378430","Test@1234"},  //911378430:LFROPX
//					{"911378431","Test@1234"},  //911378431:LFROPX
//					{"911378432","Test@1234"},  //911378432:LFROPX
//					{"911378433","Test@1234"},  //911378433:LFROPX
//					{"911378434","Test@1234"},  //911378434:LFROPX
//					{"911378435","Test@1234"},  //911378435:LFROPX
//					{"911378436","Test@1234"},  //911378436:LFROPX
//					{"911378437","Test@1234"},  //911378437:LFROPX
//					{"911378438","Test@1234"},  //911378438:LFROPX
//					{"911378439","Test@1234"},  //911378439:LFROPX
//					{"911378440","Test@1234"},  //911378440:LFROPX
//					{"911378441","Test@1234"},  //911378441:LFROPX
//					{"911378442","Test@1234"},  //911378442:LFROPX
//					{"911378443","Test@1234"},  //911378443:ASPPGN
//					{"911378444","Test@1234"},  //911378444:ASPPGN
//					{"911378445","Test@1234"},  //911378445:ASPPGN
//					{"911378446","Test@1234"},  //911378446:ASPPGN
//					{"911378447","Test@1234"},  //911378447:ASPPGN
//					{"911378448","Test@1234"},  //911378448:ASPPGN

					// Add more username-password pairs as needed
			};

			// Loop through credentials and perform logins
			for (String[] credential : credentials) {
				String username = credential[0];
				String password = credential[1];

				// Below Command to put the URL:
				driver.get("https://qa6.lifeatworkportal.com/deloitte");
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