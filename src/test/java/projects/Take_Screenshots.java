package projects;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

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

	}

}
