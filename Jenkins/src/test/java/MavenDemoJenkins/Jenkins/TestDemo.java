package MavenDemoJenkins.Jenkins;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDemo {

	public WebDriver driver;

	@Test

	public void main() {
		WebElement hdrYourLogo = driver.findElement(By.xpath("//div[@id='header_logo']"));

		if (hdrYourLogo.isDisplayed()) {

			driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();

			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("btest@gmail.com");

			driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Btest@123");

			driver.findElement(By.id("SubmitLogin")).click();

			WebElement hdrHomePage = driver.findElement(By.xpath("//h1[text()='My account']"));

			if (hdrHomePage.isDisplayed()) {
				System.out.println("Home page is Displayed...");
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			WebElement lnkHome = driver.findElement(By.xpath("//a[@title='Return to Home']"));
			lnkHome.click();

			// driver.findElement(By.xpath("//a[normalize-space()='Sign out']")).click();

		}
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "E:\\Mahesh\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}

	@AfterMethod
	public void afterMethod() {

		driver.quit();

	}
}
