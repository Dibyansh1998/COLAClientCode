package projects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Check_Web_Enabled_COLA {

	static String output;

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// Get the current time stamp
//		long currentTimeMillis = System.currentTimeMillis();
//
//		String timestamp = String.valueOf(currentTimeMillis);
//		String time = timestamp.replace(":", "").replace(" ", "_");
//
//		// Define the file path where you want to store the console output
//		String filePath = "C:\\Users\\dibya\\OneDrive\\Documents\\OneNote Notebooks\\Console Output\\console_output_" + time + ".txt";
//
//		// Redirect System.out to the file
//		try {
//			File file = new File(filePath);
//			FileOutputStream fos = new FileOutputStream(file);
//			PrintStream ps = new PrintStream(fos);
//			System.setOut(ps);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}

		try {
			// Define an array of username-password pairs
			String[][] credentials = { 
					
					{"911317101","Test@1234"},  //911317101:AFNMFX
					{"911317102","Test@1234"},  //911317102:AFNMFX
					{"911317103","Test@1234"},  //911317103:AFNMFX
					{"911317104","Test@1234"},  //911317104:AFNMFX
					{"911317105","Test@1234"},  //911317105:AFNMFX
					{"911317106","Test@1234"},  //911317106:AFNMFX
					{"911317107","Test@1234"},  //911317107:AFNMFX
					{"911317108","Test@1234"},  //911317108:AFNMFX
					{"911317109","Test@1234"},  //911317109:AFNMFX
					{"911317110","Test@1234"},  //911317110:AFNMFX
					{"911317111","Test@1234"},  //911317111:AFNMFX
					{"911317112","Test@1234"},  //911317112:AFNMFX
					{"911317113","Test@1234"},  //911317113:AFNMFX
					{"911317114","Test@1234"},  //911317114:AFNMFX
					{"911317115","Test@1234"},  //911317115:AFNMFX
//					
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

				System.out.println("" + username + " is Web Enabled!!!");

			}

		} catch (InterruptedException e) {
			e.printStackTrace();

		}

		finally {

			// Close the browser session
			driver.quit();
		}

	}

}
