package projects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Run_Existing_Birth_Event {

	static WebDriver driver;
	static WebDriverWait wait;
	 

	public static void main(String[] args) throws InterruptedException {
		Launch_COLA_Site();
		LogIn_Page();
		Authorization_Page();
		LifeEventExecution();
		ClickMakeElectionButton();
		DependentScreenData();
//		Tire_Down();

	}

	// Below Command to use to Launch the Browser and Open your Client Site
	@BeforeTest
	public static void Launch_COLA_Site() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// Below Command to put the URL:
		driver.get("https://www6.lifeatworkportal.com/countyofla");
		wait = new WebDriverWait(driver, Duration.ofSeconds(25));

	}

	// Below Command to use to put your UserName and Password and then click
	// LogIn-Button
	@Test
	public static void LogIn_Page() throws InterruptedException {

		// Log in page Commands:
		driver.findElement(By.id("USERNAME")).sendKeys("911317008");
		driver.findElement(By.id("password")).sendKeys("Ishu@1998");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showhide")));
		driver.findElement(By.id("showhide")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ContinueBtn")).click();
	}

	// This Code will be execute to check the Authorization page
	@Test
	public static void Authorization_Page() throws InterruptedException {
		// Authorization Page Commands till Home page:
		driver.findElement(By.id("Email")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ContinueBtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("seccode")).sendKeys("64769644");
		driver.findElement(By.id("showhide")).click();
		driver.findElement(By.id("Device1")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ContinueBtn")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='col-md-12'] h3")).getText(),
				"Authorization Confirmed");
		System.out.println(driver.findElement(By.cssSelector("div[class='col-md-12'] h3")).getText());
		driver.findElement(By.id("ContinueBtn")).click();

	}

	// This below code will be allowed Cookies Pop-up and Click on Life Event Tab
	@Test
	public static void LifeEventExecution() throws InterruptedException {
		Thread.sleep(5000);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Accept Cookies']")))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='Life Events']")).click();

	}

	@Test
	public static void ClickMakeElectionButton() throws InterruptedException {

		Thread.sleep(9000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@class='makeElectionBut ng-scope ng-isolate-scope']")))
				.click();
		Thread.sleep(14000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,600)", "");
		Thread.sleep(3000);
		js.executeScript("window.scrollTo(0,200)", "");
		//Below line of code will click on Change button of Medical Benefit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@name='leEnrollChange'])[1]"))).click();
		js.executeScript("window.scrollTo(0,1200)","");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='glyphicons glyphicons-plus-sign'])[1]"))).click();
		js.executeScript("window.scrollTo(0,800)","");
	}
	@Test
	public static void DependentScreenData() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']"))).sendKeys("Assane");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@placeholder='Middle Name']")).sendKeys("Michele");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Lupin");
		Thread.sleep(1500);
		JavascriptExecutor js1= (JavascriptExecutor)driver;
		js1.executeScript("window.scrollTo(0,1200)","");
		Thread.sleep(1000);
		js1.executeScript("window.scrollTo(0,300)","");
		driver.findElement(By.cssSelector(".glyphicon.glyphicon-calendar")).click();
		Thread.sleep(1500);
//		driver.findElement(By.xpath("//div[@class='datetimepicker-years']//th[@class='prev']")).click();
		for(int i=0;i<2;i++)
		{
			driver.findElement(By.xpath("//div[@class='datetimepicker-years']//th[@class='prev']")).click();
		}
		
		driver.findElement(By.xpath("//span[normalize-space()='2001']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[normalize-space()='Mar']")).click();
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(3)")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@name='ssn']")).sendKeys("911311000");
		Thread.sleep(1500);
		
		//Select the Gender
		WebElement genderOptions=driver.findElement(By.xpath("//select[@name='gender']"));
		Select genderdropdown= new Select(genderOptions);
		genderdropdown.selectByIndex(1);
		System.out.println(genderdropdown.getFirstSelectedOption().getText());
		
		//Select the Relation
		WebElement relationshipcode=driver.findElement(By.xpath("//select[@name='relation']"));
		Select relationcode= new Select(relationshipcode);
		relationcode.selectByIndex(2);
		System.out.println(relationcode.getFirstSelectedOption().getText());
		
		// Click on the Save button on Dependent Screen
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@name='leMakeElections_AddUpdateDependentFamilyMember']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("window.scrollTo(0,900)","");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("span[class='depName ng-scope'] input[class='familyMembersChck']")).click();
		js2.executeScript("window.scrollTo(0,1100)","");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@name='leElectionTableAContinue']")).click();
	}

	// This code would be Close the Browser
	@AfterTest
	public static void Tire_Down() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}