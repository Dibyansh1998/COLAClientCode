package projects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Kronos_Automate {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://conduent.sharepoint.com/sites/ConduentConnect2");
		Thread.sleep(4000);
		driver.findElement(By.id("i0116")).sendKeys("dibyansh.verma@conduent.com");
		driver.findElement(By.id("idSIButton9")).click();
		
		Thread.sleep(7000);
		driver.findElement(By.id("passwordInput")).sendKeys("Ram@1998");
		Thread.sleep(3000);
		driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("idSIButton9")).click();
		
		// Click on APAC link on Kronos
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='ms-HorizontalNavItem-linkText is-not-selected linkUnselected-84']")).click();
		
		//Click on India Resource Tools
		Thread.sleep(4000);
		driver.findElement(By.id("QuicklinksItemTitle")).click();
		
		Thread.sleep(2000);
		//For using the scroll bar on the page:
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
	js4.executeScript("window.scrollBy(0,800)", "");
	Thread.sleep(3000);
		//Click on the Drop Down
		driver.findElement(By.id("india-human-resources")).click();
//		driver .findElement(By.xpath("//u[contains(text(),'ConduentConnect 2.0​​​​​​​')]")).click();

	}

}
