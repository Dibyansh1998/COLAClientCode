package projects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Electmaint_Make_Election {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Calendar

		Calendar cal = Calendar.getInstance();
		Date time = cal.getTime();
		String timestamp = time.toString().replace(":", "_").replace(" ", "_");

		String[][] credentials = {

				{ "911316451", "Test@1234" }, // 911316451:ASEMGN
				{ "911316452", "Test@1234" }, // 911316452:TSEMGN
				{ "911316453", "Test@1234" }, // 911316453:ASEMCN
				{ "911316454", "Test@1234" }, // 911316454:TTEMGN
				{ "911316455", "Test@1234" }, // 911316455:RSEMGN
				{ "911316456", "Test@1234" }, // 911316456:TSEMCN
				{ "911316457", "Test@1234" }, // 911316457:ASMDGN
				{ "911316458", "Test@1234" }, // 911316458:ASPPGN
				{ "911316459", "Test@1234" }, // 911316459:RSPPGN
				{ "911316460", "Test@1234" }, // 911316460:TSEMGW
				{ "911316461", "Test@1234" }, // 911316461:PSEMGN
				{ "911316462", "Test@1234" }, // 911316462:RSMDGN
				{ "911316463", "Test@1234" }, // 911316463:OSEMGN
				{ "911316464", "Test@1234" }, // 911316464:CSEMGC
				{ "911316465", "Test@1234" }, // 911316465:TSMDGN
				{ "911316466", "Test@1234" }, // 911316466:TSPPGN

		};

		// Loop through credentials and perform logins
		for (String[] credential : credentials) {
			String username = credential[0];
			String password = credential[1];

			// Below Command to put the URL:
			driver.get("https://qa6.lifeatworkportal.com/deloitte");

			// Log In Page Command
			WebElement usernameInput = driver.findElement(By.id("USERNAME"));
			usernameInput.sendKeys(username);
			WebElement passwordInput = driver.findElement(By.id("password"));
			passwordInput.sendKeys(password);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showhide")));
			driver.findElement(By.id("showhide")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='ContinueBtn']"))).click();

			// Authorization Page Commands up to Home page:
			driver.findElement(By.id("Email")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ContinueBtn"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("seccode"))).sendKeys("64769644");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showhide"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ContinueBtn"))).click();

			// Click on Allow Cookies Button on Home Page
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//button[@class='btn btn-primary mr-10'])[1]")));
			driver.findElement(By.xpath("(//button[@class='btn btn-primary mr-10'])[1]")).click();

			// Click on the Life Event
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Life Events']")))
					.click();

			// Click on Make Election Button
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//span[@class='makeElectionBut ng-scope ng-isolate-scope'])[1]"))).click();

			// Click on Expand All Button on Make Election Page
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='expand all']")))
					.click();

//			// Specify the destination folder path
//			String folderPath = "C:\\Users\\52304535\\OneDrive - Conduent\\Documents\\OneNote Notebooks\\Screenshots\\"
//					+ username + "\\";
//
//			// Create the folder if it doesn't exist
//			File folder = new File(folderPath);
//			if (!folder.exists()) {
//				folder.mkdirs(); // Create folder and parent directories if necessary
//			}

			// Take ScreenShot Command
			WebElement ele = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='row makeElectionPageRow ng-scope']")));

			// Ensure the element is within the viewport
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
			Thread.sleep(1000);
			Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider())
					.shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver, ele);

			Thread.sleep(1000);
			// Specify the destination where the screenshot will be saved

			File destination = new File(
					System.getProperty("user.dir") + "ScreenShots\\snagit_" + timestamp + "_" + username + ".png");

			// Save the screenshot to the specified file
			Thread.sleep(1000);
			ImageIO.write(screenshot.getImage(), "PNG", destination);

			Thread.sleep(2000);
			System.out.println("Screenshot saved at: " + destination.getAbsolutePath());

			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(2000);

			// Click on Hamburger Menu
			WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.cssSelector("a[aria-label='Hamburger Menu'] span[class='glyphicons glyphicons-menu-hamburger']")));
			// Ensure the element is within the viewport
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
			ele1.click();
			Thread.sleep(2000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//a[@class='ng-scope ng-isolate-scope'][normalize-space()='Log out']"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("logout"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='site again']")))
					.click();

		}

		// Quit the driver
		driver.quit();
	}
}
