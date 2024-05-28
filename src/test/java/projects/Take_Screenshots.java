package projects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public class Take_Screenshots {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Calendar
		
				Calendar cal= Calendar.getInstance();
				Date time= cal.getTime();
				
				String timestamp= time.toString().replace(":", "_").replace(" ", "_");				
//				System.out.println(time);
//				System.out.println(TimeStamp);

		// Put any URL as you want
		driver.get("https://www.google.com");
		
		

		// Take ScreenShot Command
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Thread.sleep(2000);
		FileUtils.copyFile(src, new File("C:\\Users\\dibya\\OneDrive\\Documents\\OneNote Notebooks\\snagits_"+timestamp+".png"));
		
		Thread.sleep(2000);
		driver.close();
		// Specify the destination folder path
//		String folderPath = "C:\\Users\\52304535\\OneDrive - Conduent\\Documents\\OneNote Notebooks\\Screenshots\\"
//				+ username + "\\";
//
//		// Create the folder if it doesn't exist
//		File folder = new File(folderPath);
//		if (!folder.exists()) {
//			folder.mkdirs(); // Create folder and parent directories if necessary
//		}
		
		
		// Take ScreenShot Command
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='row makeElectionPageRow ng-scope']")));

		// Ensure the element is within the viewport
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(1000);
		Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider())
				.shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver, ele);

		// Specify the destination where the screenshot will be saved
		File destination = new File( "C:\\Users\\52304535\\OneDrive - Conduent\\Documents"
				+ "\\OneNote Notebooks\\Screenshots\\snagits_" + timestamp +".png");

		// Save the screenshot to the specified file
		ImageIO.write(screenshot.getImage(), "PDF", destination);

		Thread.sleep(2000);
		System.out.println("Screenshot saved at: " + destination.getAbsolutePath());

		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);


	}

}
