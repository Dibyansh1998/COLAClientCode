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
//					{"911320046","Test@1234"},  //911320046:AFRCHX
//					{"911320047","Test@1234"},  //911320047:AFROPX
//					{"911320048","Test@1234"},  //911320048:AFNMFX
//					{"911320049","Test@1234"},  //911320049:AFNFLX
//					{"911320050","Test@1234"},  //911320050:APNMFX
//					{"911320051","Test@1234"},  //911320051:APNFLX
//					{"911320052","Test@1234"},  //911320052:APRCHX
//					{"911320053","Test@1234"},  //911320053:APROPX
//					{"911320054","Test@1234"},  //911320054:ATNMFX
////					{"911320055","Test@1234"},  //911320055:ATRFLX
//					{"911320056","Test@1234"},  //911320056:ATRCHX
//					{"911320057","Test@1234"},  //911320057:ATROPX
//					{"911320058","Test@1234"},  //911320058:LFNMFX
//					{"911320059","Test@1234"},  //911320059:LFNFLX
//					{"911320060","Test@1234"},  //911320060:LFRCHX
////					{"911320061","Test@1234"},  //911320061:LFROPX
//					{"911320062","Test@1234"},  //911320062:LFROPX
//					{"911320063","Test@1234"},  //911320063:LFROPX
//					{"911320064","Test@1234"},  //911320064:LFROPX
//					{"911320065","Test@1234"},  //911320065:LFROPX
//					{"911320066","Test@1234"},  //911320066:LFROPX
//					{"911320067","Test@1234"},  //911320067:LFROPX
//					{"911320068","Test@1234"},  //911320068:LFROPX
//					{"911320069","Test@1234"},  //911320069:LFROPX
//					{"911320070","Test@1234"},  //911320070:LFROPX
//					{"911320071","Test@1234"},  //911320071:LFROPX
////					{"911320072","Test@1234"},  //911320072:LFROPX
//					{"911320073","Test@1234"},  //911320073:LFROPX
//					{"911320074","Test@1234"},  //911320074:LFROPX
//					{"911320075","Test@1234"},  //911320075:LFROPX
//					{"911320076","Test@1234"},  //911320076:LFROPX
//					{"911320077","Test@1234"},  //911320077:LFROPX
//					{"911320078","Test@1234"},  //911320078:LFROPX
//					{"911320079","Test@1234"},  //911320079:LFROPX
//					{"911320080","Test@1234"},  //911320080:LFROPX
//					{"911320081","Test@1234"},  //911320081:LFROPX
//					{"911320082","Test@1234"},  //911320082:LFROPX
//					{"911320083","Test@1234"},  //911320083:LFROPX
//					{"911320084","Test@1234"},  //911320084:LFROPX
//					{"911320085","Test@1234"},  //911320085:LFROPX
//					{"911320086","Test@1234"},  //911320086:LFROPX
					{"911320087","Test@1234"},  //911320087:LFROPX



					// Add more username-password pairs as needed
			};

			// Loop through credentials and perform logins
			for (String[] credential : credentials) {
				String username = credential[0];
				String password = credential[1];

				// Below Command to put the URL:
				driver.get("https://pp.lifeatworkportal.com/deloitte");
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
				driver.findElement(By.xpath("//button[@id='ContinueBtn']")).click();

				Thread.sleep(2000);
				// Authorization Page Command
				driver.findElement(By.cssSelector("#CancelBtn")).click();
				System.out.println("This User" +"("+ username +")"+ " is Web Enabled!!!");
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